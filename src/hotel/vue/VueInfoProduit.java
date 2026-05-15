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
import model.Produit;

public class VueInfoProduit extends JPanel{
    VueHotel main;
    JLabel titre;
    Produit produit;

    public VueInfoProduit(VueHotel main){
        super(new BorderLayout(3,3));
        this.main = main;
        titre = new JLabel();
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }

    public void refresh(Produit p){
        this.produit = p;
        titre.setText("Information client " + p.getName());

        JPanel formulaire = new JPanel(new GridLayout(1,2, 3, 3));


        Vector<JTextField> textFields = new Vector<>();
        Vector<JLabel> erreursMessage = new Vector<>();
        
        JLabel prixL = new JLabel("Prix du produit");
        
        JPanel prixJPanel = new JPanel(new BorderLayout());
        
        JTextField prix = new JTextField(produit.getPrice() + "");
        JLabel prixEltManquant = new JLabel();
        
        textFields.add(prix);
        erreursMessage.add(prixEltManquant);

        
        prixJPanel.add(prix, BorderLayout.CENTER);
        prixJPanel.add(prixEltManquant, BorderLayout.SOUTH);

        JPanel boutons = new JPanel();
        JButton enregistrer = new JButton("Enregistrer modifications produit");
        JButton annuler = new JButton("Annuler modifications produit");

        enregistrer.addActionListener(new ControllerEnregistrer(main, textFields, erreursMessage, this.produit));
        annuler.addActionListener(new ControllerAnnuler(main));

        boutons.add(enregistrer);
        boutons.add(annuler);

        formulaire.add(prixL);
        formulaire.add(prixJPanel);

        this.add(formulaire, BorderLayout.CENTER);
        this.add(boutons, BorderLayout.SOUTH);
    }
}
