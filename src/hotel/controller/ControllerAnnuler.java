package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vue.VueGererChambre;
import vue.VueGererClient;
import vue.VueGererProduit;
import vue.VueHotel;
import vue.VueRechercherChambre;
import vue.VueRechercherClient;
import vue.VueRechercherProduit;

public class ControllerAnnuler implements ActionListener{
    VueHotel main;

    public ControllerAnnuler(VueHotel main){
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.main.getContentPane().removeAll();
        switch(((JButton)e.getSource()).getText()){
            case "Annuler modifications client":
                this.main.listeActions.set(1, new VueRechercherClient(main));
                ((VueGererClient)this.main.getListeActions().get(2)).refresh();
                this.main.getContentPane().add(this.main.getListeActions().get(2));
                break;
            case "Annuler modifications chambre" :
                this.main.listeActions.set(5, new VueRechercherChambre(main));
                ((VueGererChambre)this.main.getListeActions().get(6)).refresh();
                this.main.getContentPane().add(this.main.getListeActions().get(6));
                break;
            case "Annuler modifications produit":
                this.main.listeActions.set(15, new VueRechercherProduit(main));
                ((VueGererProduit)this.main.getListeActions().get(16)).refresh();
                this.main.getContentPane().add(this.main.getListeActions().get(16));
            default:
                break;
        }
        this.main.repaint();
        this.main.pack();
    }
}
