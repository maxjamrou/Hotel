package controller;

import java.awt.event.*;
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
        if(((JMenuItem)e.getSource()).getText().equals("Nouvelle chambre")){
            this.vueHotel.getContentPane().removeAll();
            this.vueHotel.getContentPane().add(this.listeActions.get(0));
        } else if(((JMenuItem)e.getSource()).getText().equals("Nouveau client")){
            this.vueHotel.getContentPane().removeAll();
            this.vueHotel.getContentPane().add(this.listeActions.get(1));
        }
        this.vueHotel.repaint();
        this.vueHotel.pack();
    }
}
