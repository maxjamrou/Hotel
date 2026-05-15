package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Chambre;
import model.Client;
import model.Produit;
import vue.VueHotel;
import vue.VueInfoChambre;
import vue.VueInfoClient;
import vue.VueInfoProduit;


public class ControllerModifier implements ActionListener{
    VueHotel main;
    JTable table;

    public ControllerModifier(VueHotel main, JTable table){
        this.main = main;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int selectedRow = 0;
        if(((JButton)e.getSource()).getText().equals("Modifier client")){
            selectedRow = this.table.getSelectedRow();
            if(selectedRow == -1){
                System.out.println("Aucune chambre sélectionnée");
            } else {
                this.main.getContentPane().removeAll();
                this.main.getListeActions().set(3, new VueInfoClient(this.main));
                ((VueInfoClient)this.main.getListeActions().get(3)).refresh((Client)((DefaultTableModel)this.table.getModel()).getValueAt(selectedRow, 2));
                this.main.getContentPane().add(this.main.listeActions.get(3));
            }
        } else if(((JButton)e.getSource()).getText().equals("Modifier chambre")){
            selectedRow = this.table.getSelectedRow();
            if(selectedRow == -1){
                System.out.println("Aucune chambre sélectionnée");
            } else {
                this.main.getContentPane().removeAll();
                this.main.getListeActions().set(7, new VueInfoChambre(this.main));
                ((VueInfoChambre)this.main.getListeActions().get(7)).refresh((Chambre)((DefaultTableModel)this.table.getModel()).getValueAt(selectedRow, 4));
                this.main.getContentPane().add(this.main.listeActions.get(7));
            }
        } else if(((JButton)e.getSource()).getText().equals("Modifier produit")){
            selectedRow = this.table.getSelectedRow();
            if(selectedRow == -1){
                System.out.println("Aucun produit sélectionné");
            } else {
                this.main.getContentPane().removeAll();
                this.main.getListeActions().set(17, new VueInfoProduit(this.main));
                ((VueInfoProduit)this.main.getListeActions().get(17)).refresh((Produit)((DefaultTableModel)this.table.getModel()).getValueAt(selectedRow, 2));
                this.main.getContentPane().add(this.main.listeActions.get(17));
            }
        }
        this.main.repaint();
        this.main.pack();
    }
}
