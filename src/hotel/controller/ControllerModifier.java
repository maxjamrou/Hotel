package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Chambre;
import vue.VueHotel;
import vue.VueInfoChambre;


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
        if(((JButton)e.getSource()).getText().equals("Modifier chambre")){
            selectedRow = this.table.getSelectedRow();
            if(selectedRow == -1){
                System.out.println("Aucune chambre sélectionnée");
            } else {
                this.main.getContentPane().removeAll();
                this.main.getListeActions().set(3, new VueInfoChambre(this.main));
                ((VueInfoChambre)this.main.getListeActions().get(3)).refresh((Chambre)((DefaultTableModel)this.table.getModel()).getValueAt(selectedRow, 4));
                this.main.getContentPane().add(this.main.listeActions.get(3));
            }
            this.main.repaint();
            this.main.pack();
        }
    }
}
