package controller;

import vue.VueHotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ControllerAjoutConso implements ActionListener {
    VueHotel vueHotel;
    JTable table;
    JScrollPane scroller;

    public ControllerAjoutConso(VueHotel vueHotel,  JTable table) {
        this.vueHotel = vueHotel;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}