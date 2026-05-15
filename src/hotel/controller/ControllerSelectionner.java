package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import vue.VueAjoutReservation2;
import vue.VueHotel;

public class ControllerSelectionner implements ActionListener{
    VueHotel main;
    JScrollPane scroller;

    public ControllerSelectionner(VueHotel main, JScrollPane scroll){
        this.main = main;
        this.scroller = scroll;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.main.getListeActions().get(5).remove(scroller);
        if(((JRadioButton)e.getSource()).getText().equals("Oui")){
            System.out.println("ça marche pour oui");
        } else if(((JRadioButton)e.getSource()).getText().equals("Non")){
            System.out.println("ça marche pour non");
            ((VueAjoutReservation2)this.main.getListeActions().get(5)).refresh();
            this.main.getListeActions().get(5).add(scroller, BorderLayout.CENTER);
        }
        this.main.repaint();
        this.main.pack();
    }
    
}
