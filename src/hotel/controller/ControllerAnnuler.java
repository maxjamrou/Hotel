package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vue.VueGererChambre;
import vue.VueGererClient;
import vue.VueGererProduit;
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
                ((VueGererClient)this.main.getListeActions().get(2)).refresh();
                this.main.getContentPane().add(this.main.getListeActions().get(2));
                break;
            case "Annuler modifications chambre" :
                ((VueGererChambre)this.main.getListeActions().get(6)).refresh();
                this.main.getContentPane().add(this.main.getListeActions().get(6));
                break;
            case "Annuler modifications produit":
                ((VueGererProduit)this.main.getListeActions().get(16)).refresh();
                this.main.getContentPane().add(this.main.getListeActions().get(16));
            default:
                break;
        }
        this.main.repaint();
        this.main.pack();
    }
}
