package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Chambre;
import model.Client;
import model.Produit;
import vue.VueHotel;

public class ControllerAccepter implements ActionListener{
    VueHotel main;
    String titre;
    Vector<JTextField> listeJTextFields;
    Vector<JLabel> listJLabels;
    JRadioButton jRadioButton;
    JComboBox<String> jComboBox;
    
    public ControllerAccepter(VueHotel main, String titre, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels){
        this.main = main;
        this.titre = titre;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
    }

    public ControllerAccepter(VueHotel main, String titre, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels, JRadioButton jrb, JComboBox<String> jcb){
        this.main = main;
        this.titre = titre;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
        this.jRadioButton = jrb;
        this.jComboBox = jcb;
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
        int intValue = 0;
        double prix = 0.0;
        if(jRadioButton != null && jComboBox != null){
            try{
                intValue = Integer.parseInt(listeStrFields.get(0));
            } catch(NumberFormatException ex){
                if(listeStrFields.get(0).length()!=0){
                    listeJTextFields.get(0).setText("");
                    listJLabels.get(0).setText("*Element doit être un nombre");
                    this.listJLabels.get(0).setForeground(Color.red);
                    canBePerformed = false;
                }
            }
            try{
                prix = Double.parseDouble(listeStrFields.get(1));
            } catch(NumberFormatException ex) {
                if(listeStrFields.get(1).length()!=0){
                    listeJTextFields.get(1).setText("");
                    listJLabels.get(1).setText("*Element doit être un nombre");
                    this.listJLabels.get(1).setForeground(Color.red);
                    canBePerformed = false;
                }
            }
        }
        if(titre.equals("Ajouter Produit")){
            try{
                prix = Double.parseDouble(listeStrFields.get(2));
            } catch(NumberFormatException ex) {
                if(listeStrFields.get(2).length()!=0){
                    listeJTextFields.get(2).setText("");
                    listJLabels.get(2).setText("*Element doit être un nombre");
                    this.listJLabels.get(2).setForeground(Color.red);
                    canBePerformed = false;
                }
            }
        }
        if(canBePerformed){
            System.out.println(titre);
            if(titre.equals("Ajouter Client")){
                this.main.getHotel().addClient(new Client(listeStrFields.get(0).toUpperCase(), listeStrFields.get(1), this.main.getHotel()));
            } else if (titre.equals("Ajouter Chambre")){
                boolean hasMinibar = true; 
                if(this.jRadioButton.isSelected()){hasMinibar = false;}
                this.main.getHotel().addChambre(new Chambre(intValue, prix, hasMinibar, (String)this.jComboBox.getSelectedItem(), this.main.getHotel()));
                System.out.println(Integer.parseInt(listeStrFields.get(0)) + Double.parseDouble(listeStrFields.get(1)));
                this.jRadioButton.setSelected(true);
                this.jComboBox.setSelectedItem("Simple");
            } else if((titre.equals("Ajouter Produit"))){
                this.main.getHotel().addProduit(new Produit(listeStrFields.get(0), 0, prix, this.main.getHotel()));
            }
            for (int i = 0; i < this.listeJTextFields.size(); i++) {
                this.listeJTextFields.get(i).setText("");
            }
            this.main.getContentPane().removeAll();
            this.main.repaint(); 
        }
    }
}
