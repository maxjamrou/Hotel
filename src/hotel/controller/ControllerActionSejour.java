package controller;

import model.Produit;
import model.Sejour;
import vue.VueHotel;
import vue.VueRechercherSejour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ControllerActionSejour implements ActionListener {
    VueHotel main;
    JTable table;
    JTable tableProduct;
    Vector<JComponent> bottomPanes;
    Vector<JLabel> totalGroup;
    Vector<JComponent> textFields;
    ControllerRecherche controllerRecherche;

    public ControllerActionSejour(VueHotel main, JTable table, JTable tableProduct, Vector<JComponent> bottomPanes, Vector<JLabel> totalGroup,  Vector<JComponent> textFields, ControllerRecherche controllerRecherche) {
        this.main = main;
        this.table = table;
        this.tableProduct = tableProduct;
        this.bottomPanes = bottomPanes;
        this.totalGroup = totalGroup;
        this.textFields = textFields;
        this.controllerRecherche = controllerRecherche;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(((JButton)source).getText().equals("Facturer un sejour")){
            ((VueRechercherSejour)this.main.getListeActions().get(12)).refreshTableSejoursDone();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;
            gbc.weighty = 0.3;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(5, 5, 5, 5);
            this.main.getListeActions().get(12).remove(bottomPanes.get(0));
            this.main.getListeActions().get(12).add(bottomPanes.get(1), gbc);
            controllerRecherche.setMode("Done");
        } else if(((JButton)source).getText().equals("Ajouter une consommation")){
            ((VueRechercherSejour)this.main.getListeActions().get(12)).refreshTableSejoursNotDone();
            ((VueRechercherSejour)this.main.getListeActions().get(12)).refreshSelectProducts();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;
            gbc.weighty = 0.3;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(5, 5, 5, 5);
            this.main.getListeActions().get(12).remove(bottomPanes.get(0));
            this.main.getListeActions().get(12).add(bottomPanes.get(2), gbc);
            controllerRecherche.setMode("NotDone");
        } else if (((JButton)source).getText().equals("Rafraichir")){
            if (table.getSelectedRow() != -1){
                Sejour selectedSejour = (Sejour) table.getModel().getValueAt(table.getSelectedRow(), 8);
                ((VueRechercherSejour)this.main.getListeActions().get(12)).refreshInvoiceProducts(selectedSejour);
                double totalCon = selectedSejour.getConsommationMinibar().getTotalPrice();
                double totalNight = selectedSejour.getPrixReservation(selectedSejour.getReservation().getStartReservation(),  selectedSejour.getReservation().getEndReservation());
                totalGroup.get(0).setText("Total a payer : " + (totalCon + totalNight) + "€");
                totalGroup.get(1).setText("Total consomme : " + totalCon + "€");
                totalGroup.get(2).setText("Total des nuits : " + totalNight + "€");
            }
        } else if (((JButton)source).getText().equals("Facturer")) {
            if (table.getSelectedRow() != -1) {
                Sejour selectedSejour = (Sejour) table.getModel().getValueAt(table.getSelectedRow(), 8);
                selectedSejour.deleteSejour(selectedSejour);
                totalGroup.get(0).setText("Total a payer :");
                totalGroup.get(1).setText("Total consomme :");
                totalGroup.get(2).setText("Total des nuits :");
                ((VueRechercherSejour) this.main.getListeActions().get(12)).refreshTableSejoursDone();
                ((VueRechercherSejour) this.main.getListeActions().get(12)).refreshInvoiceProducts();
            }
        } else if (((JButton)source).getText().equals("Ajouter conso")) {
            JTextField quantityTextField = (JTextField)textFields.get(0);
            if ((table.getSelectedRow() != -1) && (tableProduct.getSelectedRow() != -1) && (!quantityTextField.getText().trim().isEmpty())) {
                Produit selectedProduct = (Produit) tableProduct.getModel().getValueAt(tableProduct.getSelectedRow(), 1);
                Sejour selectedSejour = (Sejour) table.getModel().getValueAt(table.getSelectedRow(), 8);
                int quantity = Integer.parseInt(((JTextField) textFields.get(0)).getText());
                selectedSejour.getConsommationMinibar().addProduit(selectedProduct);
                quantityTextField.setText("");
                ((VueRechercherSejour) this.main.getListeActions().get(12)).refreshTableSejoursNotDone();
                ((VueRechercherSejour) this.main.getListeActions().get(12)).refreshSelectProducts();
            }
        }
        this.main.repaint();
        this.main.pack();
    }
}