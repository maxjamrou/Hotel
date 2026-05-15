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
        System.out.println("annuler");
        this.main.getContentPane().removeAll();
        switch(((JButton)e.getSource()).getText()){
            case "Annuler modifications client":
                this.main.getContentPane().add(this.main.getListeActions().get(2));
                break;
            case "Annuler modifications chambre" :
                this.main.getContentPane().add(this.main.getListeActions().get(6));
                break;
            default:
                break;
        }
        this.main.repaint();
        this.main.pack();
    }
}
