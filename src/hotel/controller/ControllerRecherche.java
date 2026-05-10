package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.*;

public class ControllerRecherche implements ActionListener{
    Hotel hotel;
    DefaultTableModel tableModel;
    Vector<JTextField> lFields;
    Vector<JLabel> lJLabels;

    public ControllerRecherche(Hotel hotel, DefaultTableModel tModel, Vector<JTextField> lFields, Vector<JLabel> lJLabels){
        this.hotel = hotel;
        this.tableModel = tModel;
        this.lFields = lFields;
        this.lJLabels = lJLabels;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(((JButton)e.getSource()).getText().equals("Rechercher client")){
            this.tableModel.setRowCount(0);
            String nom = lFields.get(0).getText();
            String prenom = lFields.get(1).getText();
            System.out.println(nom + " et " +prenom);
            if(nom.equals("") && prenom.equals("")){System.out.println("test");lJLabels.get(0).setText("*Aucune information renseignée");} 
            else {
                Vector<Client> lClient= this.hotel.getClientByNomAndPrenom(nom, prenom);
                if(lClient.isEmpty()){System.out.println("works?");lJLabels.get(0).setText("*Client inexistant");}
                else{
                    for (int i = 0; i < lClient.size(); i++) {
                        tableModel.addRow(new String[]{lClient.get(i).getNom(), lClient.get(i).getPrenom()});
                    }
                }
            }
        }
    }
}
