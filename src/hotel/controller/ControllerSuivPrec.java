package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTextField;
import vue.VueHotel;

public class ControllerSuivPrec implements ActionListener{
    VueHotel vueHotel;
    Vector<JTextField> lFields;

    public ControllerSuivPrec(VueHotel vueHotel, Vector<JTextField> lFields){
        this.vueHotel = vueHotel;
        this.lFields = lFields;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        boolean canBePerformed = true;
        this.vueHotel.getContentPane().removeAll();
        if(canBePerformed){
            if(((JButton)e.getSource()).getText().equals("Suivant")){
                this.vueHotel.getContentPane().add(this.vueHotel.getListeActions().get(9));
            } else if(((JButton)e.getSource()).getText().equals("Précédent")){
                this.vueHotel.getContentPane().add(this.vueHotel.getListeActions().get(4));
            }
        }
        this.vueHotel.repaint();
        this.vueHotel.pack();
    }
}
