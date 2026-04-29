package controller;

import java.awt.Desktop;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
import vue.VueHotel;
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

    @Override
    public void actionPerformed(ActionEvent e){
        this.vueHotel.getContentPane().removeAll();
        switch (((JMenuItem)e.getSource()).getText()) {
            case "Nouveau client":
                this.vueHotel.getContentPane().add(this.listeActions.get(0));
                break;
            case "Gérer la liste des clients":
                this.vueHotel.getContentPane().add(this.listeActions.get(1));
                break;
            case "Nouvelle chambre":
                this.vueHotel.getContentPane().add(this.listeActions.get(2));
                break;
            case "Gérer la liste des chambres":
                this.vueHotel.getContentPane().add(this.listeActions.get(3));
                break;
            case "Nouvelle réservation":
                this.vueHotel.getContentPane().add(this.listeActions.get(4));
                break;
            case "Gérer la liste des réservations":
                this.vueHotel.getContentPane().add(this.listeActions.get(5));
                break;
            case "Gérer la liste des séjours":
                this.vueHotel.getContentPane().add(this.listeActions.get(6));
                break;
            case "Nouveau produit":
                this.vueHotel.getContentPane().add(this.listeActions.get(7));
                break;
            case "Gérer la liste des produits":
                this.vueHotel.getContentPane().add(this.listeActions.get(8));
                break;
            case "Ouvrir l'UML":
                System.out.println("test");
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().open(new File("../../Hotelpdf.pdf"));
                    } catch (IOException ex) {
                        // no application registered for PDFs
                    }
                }   break;
            default:
                break;
        }
        this.vueHotel.repaint();
        this.vueHotel.pack();
    }
}
