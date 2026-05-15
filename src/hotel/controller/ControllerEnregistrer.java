package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Chambre;
import model.Client;
import model.Produit;
import vue.VueGererChambre;
import vue.VueGererClient;
import vue.VueGererProduit;
import vue.VueHotel;
import vue.VueRechercherChambre;
import vue.VueRechercherClient;

public class ControllerEnregistrer implements ActionListener{
    VueHotel main;
    Vector<JTextField> listeJTextFields;
    Vector<JLabel> listJLabels;
    JRadioButton jRadioButton;
    JComboBox<String> jComboBox;
    Object objet;
    
    public ControllerEnregistrer(VueHotel main, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels, Object ob){
        this.main = main;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
        this.objet = ob;
    }

    public ControllerEnregistrer(VueHotel main, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels, JRadioButton jrb, JComboBox<String> jcb, Object ob){
        this.main = main;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
        this.jRadioButton = jrb;
        this.jComboBox = jcb;
        this.objet = ob;
    }


    @Override
    public void actionPerformed(ActionEvent e){
        boolean canBePerformed = true;
        Vector<String> listeStrFields = new Vector<String>();
        for (int i = 0; i < this.listeJTextFields.size(); i++) {
            listeStrFields.add(listeJTextFields.get(i).getText());
            if(listeStrFields.get(i).length() == 0){
                this.listJLabels.get(i).setText("*Elément manquant");
                this.listJLabels.get(i).setForeground(Color.red);
                canBePerformed = false;
            } else {
                this.listJLabels.get(i).setText("");
            }
        }
        double prix = 0.0;
        if(((JButton)e.getSource()).getText().equals("Enregistrer modifications chambre") || ((JButton)e.getSource()).getText().equals("Enregistrer modifications produit")){
            try{
                prix = Double.parseDouble(listeStrFields.get(0));
            } catch(NumberFormatException ex) {
                if(listeStrFields.get(0).length()!=0){
                    listeJTextFields.get(0).setText("");
                    listJLabels.get(0).setText("*Element doit être un nombre");
                    this.listJLabels.get(0).setForeground(Color.red);
                    canBePerformed = false;
                }
            }
        }
        if(canBePerformed){
            if(prix<0){prix=-prix;}
            this.main.getContentPane().removeAll();
            switch (((JButton)e.getSource()).getText()) {
                case "Enregistrer modifications client":
                    Client client = (Client)this.objet;
                    client.setNom(listeStrFields.get(0));
                    client.setPrenom(listeStrFields.get(1));
                    ((VueGererClient)this.main.listeActions.get(2)).refresh();
                    this.main.listeActions.set(1, new VueRechercherClient(main));
                    this.main.getContentPane().add(this.main.getListeActions().get(2));
                    this.main.repaint();
                    break;
                case "Enregistrer modifications chambre":
                    Chambre chambre = (Chambre)this.objet;
                    boolean hasMinibar = true;
                    if(this.jRadioButton.isSelected()){hasMinibar = false;}
                    chambre.setPrice(prix);
                    chambre.setTypeChambre((String)this.jComboBox.getSelectedItem());
                    chambre.setHasMinibar(hasMinibar);
                    ((VueGererChambre)this.main.listeActions.get(6)).refresh();
                    this.main.listeActions.set(5, new VueRechercherChambre(main));
                    this.main.getContentPane().add(this.main.getListeActions().get(6));
                    break;
                case "Enregistrer modifications produit":
                    Produit produit = (Produit)this.objet;
                    produit.setPrice(prix);
                    this.main.listeActions.set(15, new VueRechercherChambre(main));
                    ((VueGererProduit)this.main.listeActions.get(16)).refresh();
                    this.main.getContentPane().add(this.main.getListeActions().get(16));
                default:
                    break;
            }
        }
        this.main.repaint();
        this.main.pack();
    }
}
