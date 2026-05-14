package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Chambre;
import model.Client;
import model.Reservation;
import vue.VueAjoutReservation2;
import vue.VueHotel;

public class ControllerSuivPrec implements ActionListener{
    VueHotel vueHotel;
    JTable table;
    Vector<JLabel> lJLabels;
    Vector<JTextField> lFields;
    ButtonGroup buttons;
    JScrollPane scroller;

    public ControllerSuivPrec(VueHotel vueHotel, ButtonGroup buttons){
        this.vueHotel = vueHotel;
        this.buttons = buttons;
    }

    public ControllerSuivPrec(VueHotel vueHotel, JTable table, Vector<JLabel> lJLabels, Vector<JTextField> lFields){
        this.vueHotel = vueHotel;
        this.table = table;
        this.lJLabels = lJLabels;
        this.lFields = lFields;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        boolean canBePerformed = true;
        int selectedRow = 0;
        LocalDate debReservation = null;
        LocalDate finReservation = null;
        String date;
        Client client;
        Chambre chambreTemp = new Chambre(0, 0, false, null, null);
        if(this.lFields != null){
            this.lJLabels.get(0).setText("");
            this.lJLabels.get(1).setText("");
            this.lJLabels.get(2).setText("");
        }
        if(((JButton)e.getSource()).getText().equals("Suivant")){
            try {
                date = this.lFields.get(0).getText().replace(" ", "") + "-" + this.lFields.get(1).getText().replace(" ", "") + "-" + this.lFields.get(2).getText().replace(" ", "");
                debReservation = LocalDate.parse(date);
                System.out.println(debReservation.toString());
            } catch (DateTimeException ex) {
                this.lJLabels.get(0).setForeground(Color.RED);
                this.lJLabels.get(0).setText(ex.getMessage());
                canBePerformed = false;
            }
            try {
                date = this.lFields.get(3).getText().replace(" ", "") + "-" + this.lFields.get(4).getText().replace(" ", "") + "-" + this.lFields.get(5).getText().replace(" ", "");
                finReservation = LocalDate.parse(date);
                System.out.println(finReservation.toString());
            } catch (DateTimeException ex) {
                this.lJLabels.get(1).setForeground(Color.RED);
                this.lJLabels.get(1).setText(ex.getMessage());
                canBePerformed = false;
            }
            if(debReservation.isBefore(LocalDate.now())){
                this.lJLabels.get(0).setForeground(Color.RED);
                this.lJLabels.get(0).setText("*Le début de la réservation est dans le passé");
                canBePerformed = false;
            }
            if(finReservation.isBefore(LocalDate.now())){
                this.lJLabels.get(1).setForeground(Color.RED);
                this.lJLabels.get(1).setText("*La fin de la réservation est dans le passé");
                canBePerformed = false;
            }
            if(finReservation.isBefore(debReservation)){
                this.lJLabels.get(1).setForeground(Color.RED);
                this.lJLabels.get(1).setText("*La fin de la réservation est avant la date de début de réservation");
                canBePerformed = false;
            }
        }
        if(this.table != null){
            selectedRow = this.table.getSelectedRow();
            if(selectedRow == -1){
                canBePerformed = false;
                this.lJLabels.get(2).setText("*Aucun client sélectionné");
            } else {
                client = (Client)((DefaultTableModel)this.table.getModel()).getValueAt(selectedRow, 2);
                if(canBePerformed && client.aDejaReserve(new Reservation(debReservation, finReservation, null, chambreTemp, client))){
                    canBePerformed = false;
                    this.lJLabels.get(2).setText("*Ce client a déjà réservé sur cette période de temps");
                    // System.out.println(client.getReservations().get(0).getStartReservation() + " " + client.getReservations().get(0).getEndReservation());
                }
            }
        }
        if(canBePerformed){
            this.vueHotel.getContentPane().removeAll();
            if(((JButton)e.getSource()).getText().equals("Suivant")){
                System.out.println(debReservation.toString() + " " + finReservation.toString());
                this.scroller = ((VueAjoutReservation2)this.vueHotel.getListeActions().get(9)).scroller;
                this.vueHotel.getListeActions().get(9).remove(this.scroller);
                client = (Client)((DefaultTableModel)this.table.getModel()).getValueAt(selectedRow, 2);
                ((VueAjoutReservation2)this.vueHotel.getListeActions().get(9)).reservation = (new Reservation(debReservation, finReservation, this.vueHotel.getHotel(), chambreTemp, client));
                this.vueHotel.getContentPane().add(this.vueHotel.getListeActions().get(9));
                ((VueAjoutReservation2)this.vueHotel.getListeActions().get(9)).choixGroup.clearSelection();
            } else if(((JButton)e.getSource()).getText().equals("Précédent")){
                this.buttons.clearSelection();
                this.vueHotel.getContentPane().add(this.vueHotel.getListeActions().get(4));
            }
        }
        this.vueHotel.repaint();
        this.vueHotel.pack();
    }
}
