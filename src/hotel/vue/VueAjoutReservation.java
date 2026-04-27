package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
        JPanel clientJPanel = new JPanel();
        clientJPanel.add(new JLabel("Nom :"));
        this.nomClient = new JTextField();
        clientJPanel.add(this.nomClient);
        clientJPanel.add(new JLabel("Prénom :"));
        this.prenomClient = new JTextField();
        clientJPanel.add(this.prenomClient);
        formulaire.add(clientJPanel);

        Object[][] data = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
        String[] column = {"Nom", "Prenom"};
        JTable clientsTable = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(clientsTable);
        // scrollPane.setVisible(false);
        formulaire.add(scrollPane, BorderLayout.SOUTH);
        this.add(formulaire, BorderLayout.CENTER);
        JButton confirmer = new JButton("Confirmer");
        confirmer.setBackground(Color.green);
        this.add(confirmer, BorderLayout.SOUTH);
    }
}
