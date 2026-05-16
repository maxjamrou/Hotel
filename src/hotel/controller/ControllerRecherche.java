package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import vue.VueHotel;
import vue.VueRechercherSejour;

public class ControllerRecherche implements ActionListener{
    Hotel hotel;
    JTable tableModel;
    Vector<JTextField> lFields;
    Vector<JLabel> lJLabels;
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

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(((JButton)source).getText().equals("Rechercher client")){
            ((DefaultTableModel)this.tableModel.getModel()).setRowCount(0);
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
        } else if(((JButton)source).getText().equals("Rechercher")){
            String name = ((JTextField)textFields.get(1)).getText();
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
        }
    }

    String currentTableType = "All";

    public void setMode(String tableType) {
        this.currentTableType = tableType;
    }
}
