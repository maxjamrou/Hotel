package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VueAjoutChambre extends JPanel{
    JLabel etageL;
    JTextField etage;
    JLabel prixEuroL;
    JTextField prixEuro;
    JLabel euroL;
    JLabel typeChambreL;
    JComboBox<String> listeTypeChambre;
    JLabel minibarL;
    ButtonGroup minibar;
    JRadioButton hasMinibar;
    JRadioButton hasNoMinibar;
    JButton confirmer;

    public VueAjoutChambre(){
        super(new BorderLayout(3,3));
        JLabel titre = new JLabel("Ajouter Chambre");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
        JPanel formulaire = new JPanel(new GridLayout(4,2, 3, 3));
        etageL = new JLabel("Saisir étage : ");
        etage = new JTextField();
        formulaire.add(etageL);
        formulaire.add(etage);
        JPanel argent = new JPanel();
        argent.setLayout(new GridLayout(1,2));
        prixEuroL = new JLabel("Saisir prix chambre : ");
        formulaire.add(prixEuroL);
        prixEuro = new JTextField();
        argent.add(prixEuro);
        euroL = new JLabel("€/nuit");
        argent.add(euroL);
        formulaire.add(argent);
        typeChambreL = new JLabel("Saisir type chambre :");
        Vector<String> listeType = new Vector<>();
        listeType.add("Simple");
        listeType.add("Double");
        listeType.add("Suite Normale");
        listeType.add("Suite Présidentielle");
        listeTypeChambre = new JComboBox<>(listeType);
        formulaire.add(typeChambreL);
        formulaire.add(listeTypeChambre); 
        minibarL = new JLabel("La chambre possède un minibar : ");
        minibar = new ButtonGroup();
        hasMinibar = new JRadioButton("Oui");
        hasNoMinibar = new JRadioButton("Non");
        hasMinibar.setSelected(true);
        minibar.add(hasMinibar);
        minibar.add(hasNoMinibar);
        formulaire.add(minibarL);
        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new FlowLayout());
        radioButtons.add(hasMinibar);
        radioButtons.add(hasNoMinibar);
        formulaire.add(radioButtons);
        this.add(formulaire, BorderLayout.CENTER);
        confirmer = new JButton("Confirmer");
        confirmer.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmer.setBackground(Color.green);
        this.add(confirmer, BorderLayout.SOUTH);
    }
}
