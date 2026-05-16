package controller;

import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import vue.*;
public class ControllerMenu implements ActionListener{
    /**
     * Attributs de ce qui peut changer
     */
    VueHotel vueHotel;
    Vector<JPanel> listeActions;
    /**
     * Constructeur
     */
    public ControllerMenu(VueHotel vueHotel, Vector<JPanel> la){
        this.vueHotel = vueHotel;
        this.listeActions = la;
    }

    // listeActions.add(new VueAjoutClient(this));              0
    // listeActions.add(new VueRechercherClient(this));         1
    // listeActions.add(new VueGererClient(this));              2
    // listeActions.add(new VueInfoClient(this));               3
    // listeActions.add(new VueAjoutChambre(this));             4
    // listeActions.add(new VueRechercherChambre(this));        5
    // listeActions.add(new VueGererChambre(this));             6
    // listeActions.add(new VueInfoChambre(this));              7
    // listeActions.add(new VueAjoutReservation(this));         8
    // listeActions.add(new VueAjoutReservation2(this));        9
    // listeActions.add(new VueRechercherReservation(this));    10 
    // listeActions.add(new VueGererReservation(this));         11
    // listeActions.add(new VueRechercherSejour(this));         12 
    // listeActions.add(new VueGererSejour(this));              13
    // listeActions.add(new VueAjoutProduit(this));             14
    // listeActions.add(new VueRechercherProduit(this));        15      
    // listeActions.add(new VueGererProduit(this));             16
    // listeActions.add(new VueInfoProduit(this));              17

    @Override
    public void actionPerformed(ActionEvent e){
        this.vueHotel.getContentPane().removeAll();
        Object src = e.getSource();
        String txt = "";
        if(src instanceof JButton){txt = ((JButton)src).getText();} 
        else if (src instanceof JMenuItem){txt = ((JMenuItem)src).getText();}
        switch (txt) {
            case "Nouveau client":
                this.vueHotel.getContentPane().add(this.listeActions.get(0));
                break;
            case "Rechercher client":
                this.vueHotel.getContentPane().add(this.listeActions.get(1));
                break;
            case "Gérer la liste des clients":
                ((VueGererClient)this.listeActions.get(2)).getLabelErreur().setText("");;
                ((VueGererClient)this.listeActions.get(2)).refresh();
                this.vueHotel.getContentPane().add(this.listeActions.get(2));
                break;
            case "Nouvelle chambre":
                this.vueHotel.getContentPane().add(this.listeActions.get(4));
                break;
            case "Rechercher chambre":
                this.vueHotel.getContentPane().add(this.listeActions.get(5));
                break;
            case "Gérer la liste des chambres":
                ((VueGererChambre)this.listeActions.get(6)).getLabelErreur().setText("");
                ((VueGererChambre)this.listeActions.get(6)).refresh();
                this.vueHotel.getContentPane().add(this.listeActions.get(6));
                break;
            case "Nouvelle réservation":
                this.vueHotel.getContentPane().add(this.listeActions.get(8));
                break;
            case "Rechercher réservation":
                this.vueHotel.getContentPane().add(this.listeActions.get(10));
                break;
            case "Gérer la liste des réservations":
                ((VueGererReservation)this.listeActions.get(11)).refresh();
                this.vueHotel.getContentPane().add(this.listeActions.get(11));
                break;
            case "Rechercher un séjour":
                ((VueRechercherSejour)this.listeActions.get(12)).refreshTable();
                ((VueRechercherSejour)this.listeActions.get(12)).refreshButtons();
                ((VueRechercherSejour)this.listeActions.get(12)).resetMode();
                this.vueHotel.getContentPane().add(this.listeActions.get(12));
                break;
            case "Gérer la liste des séjours":
                ((VueGererSejour)this.listeActions.get(13)).refresh();
                this.vueHotel.getContentPane().add(this.listeActions.get(13));
                break;
            case "Nouveau produit":
                this.vueHotel.getContentPane().add(this.listeActions.get(14));
                break;
            case "Rechercher produit":
                this.vueHotel.getContentPane().add(this.listeActions.get(15));
                break;
            case "Gérer la liste des produits":
                ((VueGererProduit)this.listeActions.get(16)).getLabelErreur().setText("");
                ((VueGererProduit)this.listeActions.get(16)).refresh();
                this.vueHotel.getContentPane().add(this.listeActions.get(16));
                System.out.println(this.vueHotel.getHotel().afficheAllProduit());
                break;
            default:
                break;
        }
        this.vueHotel.repaint();
        this.vueHotel.pack();
    }
}
