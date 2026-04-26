package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VueAjoutClient extends JPanel{
    JLabel nomL;
    JTextField nom;
    JLabel prenomL;
    JTextField prenom;
    JButton confirmer;

    public VueAjoutClient(){
        super(new BorderLayout());
        JLabel titre = new JLabel("Ajouter Client");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
        JPanel formulaire = new JPanel(new GridLayout(2,2));
        nomL = new JLabel("Saisir nom : ");
        nom = new JTextField();
        formulaire.add(nomL);
        formulaire.add(nom);
        prenomL = new JLabel("Saisir prénom : ");
        prenom = new JTextField();
        formulaire.add(prenomL);
        formulaire.add(prenom);
        this.add(formulaire, BorderLayout.CENTER);
        confirmer = new JButton("Confirmer");
        confirmer.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmer.setBackground(Color.green);
        this.add(confirmer, BorderLayout.SOUTH);
    }
}