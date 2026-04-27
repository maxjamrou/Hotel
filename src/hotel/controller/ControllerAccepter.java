package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Chambre;
import model.Client;
import vue.VueHotel;

public class ControllerAccepter implements ActionListener{
    VueHotel main;
    String titre;
    Vector<JTextField> listeJTextFields;
    Vector<JLabel> listJLabels;
    JRadioButton jRadioButton;
    JComboBox<String> jComboBox;
    
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
        for (int i = 0; i < this.listeJTextFields.capacity(); i++) {
            listeStrFields.add(listeJTextFields.get(i).getText());
            if(listeStrFields.get(i).length() == 0){
                this.listJLabels.get(i).setText("*Elément manquant");
                canBePerformed = false;
            } else {
                this.listJLabels.get(i).setText("");
            }
        }
        if(canBePerformed){
            System.out.println(titre);
            if(titre.equals("Ajouter Client")){
                this.main.getHotel().addClient(new Client(listeStrFields.get(0), listeStrFields.get(1), this.main.getHotel()));
                System.out.println("testtest");
            } else if (titre.equals("Ajouter Chambre")){
                boolean hasMinibar = true; 
                if(this.jRadioButton.isSelected()){hasMinibar = false;}
                boolean isNumber = true;
                int etage = 0;
                double prix = 0.0;
                try{
                    etage = Integer.parseInt(listeStrFields.get(0));
                } catch(NumberFormatException ex){
                    listJLabels.get(0).setText("*Element doit être un nombre");
                    isNumber = false;
                }
                try{
                    prix = Double.parseDouble(listeStrFields.get(1));
                } catch(NumberFormatException ex) {
                    listJLabels.get(1).setText("*Element doit être un nombre");
                    isNumber = false;
                }
                if(isNumber){this.main.getHotel().addChambre(new Chambre(etage, prix, hasMinibar, (String)this.jComboBox.getSelectedItem(), this.main.getHotel()));}
                System.out.println(Integer.parseInt(listeStrFields.get(0)) + Double.parseDouble(listeStrFields.get(1)));
                this.jRadioButton.setSelected(true);
                this.jComboBox.setSelectedItem("Simple");
            }
            for (int i = 0; i < this.listeJTextFields.capacity(); i++) {
                this.listeJTextFields.get(i).setText("");
            }
            this.main.getContentPane().removeAll();
            this.main.repaint(); 
        }
    }
}
