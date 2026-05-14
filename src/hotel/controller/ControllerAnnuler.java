package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vue.VueHotel;

public class ControllerAnnuler implements ActionListener{
    VueHotel main;

    public ControllerAnnuler(VueHotel main){
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.main.getContentPane().removeAll();
        if(((JButton)e.getSource()).getText().equals("Annuler modifications chambre")){
            this.main.getContentPane().add(this.main.getListeActions().get(3));
        }
        this.main.repaint();
        this.main.pack();
    }
}
