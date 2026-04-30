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
import vue.*;

public class ControllerAccepter implements ActionListener{
    VueHotel main;
    Vector<JTextField> listeJTextFields;
    Vector<JLabel> listJLabels;
    JRadioButton jRadioButton;
    JComboBox<String> jComboBox;
    
    public ControllerAccepter(VueHotel main, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels){
        this.main = main;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
    }

    public ControllerAccepter(VueHotel main, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels, JRadioButton jrb, JComboBox<String> jcb){
        this.main = main;
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
        if(((JButton)e.getSource()).getText().equals("Ajouter produit")){
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
        if(canBePerformed){
            System.out.println(((JButton)e.getSource()).getText());
            this.main.getContentPane().removeAll();
            switch (((JButton)e.getSource()).getText()) {
                case "Ajouter client":
                    this.main.getHotel().addClient(new Client(listeStrFields.get(0).toUpperCase(), listeStrFields.get(1), this.main.getHotel()));
                    ((VueGererClient)this.main.listeActions.get(1)).refresh();
                    this.main.getContentPane().add(this.main.getListeActions().get(1));
                    this.main.repaint();
                    break;
                case "Ajouter chambre":
                    boolean hasMinibar = true;
                    if(this.jRadioButton.isSelected()){hasMinibar = false;}
                    this.main.getHotel().addChambre(new Chambre(intValue, prix, hasMinibar, (String)this.jComboBox.getSelectedItem(), this.main.getHotel()));
                    System.out.println(Integer.parseInt(listeStrFields.get(0)) + Double.parseDouble(listeStrFields.get(1)));
                    this.jRadioButton.setSelected(true);
                    this.jComboBox.setSelectedItem("Simple");
                    ((VueGererChambre)this.main.listeActions.get(3)).refresh();
                    this.main.getContentPane().add(this.main.getListeActions().get(3));
                    break;
                case "Ajouter produit":
                    this.main.getHotel().addProduit(new Produit(listeStrFields.get(0), 0, prix, this.main.getHotel()));
                    ((VueGererProduit)this.main.listeActions.get(8)).refresh();
                    this.main.getContentPane().add(this.main.getListeActions().get(8));
                    break;
                default:
                    break;
            }
            for (int i = 0; i < this.listeJTextFields.size(); i++) {
                this.listeJTextFields.get(i).setText("");
            }
            this.main.repaint(); 
        }
    }
}
