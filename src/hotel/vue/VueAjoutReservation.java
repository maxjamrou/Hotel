package vue;

import controller.ControllerRecherche;
import controller.ControllerSuivPrec;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VueAjoutReservation extends JPanel {
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

    public VueAjoutReservation(VueHotel main) {
        super(new GridBagLayout());
        this.main = main;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.weightx = 1;

        JLabel titre = new JLabel("Ajouter réservation");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 0;
        gbc.weighty = 0;
        this.add(titre, gbc);

        JPanel formulaire = new JPanel(new GridBagLayout());
        GridBagConstraints f = new GridBagConstraints();
        f.insets = new Insets(5, 5, 5, 5);
        f.fill = GridBagConstraints.HORIZONTAL;

        this.jourDebField   = new JTextField();
        this.moisDebField   = new JTextField();
        this.anneeDebField  = new JTextField();
        this.jourFinField   = new JTextField();
        this.moisFinField   = new JTextField();
        this.anneeFinField  = new JTextField();
        this.nomClient      = new JTextField();
        this.prenomClient   = new JTextField();

        JLabel dateDebEltManquant = new JLabel(" ");
        JLabel dateFinEltManquant = new JLabel(" ");
        JLabel errClientSelectionne = new JLabel(" ");
        dateDebEltManquant.setForeground(Color.RED);
        dateFinEltManquant.setForeground(Color.RED);
        errClientSelectionne.setForeground(Color.RED);

        JPanel dateDebPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        dateDebPanel.add(jourDebField = new JTextField(4));
        dateDebPanel.add(new JLabel("/"));
        dateDebPanel.add(moisDebField = new JTextField(4));
        dateDebPanel.add(new JLabel("/"));
        dateDebPanel.add(anneeDebField = new JTextField(6));

        JPanel dateFinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        dateFinPanel.add(jourFinField = new JTextField(4));
        dateFinPanel.add(new JLabel("/"));
        dateFinPanel.add(moisFinField = new JTextField(4));
        dateFinPanel.add(new JLabel("/"));
        dateFinPanel.add(anneeFinField = new JTextField(6));
        f.gridx = 0;
        f.gridy = 0;
        f.weightx = 0;
        formulaire.add(new JLabel("Début (jj/mm/aaaa) :"), f);
        f.gridx = 1;
        f.weightx = 1;
        formulaire.add(dateDebPanel, f);
        f.gridx = 2;
        f.weightx = 0;
        formulaire.add(new JLabel(" "), f);
        f.gridx = 3;
        f.weightx = 1;
        formulaire.add(dateDebEltManquant, f);
        f.gridx = 0;
        f.gridy = 1;
        f.weightx = 0;
        formulaire.add(new JLabel("Fin (jj/mm/aaaa) :"), f);
        f.gridx = 1;
        f.weightx = 1;
        formulaire.add(dateFinPanel, f);
        f.gridx = 2;
        f.weightx = 0;
        formulaire.add(new JLabel(" "), f);
        f.gridx = 3;
        f.weightx = 1;formulaire.add(dateFinEltManquant, f);

        f.gridx = 0;
        f.gridy = 2;
        f.weightx = 0;
        formulaire.add(new JLabel("Nom :"), f);
        f.gridx = 1;
        f.weightx = 1;
        formulaire.add(nomClient, f);
        f.gridx = 2;
        f.weightx = 0;
        formulaire.add(new JLabel("Prénom :"), f);
        f.gridx = 3;
        f.weightx = 1;
        formulaire.add(prenomClient, f);

        JButton rechercheClient = new JButton("Rechercher client");
        f.gridx = 0;
        f.gridy = 3;
        f.weightx = 1;
        f.fill = GridBagConstraints.HORIZONTAL;
        f.gridwidth = 4;
        formulaire.add(rechercheClient, f);
        f.gridwidth = 1;

        DefaultTableModel model = new DefaultTableModel();
        clientsTable = new JTable(model);
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addColumn("Client");
        clientsTable.removeColumn(clientsTable.getColumn("Client"));
        JScrollPane scrollPane = new JScrollPane(clientsTable);

        f.gridx = 0;
        f.gridy = 4;
        f.weightx = 1;
        f.weighty = 1;
        f.fill = GridBagConstraints.BOTH;
        f.gridwidth = 3;
        formulaire.add(scrollPane, f);
        f.gridwidth = 1;
        f.weighty = 0;
        f.gridx = 3;
        f.fill = GridBagConstraints.HORIZONTAL;
        formulaire.add(errClientSelectionne, f);
        gbc.gridy = 1;
        gbc.weighty = 1;
        this.add(formulaire, gbc);
        JButton suivant = new JButton("Suivant");
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(suivant, gbc);

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
        lJLabelsDate.add(errClientSelectionne);

        Vector<JTextField> lFieldsResearch = new Vector<>();
        lFieldsResearch.add(nomClient);
        lFieldsResearch.add(prenomClient);

        Vector<JLabel> lJLabelsResearch = new Vector<>();
        JLabel clientEltManquant = new JLabel(" ");
        clientEltManquant.setForeground(Color.RED);
        lJLabelsResearch.add(clientEltManquant);

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
        suivant.addActionListener(new ControllerSuivPrec(this.main, this.clientsTable, lJLabelsDate, lFieldsDate));
    }

    public JTable getTable() { return this.clientsTable; }
}