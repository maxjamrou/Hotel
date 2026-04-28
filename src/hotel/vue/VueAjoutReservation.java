package vue;

import controller.ControllerRecherche;
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


    public VueAjoutReservation(VueHotel main){
        super(new BorderLayout());
        this.main = main;
        JLabel titre = new JLabel("Ajouter réservation");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
        JPanel formulaire = new JPanel(new GridLayout(4, 2));
        formulaire.add(new JLabel("Début du séjour :"));
        JPanel dateDebJPanel = new JPanel(new FlowLayout());
        this.jourDebField = new JTextField("jj");
        dateDebJPanel.add(this.jourDebField);
        dateDebJPanel.add(new JLabel("/"));
        this.moisDebField = new JTextField("mm");
        dateDebJPanel.add(moisDebField);
        dateDebJPanel.add(new JLabel("/"));
        this.anneeDebField = new JTextField("aaaa");
        dateDebJPanel.add(anneeDebField);
        formulaire.add(dateDebJPanel);
        formulaire.add(new JLabel("Fin du séjour"));
        JPanel dateFinJPanel = new JPanel(new GridLayout(1,5));
        this.jourFinField = new JTextField("jj");
        dateFinJPanel.add(this.jourFinField);
        dateFinJPanel.add(new JLabel("/"));
        this.moisFinField = new JTextField("mm");
        dateFinJPanel.add(moisFinField);
        dateFinJPanel.add(new JLabel("/"));
        this.anneeFinField = new JTextField("aaaa");
        dateFinJPanel.add(anneeFinField);
        formulaire.add(dateFinJPanel);
        formulaire.add(new JLabel("A quel nom : "));
        JPanel clientPanel = new JPanel(new BorderLayout());
        JPanel clientJPanel = new JPanel();
        clientPanel.add(clientJPanel, BorderLayout.CENTER);
        clientJPanel.add(new JLabel("Nom :"));
        this.nomClient = new JTextField("Insérer Nom");
        clientJPanel.add(this.nomClient);
        clientJPanel.add(new JLabel("Prénom :"));
        this.prenomClient = new JTextField("Insérer Prénom");
        clientJPanel.add(this.prenomClient);
        formulaire.add(clientJPanel);

        DefaultTableModel model = new DefaultTableModel();
        JTable clientsTable = new JTable(model);
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addRow(new String[] {"", ""});
        model.addRow(new String[] {"", ""});
        model.addRow(new String[] {"", ""});
        model.addRow(new String[] {"", ""});
        model.addRow(new String[] {"", ""});
        model.addRow(new String[] {"", ""});
        model.addRow(new String[] {"", ""});
        model.addRow(new String[] {"", ""});
        JScrollPane scrollPane = new JScrollPane(clientsTable);
        // scrollPane.setVisible(false);
        formulaire.add(scrollPane, BorderLayout.SOUTH);
        
        JButton rechercheClient = new JButton("Rechercher client");
        clientJPanel.add(rechercheClient);
        Vector<JTextField> lFields = new Vector<>();
        lFields.add(nomClient);
        lFields.add(prenomClient);
        Vector<JLabel> lJLabels = new Vector<>();
        lJLabels.add(new JLabel(""));
        clientPanel.add(lJLabels.get(0), BorderLayout.SOUTH);
        lJLabels.get(0).setForeground(Color.red);
        ControllerRecherche recherche = new ControllerRecherche(main.getHotel(), model, lFields, lJLabels);
        rechercheClient.addActionListener(recherche);
        this.add(formulaire, BorderLayout.CENTER);
        JButton suivant = new JButton("Suivant");
        this.add(suivant, BorderLayout.SOUTH);
    }
}
