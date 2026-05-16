package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.*;
import vue.*;

public class ControllerRecherche implements ActionListener{
    Hotel hotel;
    JTable tableModel;
    Vector<JTextField> lFields;
    Vector<JLabel> lJLabels;
    Vector<JRadioButton> lRadioButtons;
    JComboBox<String> jcb;
    JRadioButton sup;

    VueHotel main;
    JTable table;
    Vector<JComponent> textFields;

    public ControllerRecherche(Hotel hotel, JTable tModel, Vector<JTextField> lFields, Vector<JLabel> lJLabels){
        this.hotel = hotel;
        this.tableModel = tModel;
        this.lFields = lFields;
        this.lJLabels = lJLabels;
    }

    public ControllerRecherche(VueHotel main, JTable table, Vector<JComponent> textFields){
        this.main = main;
        this.table = table;
        this.textFields = textFields;
    }

    public ControllerRecherche(Hotel hotel, JTable tModel, Vector<JTextField> lFields, Vector<JLabel> lJLabels, JRadioButton jrb){
        this.hotel = hotel;
        this.tableModel = tModel;
        this.lFields = lFields;
        this.lJLabels = lJLabels;
        this.sup = jrb;
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
        Object source = e.getSource();
        if(!(((JButton)source).getText().equals("Rechercher sejour") || ((JButton)source).getText().equals("Rechercher reservation"))){
            ((DefaultTableModel)this.tableModel.getModel()).setRowCount(0);
        }
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
                        ((DefaultTableModel)tableModel.getModel()).addRow(new Object[]{c.getNumeroChambre(), c.getPrice(), c.getType(), c.hasMinibar(), c});
                    }
                }
            }
        } else if(((JButton)e.getSource()).getText().equals("Rechercher produit")){
            double prix = -1;
            try{
                prix = Double.parseDouble(lFields.get(1).getText());
                this.lJLabels.get(1).setText("");
            } catch(NumberFormatException ex) {
                if(lFields.get(1).getText().length()!=0){
                    lFields.get(1).setText("");
                    this.lJLabels.get(1).setText("*Element doit être un nombre");
                    this.lJLabels.get(1).setForeground(Color.red);
                    prix = -1;
                }
            }
            String nom = this.lFields.get(0).getText();
            if(nom.equals("") && prix == -1){
                this.lJLabels.get(0).setText("*Aucune information renseignée");
            } else {
                this.lJLabels.get(0).setText("");
                Vector<Produit> rProduits = this.hotel.getProduitByCondition(nom, prix, !this.sup.isSelected());
                if(rProduits.isEmpty()){lJLabels.get(0).setText("*Produit inexistant");}
                else{
                    lJLabels.get(0).setText("");
                    for (Produit p : rProduits) {
                        ((DefaultTableModel)tableModel.getModel()).addRow(new Object[]{p.getName(), p.getPrice(), p});
                    }
                }
            }
        } else if(((JButton)source).getText().equals("Rechercher sejour")){
            String name = ((JTextField)textFields.get(1)).getText().toUpperCase();
            String type = ((JTextField)textFields.get(2)).getText();
            LocalDate startDate = ((JTextField)textFields.get(3)).getText().isEmpty() ? null : LocalDate.parse(((JTextField)textFields.get(3)).getText());
            String surname = ((JTextField)textFields.get(4)).getText();
            int floor = ((JTextField)textFields.get(5)).getText().isEmpty() ? 0 : Integer.parseInt(((JTextField)textFields.get(5)).getText());
            LocalDate endDate = ((JTextField)textFields.get(6)).getText().isEmpty() ? null : LocalDate.parse(((JTextField)textFields.get(6)).getText());
            double priceNight = ((JTextField)textFields.get(7)).getText().isEmpty() ? 0 : Double.parseDouble(((JTextField)textFields.get(7)).getText());
            double priceCon = ((JTextField)textFields.get(8)).getText().isEmpty() ? 0 : Double.parseDouble(((JTextField)textFields.get(8)).getText());
            Boolean hasMinibar = null;
            if (((JRadioButton)textFields.get(9)).isSelected()) {
                hasMinibar = true;
            } else if (((JRadioButton)textFields.get(10)).isSelected()) {
                hasMinibar = false;
            }
            ((VueRechercherSejour) this.main.getListeActions().get(12)).refreshSearch(name, type, startDate, surname, floor, endDate, priceNight, hasMinibar, priceCon, currentTableType);
            for (JComponent component : textFields) {
                if (component instanceof JTextField) {
                    ((JTextField) component).setText("");
                }
            }
        } else if(((JButton)source).getText().equals("Rechercher reservation")){
            String name = ((JTextField)textFields.get(0)).getText().toUpperCase();
            String type = ((JTextField)textFields.get(1)).getText();
            LocalDate startDate = ((JTextField)textFields.get(2)).getText().isEmpty() ? null : LocalDate.parse(((JTextField)textFields.get(2)).getText());
            String surname = ((JTextField)textFields.get(3)).getText();
            int floor = ((JTextField)textFields.get(4)).getText().isEmpty() ? 0 : Integer.parseInt(((JTextField)textFields.get(4)).getText());
            LocalDate endDate = ((JTextField)textFields.get(5)).getText().isEmpty() ? null : LocalDate.parse(((JTextField)textFields.get(5)).getText());
            double priceNight = ((JTextField)textFields.get(6)).getText().isEmpty() ? 0 : Double.parseDouble(((JTextField)textFields.get(6)).getText());
            Boolean hasMinibar = null;
            if (((JRadioButton)textFields.get(7)).isSelected()) {
                hasMinibar = true;
            } else if (((JRadioButton)textFields.get(8)).isSelected()) {
                hasMinibar = false;
            }
            ((VueRechercherReservation) this.main.getListeActions().get(10)).refreshSearch(name, type, startDate, surname, floor, endDate, priceNight, hasMinibar);
            for (JComponent component : textFields) {
                if (component instanceof JTextField) {
                    ((JTextField) component).setText("");
                }
            }
        }
    }

    String currentTableType = "All";

    public void setMode(String tableType) {
        this.currentTableType = tableType;
    }
}
