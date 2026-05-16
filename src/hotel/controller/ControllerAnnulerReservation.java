package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Chambre;
import model.Client;
import model.Reservation;
import vue.VueGererReservation;
import vue.VueHotel;

public class ControllerAnnulerReservation implements ActionListener{
    VueHotel main;
    JTable table;
    JLabel erreur;
    boolean canBeErased;
    Reservation reservation;

    public ControllerAnnulerReservation(VueHotel main, JTable table, JLabel err){
        this.main = main;
        this.table = table;
        this.erreur = err;
        this.canBeErased = false;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int selectedRow = 0;
        this.erreur.setText("");
        this.erreur.setHorizontalAlignment(SwingConstants.CENTER);
        this.erreur.setForeground(Color.red);
        if(((JButton)e.getSource()).getText().equals("Annuler réservation")){
            selectedRow = this.table.getSelectedRow();
            if(selectedRow == -1){
                this.erreur.setForeground(Color.RED);
                this.erreur.setText(("*Aucune réservation sélectionnée"));
            } else {
                Reservation r = (Reservation)((DefaultTableModel)this.table.getModel()).getValueAt(selectedRow, 6);
                if(!canBeErased || !r.equals(this.reservation)){
                    this.reservation = r;
                    this.erreur.setForeground(Color.BLACK);
                    String msg = "*Confirmer l'annulation de la réservation de " + r.getClient().getNom() + " " + r.getClient().getPrenom() + " le " + r.getStartReservation().toString() + " au " + r.getEndReservation().toString();
                    this.erreur.setText(msg);
                    this.canBeErased = true;
                } else {
                    canBeErased = false;
                    for (Chambre c : this.main.getHotel().getChambres()) {
                        if(c.getListReservations().contains(r)){c.removeReservation(r);}
                    }
                    for(Client c : this.main.getHotel().getClients()){
                        if(c.getListeReservations().contains(r)){c.getListeReservations().remove(r);}
                    }
                    this.main.getHotel().getReservations().remove(r);
                    ((VueGererReservation)this.main.getListeActions().get(11)).refresh();
                }
            }
        }
    }
}