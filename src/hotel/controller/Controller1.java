package controller;

import java.awt.event.*;
import javax.swing.*;
public class Controller1 implements ActionListener{
    /**
     * Attributs de ce qui peut changer
     */
    JPanel vueChambre;
    /**
     * Constructeur
     */
    public Controller1(JPanel vueChambre){
        this.vueChambre = vueChambre;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.vueChambre.setVisible(true);
    }
}
