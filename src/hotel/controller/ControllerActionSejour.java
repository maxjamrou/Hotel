package controller;

import model.Sejour;
import vue.VueHotel;
import vue.VueRechercherSejour;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ControllerActionSejour implements ActionListener {
    VueHotel main;
    JTable table;
    Vector<JComponent> bottomPanes;
    Vector<JLabel> totalGroup;

    public ControllerActionSejour(VueHotel main, JTable table, Vector<JComponent> bottomPanes, Vector<JLabel> totalGroup) {
        this.main = main;
        this.table = table;
        this.bottomPanes = bottomPanes;
        this.totalGroup = totalGroup;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(((JButton)source).getText().equals("Facturer un sejour")){
            ((VueRechercherSejour)this.main.getListeActions().get(12)).refreshTableSejoursDone();
            this.main.getListeActions().get(12).remove(bottomPanes.get(0));
            this.main.getListeActions().get(12).add(bottomPanes.get(1));
        } else if(((JButton)source).getText().equals("Ajouter une consommation")){
            ((VueRechercherSejour)this.main.getListeActions().get(12)).refreshTableSejoursNotDone();
            ((VueRechercherSejour)this.main.getListeActions().get(12)).refreshSelectProducts();
            this.main.getListeActions().get(12).remove(bottomPanes.get(0));
            this.main.getListeActions().get(12).add(bottomPanes.get(2));
        } else if (((JButton)source).getText().equals("Rafraichir")){
            if (table.getSelectedRow() != -1){
                Sejour SelectedSejour = (Sejour) table.getValueAt(table.getSelectedRow(), 9);
                ((VueRechercherSejour)this.main.getListeActions().get(12)).refreshInvoiceProducts(SelectedSejour);
                double TotalCon = SelectedSejour.getConsommationMinibar().getTotalPrice();
                double TotalNight = SelectedSejour.getPrixReservation(SelectedSejour.getReservation().getStartReservation(),  SelectedSejour.getReservation().getEndReservation());
                totalGroup.get(0).setText("Total a payer : " + TotalCon + TotalNight + "€");
                totalGroup.get(1).setText("Total consomme : " + TotalCon + "€");
                totalGroup.get(2).setText("Total des nuits : " + TotalNight + "€");
            }
        }
        this.main.repaint();
        this.main.pack();
    }
}