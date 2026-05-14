package vue;

import controller.ControllerRecherche;
import controller.ControllerSuivPrec;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class VueAjoutReservation extends JPanel{
    VueHotel main;
    JTextField anneeDebField;
    JTextField moisDebField;
    JTextField jourDebField;
    JTextField anneeFinField;
    JTextField moisFinField;
    JTextField jourFinField;
    JTextField nomClient;
    JTextField prenomClient;
    Vector<JTextField> lFields;
    JTable clientsTable;


    public VueAjoutReservation(VueHotel main){
        super(new BorderLayout(3,3));
        this.main = main;
        JLabel titre = new JLabel("Ajouter réservation");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
        JPanel formulaire = new JPanel(new GridLayout(4, 2));
        formulaire.add(new JLabel("Début du séjour (jj/mm/aaaa) :"));
        JPanel dateDebErreurPanel = new JPanel(new BorderLayout());
        JLabel dateDebEltManquant = new JLabel("test");
        JPanel dateDebJPanel = new JPanel(new FlowLayout());
        this.jourDebField = new JTextField(5);
        this.jourDebField.setText("");
        dateDebJPanel.add(this.jourDebField);
        dateDebJPanel.add(new JLabel("/"));
        this.moisDebField = new JTextField(5);
        this.moisDebField.setText("");
        dateDebJPanel.add(moisDebField);
        dateDebJPanel.add(new JLabel("/"));
        this.anneeDebField = new JTextField(5);
        this.anneeDebField.setText("");
        dateDebEltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        dateDebJPanel.add(anneeDebField);
        dateDebErreurPanel.add(dateDebJPanel, BorderLayout.CENTER);
        dateDebErreurPanel.add(dateDebEltManquant, BorderLayout.NORTH);
        formulaire.add(dateDebErreurPanel);

        formulaire.add(new JLabel("Fin du séjour (jj/mm/aaaa) :"));
        JPanel dateFinErreurPanel = new JPanel(new BorderLayout());
        JLabel dateFinEltManquant = new JLabel("test");
        JPanel dateFinJPanel = new JPanel(new GridLayout(1,5));
        this.jourFinField = new JTextField(5);
        this.jourFinField.setText("");
        dateFinJPanel.add(this.jourFinField);
        dateFinJPanel.add(new JLabel("/"));
        this.moisFinField = new JTextField(5);
        this.moisFinField.setText("");
        dateFinJPanel.add(moisFinField);
        dateFinJPanel.add(new JLabel("/"));
        this.anneeFinField = new JTextField(5);
        this.anneeFinField.setText("");
        dateFinEltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        dateFinJPanel.add(anneeFinField);
        dateFinErreurPanel.add(dateFinJPanel, BorderLayout.CENTER);
        dateFinErreurPanel.add(dateFinEltManquant, BorderLayout.SOUTH);
        formulaire.add(dateFinErreurPanel);
        
        Vector<JTextField> lFieldsDate = new Vector<>();
        lFieldsDate.add(anneeDebField);
        lFieldsDate.add(moisDebField);
        lFieldsDate.add(jourDebField);
        lFieldsDate.add(anneeFinField);
        lFieldsDate.add(moisFinField);
        lFieldsDate.add(jourFinField);

        Vector<JLabel> lJLabelsDate = new Vector<>();
        lJLabelsDate.add(dateDebEltManquant);
        lJLabelsDate.add(dateFinEltManquant);
        
        formulaire.add(new JLabel("A quel nom : "));
        JPanel rechercheClientPanel = new JPanel(new BorderLayout());
        JPanel clientJPanel = new JPanel();
        rechercheClientPanel.add(clientJPanel, BorderLayout.CENTER);
        clientJPanel.add(new JLabel("Nom :"));
        this.nomClient = new JTextField(10);
        clientJPanel.add(this.nomClient);
        clientJPanel.add(new JLabel("Prénom :"));
        this.prenomClient = new JTextField(10);
        clientJPanel.add(this.prenomClient);
        formulaire.add(rechercheClientPanel);

        DefaultTableModel model = new DefaultTableModel();
        clientsTable = new JTable(model);
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addColumn("Client"); // utilisé pour ranger l'objet Client
        clientsTable.removeColumn(clientsTable.getColumn("Client")); // devient "invisible" dans le tableau, seulement accessible via le modèle du JTable
        JScrollPane scrollPane = new JScrollPane(clientsTable);
        // scrollPane.setVisible(false);
        formulaire.add(scrollPane, BorderLayout.SOUTH);
        
        JLabel errClientSelectionne = new JLabel();
        errClientSelectionne.setHorizontalAlignment(SwingConstants.CENTER);
        errClientSelectionne.setForeground(Color.red);
        formulaire.add(errClientSelectionne);
        lJLabelsDate.add(errClientSelectionne);

        JButton rechercheClient = new JButton("Rechercher client");
        clientJPanel.add(rechercheClient);
        Vector<JTextField> lFieldsResearch = new Vector<>();

        lFieldsResearch.add(nomClient);
        lFieldsResearch.add(prenomClient);
        Vector<JLabel> lJLabelsResearch = new Vector<>();
        JLabel clientEltManquant = new JLabel();
        clientEltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        rechercheClientPanel.add(clientEltManquant, BorderLayout.SOUTH);
        lJLabelsResearch.add(clientEltManquant);
        lJLabelsResearch.get(0).setForeground(Color.red);

        this.lFields = new Vector<>();
        this.lFields.add(anneeDebField);
        this.lFields.add(moisDebField);
        this.lFields.add(jourDebField);
        this.lFields.add(anneeFinField);
        this.lFields.add(moisFinField);
        this.lFields.add(jourFinField);
        this.lFields.add(nomClient);
        this.lFields.add(prenomClient);

        ControllerRecherche recherche = new ControllerRecherche(main.getHotel(), this.clientsTable, lFieldsResearch, lJLabelsResearch);
        rechercheClient.addActionListener(recherche);
        this.add(formulaire, BorderLayout.CENTER);
        JButton suivant = new JButton("Suivant");
        suivant.addActionListener(new ControllerSuivPrec(this.main, this.clientsTable, lJLabelsDate, lFieldsDate));
        this.add(suivant, BorderLayout.SOUTH);

        // JPanel boutonJPanel = new JPanel();
        // JButton suivant = new JButton("Suivant");
        // suivant.addActionListener(new ControllerSuivPrec(this.main, null));
        // boutonJPanel.add(suivant);
        // this.add(boutonJPanel, BorderLayout.SOUTH);
    }

    public JTable getTable(){return this.clientsTable;}
}
