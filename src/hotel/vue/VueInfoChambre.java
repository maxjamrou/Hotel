package vue;

import controller.ControllerAnnuler;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Chambre;

public class VueInfoChambre extends JPanel{
    VueHotel main;
    Chambre chambre;

    ImageIcon imgChambre;
    JLabel img;
    JPanel formulaire;
    JPanel textfieldJPanel;
    JTextField prix;
    JComboBox<String> listeTypeChambre;
    ButtonGroup minibar;

    // To Do : finir les information concernant une chambre (pour les modifier)
    //
    public VueInfoChambre(VueHotel main){
        super(new BorderLayout());
        this.main = main;

        this.imgChambre = new ImageIcon();
        this.img = new JLabel();
        this.formulaire = new JPanel(new BorderLayout());
        this.textfieldJPanel = new JPanel(new GridLayout(3, 2));
        Vector<String> listeType = new Vector<>();
        listeType.add("Simple");
        listeType.add("Double");
        listeType.add("Suite Normale");
        listeType.add("Suite Présidentielle");
        this.listeTypeChambre = new JComboBox<>(listeType);
        this.minibar = new ButtonGroup();

    }

    public void refresh(Chambre c){
        this.chambre = c;
        imgChambre = new ImageIcon("vue\\blabla.jpg");
        img = new JLabel(imgChambre);
        JLabel titre = new JLabel("Information chambre " + chambre.getFloor());
        titre.setHorizontalAlignment(SwingConstants.CENTER);

        this.formulaire.removeAll();
        this.textfieldJPanel.removeAll();
        JLabel prixL = new JLabel("Prix :");
        prix = new JTextField(this.chambre.getPrice() + "");

        JLabel typeChambreL = new JLabel("Type de chambre :");

        listeTypeChambre.setSelectedItem(this.chambre.getType());
        
        JLabel hasMinibarL = new JLabel("Minibar :");
        JRadioButton hasMinibar = new JRadioButton("Oui");
        JRadioButton hasNoMinibar = new JRadioButton("Non");
        if(this.chambre.hasMinibar()){
            hasMinibar.setSelected(true);
        } else {
            hasNoMinibar.setSelected(true);
        }
        this.minibar.add(hasMinibar);
        this.minibar.add(hasNoMinibar);
        JPanel radioButtons = new JPanel(new BorderLayout());
        radioButtons.add(hasMinibar, BorderLayout.WEST);
        radioButtons.add(hasNoMinibar, BorderLayout.EAST);

        textfieldJPanel.add(prixL);
        textfieldJPanel.add(prix);
        textfieldJPanel.add(typeChambreL);
        textfieldJPanel.add(listeTypeChambre);
        textfieldJPanel.add(hasMinibarL);
        textfieldJPanel.add(radioButtons);
        formulaire.add(textfieldJPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton enregistrer = new JButton("Enregistrer modifications chambre");
        JButton annuler = new JButton("Annuler modifications chambre");

        annuler.addActionListener(new ControllerAnnuler(main));
        buttonPanel.add(enregistrer);
        buttonPanel.add(annuler);
        formulaire.add(buttonPanel, BorderLayout.SOUTH);
        this.add(formulaire, BorderLayout.CENTER);
        this.add(img, BorderLayout.WEST);
        this.add(titre, BorderLayout.NORTH);
    }
}
