package vue;

import controller.ControllerModifier;
import controller.ControllerRecherche;
import java.awt.BorderLayout;
import java.awt.Color;
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

public class VueRechercherClient extends JPanel{
    VueHotel main;
    JTable clientsTable;

    public VueRechercherClient(VueHotel main){
        super(new BorderLayout(3,3));
        this.main = main;

        JLabel titre = new JLabel("Rechercher client");
        titre.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel grille = new JPanel(new GridLayout(2, 1));

        JPanel rechercherClient = new JPanel(new BorderLayout());

        JPanel formulaire = new JPanel(new GridLayout(2, 2, 3, 3));

        JLabel nomL = new JLabel("Nom du client :");

        Vector<JTextField> textFields = new Vector<>();
        Vector<JLabel> erreursMessage = new Vector<>();

        JLabel eltManquant = new JLabel();
        eltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        eltManquant.setForeground(Color.red);

        JTextField nom = new JTextField();

        textFields.add(nom);
        
        JLabel prenomL = new JLabel("Prénom du client :");
        JTextField prenom = new JTextField();
        
        textFields.add(prenom);
        
        erreursMessage.add(eltManquant);

        formulaire.add(nomL);
        formulaire.add(nom);
        formulaire.add(prenomL);
        formulaire.add(prenom);

        DefaultTableModel model = new DefaultTableModel();
        this.clientsTable = new JTable(model);
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addColumn("Client"); // utilisé pour ranger l'objet Client
        this.clientsTable.removeColumn(this.clientsTable.getColumn("Client")); // devient "invisible" dans le tableau, seulement accessible via le modèle du JTable
        JScrollPane scrollPane = new JScrollPane(this.clientsTable);

        JLabel clientEltManquant = new JLabel();
        clientEltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        clientEltManquant.setForeground(Color.red);

        JButton rechercher = new JButton("Rechercher client");
        JButton modifier = new JButton("Modifier client");

        rechercher.addActionListener(new ControllerRecherche(this.main.getHotel(), clientsTable, textFields, erreursMessage));
        modifier.addActionListener(new ControllerModifier(main, clientsTable, clientEltManquant));

        rechercherClient.add(eltManquant, BorderLayout.NORTH);
        rechercherClient.add(formulaire, BorderLayout.CENTER);
        rechercherClient.add(rechercher, BorderLayout.SOUTH);

        JPanel tableau = new JPanel(new BorderLayout());
        tableau.add(clientEltManquant, BorderLayout.NORTH);
        tableau.add(scrollPane, BorderLayout.CENTER);
        tableau.add(modifier, BorderLayout.EAST);

        grille.add(tableau);
        grille.add(rechercherClient);

        this.add(titre, BorderLayout.NORTH);
        this.add(grille, BorderLayout.CENTER);
    }
}
