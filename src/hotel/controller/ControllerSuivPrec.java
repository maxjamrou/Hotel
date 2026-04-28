package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControllerSuivPrec implements ActionListener{
    JFrame vueHotel;
    JPanel current;
    Vector<JTextField> lFields;

    public ControllerSuivPrec(JFrame vueHotel, JPanel current, Vector<JTextField> lFields){
        this.vueHotel = vueHotel;
        this.current = current;
        this.lFields = lFields;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(((JButton)e.getSource()).getText().equals("Suivant")){
            System.out.println("");
        }
    }
}
