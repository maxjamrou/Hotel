package vue;

import controller.ControllerAnnuler;
import controller.ControllerEnregistrer;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Client;

public class VueInfoClient extends JPanel{
    VueHotel main;
    JLabel titre;
    Client client;

    public VueInfoClient(VueHotel main){
        super(new BorderLayout());
        this.main = main;
        this.titre = new JLabel();
        this.titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }

    public void refresh(Client c){
        this.client = c;
        titre.setText("Information client " + c.getNom() + " " + c.getPrenom());

        JPanel formulaire = new JPanel(new GridLayout(2, 2, 3, 3));

        JLabel nomL = new JLabel("Nom du client :");

        JPanel nomJPanel = new JPanel(new BorderLayout());

        Vector<JTextField> textFields = new Vector<>();
        Vector<JLabel> erreursMessage = new Vector<>();

        JTextField nom = new JTextField(client.getNom());
        JLabel nomEltManquant = new JLabel();

        textFields.add(nom);
        erreursMessage.add(nomEltManquant);

        nomJPanel.add(nom, BorderLayout.CENTER);
        nomJPanel.add(nomEltManquant, BorderLayout.SOUTH);

        JLabel prenomL = new JLabel("Prénom du client");

        JPanel prenomJPanel = new JPanel(new BorderLayout());

        JTextField prenom = new JTextField(client.getPrenom());
        JLabel prenomEltManquant = new JLabel();

        textFields.add(prenom);
        erreursMessage.add(prenomEltManquant);

        prenomJPanel.add(prenom, BorderLayout.CENTER);
        prenomJPanel.add(prenomEltManquant, BorderLayout.SOUTH);

        JPanel boutons = new JPanel();
        JButton enregistrer = new JButton("Enregistrer modifications client");
        JButton annuler = new JButton("Annuler modifications client");

        enregistrer.addActionListener(new ControllerEnregistrer(main, textFields, erreursMessage, this.client));
        annuler.addActionListener(new ControllerAnnuler(main));

        boutons.add(enregistrer);
        boutons.add(annuler);

        formulaire.add(nomL);
        formulaire.add(nomJPanel);
        formulaire.add(prenomL);
        formulaire.add(prenomJPanel);

        this.add(formulaire, BorderLayout.CENTER);
        this.add(boutons, BorderLayout.SOUTH);
    }
}
