package vue;

import controller.ControllerAccepter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VueAjoutClient extends JPanel{
    VueHotel main;
    JTextField nom;
    JTextField prenom;
    JButton confirmer;
    
    public VueAjoutClient(VueHotel main){
        super(new BorderLayout());
        this.main = main;
        JLabel titre = new JLabel("Ajouter Client");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
        JPanel formulaire = new JPanel(new GridLayout(2,2));
        JLabel nomL = new JLabel("Saisir nom : ");
        nom = new JTextField();
        JPanel nomJPanel = new JPanel(new BorderLayout());
        JLabel nomEltManquant = new JLabel("");
        nomEltManquant.setForeground(Color.red);
        nomJPanel.add(nom, BorderLayout.CENTER);
        nomJPanel.add(nomEltManquant, BorderLayout.SOUTH);
        formulaire.add(nomL);
        formulaire.add(nomJPanel);
        JLabel prenomL = new JLabel("Saisir prénom : ");
        prenom = new JTextField();
        JPanel prenomJPanel = new JPanel(new BorderLayout());
        JLabel prenomEltManquant = new JLabel("");
        prenomEltManquant.setForeground(Color.red);
        prenomJPanel.add(prenom, BorderLayout.CENTER);
        prenomJPanel.add(prenomEltManquant, BorderLayout.SOUTH);
        formulaire.add(prenomL);
        formulaire.add(prenomJPanel);
        this.add(formulaire, BorderLayout.CENTER);
        confirmer = new JButton("Confirmer");
        confirmer.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmer.setBackground(Color.green);
        this.add(confirmer, BorderLayout.SOUTH);
        Vector<JTextField> listJTextFields = new Vector<JTextField>(0);
        listJTextFields.add(nom);
        listJTextFields.add(prenom);
        Vector<JLabel> listJLabels = new Vector<JLabel>(0);
        listJLabels.add(nomEltManquant);
        listJLabels.add(prenomEltManquant);
        ControllerAccepter accepter = new ControllerAccepter(this.main, titre.getText(), listJTextFields, listJLabels, null, null);
        confirmer.addActionListener(accepter);
    }
}