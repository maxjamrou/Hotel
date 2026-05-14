package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import vue.VueChambreInfo;


public class ControllerModifier implements ActionListener{
    JTable table;
    public static int isOpen = 0;

    @Override
    public void actionPerformed(ActionEvent e){
        if(isOpen == 0){
            isOpen = 1;
            VueChambreInfo chambre = new VueChambreInfo(null);
        }
    }
}
