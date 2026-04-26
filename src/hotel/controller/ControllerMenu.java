package controller;

import java.awt.Desktop;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
public class ControllerMenu implements ActionListener{
    /**
     * Attributs de ce qui peut changer
     */
    JFrame vueHotel;
    Vector<JPanel> listeActions;
    /**
     * Constructeur
     */
    public ControllerMenu(JFrame vueHotel, Vector<JPanel> la){
        this.vueHotel = vueHotel;
        this.listeActions = la;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.vueHotel.getContentPane().removeAll();
        if(((JMenuItem)e.getSource()).getText().equals("Nouveau client")){
            this.vueHotel.getContentPane().add(this.listeActions.get(0));
        } else if(((JMenuItem)e.getSource()).getText().equals("Gérer la liste des clients")){
            this.vueHotel.getContentPane().add(this.listeActions.get(1));
        } else if(((JMenuItem)e.getSource()).getText().equals("Nouvelle chambre")){
            this.vueHotel.getContentPane().add(this.listeActions.get(2));
        } else if(((JMenuItem)e.getSource()).getText().equals("Gérer la liste des chambres")){
            this.vueHotel.getContentPane().add(this.listeActions.get(3));
        } else if(((JMenuItem)e.getSource()).getText().equals("Nouvelle réservation")){
            this.vueHotel.getContentPane().add(this.listeActions.get(4));
        } else if(((JMenuItem)e.getSource()).getText().equals("Gérer la liste des réservations")){
            this.vueHotel.getContentPane().add(this.listeActions.get(5));
        } else if(((JMenuItem)e.getSource()).getText().equals("Gérer la liste des séjours")){
            this.vueHotel.getContentPane().add(this.listeActions.get(6));
        } else if(((JMenuItem)e.getSource()).getText().equals("Nouveau produit")){
            this.vueHotel.getContentPane().add(this.listeActions.get(7));
        } else if(((JMenuItem)e.getSource()).getText().equals("Gérer la liste des produits")){
            this.vueHotel.getContentPane().add(this.listeActions.get(8));
        } else if(((JMenuItem)e.getSource()).getText().equals("Ouvrir l'UML")){
            System.out.println("test");
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File("../../Hotelpdf.pdf"));
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
        }
        this.vueHotel.repaint();
        this.vueHotel.pack();
    }
}
