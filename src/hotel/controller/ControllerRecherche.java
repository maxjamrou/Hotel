package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.*;

public class ControllerRecherche implements ActionListener{
    Hotel hotel;
    JTable tableModel;
    Vector<JTextField> lFields;
    Vector<JLabel> lJLabels;
    Vector<JRadioButton> lRadioButtons;
    JComboBox<String> jcb;

    public ControllerRecherche(Hotel hotel, JTable tModel, Vector<JTextField> lFields, Vector<JLabel> lJLabels){
        this.hotel = hotel;
        this.tableModel = tModel;
        this.lFields = lFields;
        this.lJLabels = lJLabels;
    }

    public ControllerRecherche(Hotel hotel, JTable tModel, Vector<JTextField> lFields, Vector<JLabel> lJLabels, Vector<JRadioButton> lrdb, JComboBox<String> jcb){
        this.hotel = hotel;
        this.tableModel = tModel;
        this.lFields = lFields;
        this.lJLabels = lJLabels;
        this.lRadioButtons = lrdb;
        this.jcb = jcb;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        ((DefaultTableModel)this.tableModel.getModel()).setRowCount(0);
        if(((JButton)e.getSource()).getText().equals("Rechercher client")){
            String nom = lFields.get(0).getText();
            String prenom = lFields.get(1).getText();
            // System.out.println(nom + " et " +prenom);
            if(nom.equals("") && prenom.equals("")){lJLabels.get(0).setText("*Aucune information renseignée");} 
            else {
                Vector<Client> lClient = this.hotel.getClientByNomAndPrenom(nom, prenom);
                if(lClient.isEmpty()){lJLabels.get(0).setText("*Client inexistant");}
                else{
                    lJLabels.get(0).setText("");
                    for (int i = 0; i < lClient.size(); i++) {
                        ((DefaultTableModel)tableModel.getModel()).addRow(new Object[]{lClient.get(i).getNom(), lClient.get(i).getPrenom(), lClient.get(i)});
                    }
                }
            }
        } else if(((JButton)e.getSource()).getText().equals("Rechercher chambre")){
            int floor = -1;
            double prix = -1;
            try{
                floor = Integer.parseInt(lFields.get(0).getText());
                this.lJLabels.get(0).setText("");
            } catch(NumberFormatException ex){
                if(lFields.get(0).getText().length()!=0){
                    lFields.get(0).setText("");
                    this.lJLabels.get(1).setText("*Element doit être un nombre");
                    this.lJLabels.get(1).setForeground(Color.red);
                    floor = -1;
                }
            }
            try{
                prix = Double.parseDouble(lFields.get(1).getText());
                this.lJLabels.get(2).setText("");
            } catch(NumberFormatException ex) {
                if(lFields.get(1).getText().length()!=0){
                    lFields.get(1).setText("");
                    this.lJLabels.get(2).setText("*Element doit être un nombre");
                    this.lJLabels.get(2).setForeground(Color.red);
                    prix = -1;
                }
            }
            String type = (String)this.jcb.getSelectedItem();
            int minibar = -1;
            if(this.lRadioButtons.get(2).isSelected()){
                minibar = 0;
            } else if (this.lRadioButtons.get(1).isSelected()){minibar = 1;}
    
            if(minibar == -1 && type.equals("") && prix == -1 && floor == -1){
                this.lJLabels.get(0).setText("*Aucune information renseignée");
            } else {
                this.lJLabels.get(0).setText("");
                Vector<Chambre> rChambres = this.hotel.getChambreByCondition(!this.lRadioButtons.get(0).isSelected(), prix, minibar, type, floor);
                if(rChambres.isEmpty()){this.lJLabels.get(0).setText("*Chambre inexistante");}
                else{
                    lJLabels.get(0).setText("");
                    for (Chambre c : rChambres) {
                        ((DefaultTableModel)tableModel.getModel()).addRow(new Object[]{c.getFloor(), c.getPrice(), c.getType(), c.hasMinibar(), c});
                    }
                }
            }
        }
    }
}
