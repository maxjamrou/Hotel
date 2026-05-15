package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Chambre;
import model.Client;
import model.Produit;
import vue.*;

public class ControllerAccepter implements ActionListener{
    VueHotel main;
    Vector<JTextField> listeJTextFields;
    Vector<JLabel> listJLabels;
    JRadioButton jRadioButton;
    JComboBox<String> jComboBox;
    
    public ControllerAccepter(VueHotel main, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels){
        this.main = main;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
    }

    public ControllerAccepter(VueHotel main, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels, JRadioButton jrb){
        this.main = main;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
        this.jRadioButton = jrb;
    }

    public ControllerAccepter(VueHotel main, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels, JRadioButton jrb, JComboBox<String> jcb){
        this.main = main;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
        this.jRadioButton = jrb;
        this.jComboBox = jcb;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        boolean canBePerformed = true;
        Vector<String> listeStrFields = new Vector<String>();
        for (int i = 0; i < this.listeJTextFields.size(); i++) {
            if(((JButton)e.getSource()).getText().equals("Ajouter réservation")){
                if(this.jRadioButton.isSelected() == true){
                    break;
                }
            }
            listeStrFields.add(listeJTextFields.get(i).getText());
            if(listeStrFields.get(i).length() == 0){
                this.listJLabels.get(i).setText("*Elément manquant");
                this.listJLabels.get(i).setForeground(Color.red);
                canBePerformed = false;
            } else {
                this.listJLabels.get(i).setText("");
            }
        }
        int intValue = 0;
        double prix = 0.0;
        if(((JButton)e.getSource()).getText().equals("Ajouter chambre")){
            try{
                intValue = Integer.parseInt(listeStrFields.get(0));
            } catch(NumberFormatException ex){
                if(listeStrFields.get(0).length()!=0){
                    listeJTextFields.get(0).setText("");
                    listJLabels.get(0).setText("*Element doit être un nombre");
                    this.listJLabels.get(0).setForeground(Color.red);
                    canBePerformed = false;
                }
            }
            try{
                prix = Double.parseDouble(listeStrFields.get(1));
            } catch(NumberFormatException ex) {
                if(listeStrFields.get(1).length()!=0){
                    listeJTextFields.get(1).setText("");
                    listJLabels.get(1).setText("*Element doit être un nombre");
                    this.listJLabels.get(1).setForeground(Color.red);
                    canBePerformed = false;
                }
            }
        } else if(((JButton)e.getSource()).getText().equals("Ajouter produit")){
            try{
                prix = Double.parseDouble(listeStrFields.get(1));
            } catch(NumberFormatException ex) {
                if(listeStrFields.get(1).length()!=0){
                    listeJTextFields.get(1).setText("");
                    listJLabels.get(1).setText("*Element doit être un nombre");
                    this.listJLabels.get(1).setForeground(Color.red);
                    canBePerformed = false;
                }
            }
        } else if(((JButton)e.getSource()).getText().equals("Ajouter réservation")){
            intValue = ((VueAjoutReservation2)this.main.getListeActions().get(9)).table.getSelectedRow();
            if(intValue == -1){
                canBePerformed = false;
                //JLabel cas erreur
            }
            System.out.println("works" + intValue + canBePerformed);
        }
        if(canBePerformed){
            if(prix<0){prix=-prix;}
            if(intValue<0){intValue=-intValue;}
            System.out.println(((JButton)e.getSource()).getText());
            this.main.getContentPane().removeAll();
            switch (((JButton)e.getSource()).getText()) {
                case "Ajouter client":
                    this.main.getHotel().addClient(new Client(listeStrFields.get(0), listeStrFields.get(1), this.main.getHotel()));
                    ((VueGererClient)this.main.listeActions.get(2)).refresh();
                    this.main.getContentPane().add(this.main.getListeActions().get(2));
                    this.main.repaint();
                    break;
                case "Ajouter chambre":
                    boolean hasMinibar = true;
                    if(this.jRadioButton.isSelected()){hasMinibar = false;}
                    this.main.getHotel().addChambre(new Chambre(intValue, prix, hasMinibar, (String)this.jComboBox.getSelectedItem(), this.main.getHotel()));
                    System.out.println(Integer.parseInt(listeStrFields.get(0)) + Double.parseDouble(listeStrFields.get(1)));
                    this.jRadioButton.setSelected(true);
                    this.jComboBox.setSelectedItem("Simple");
                    ((VueGererChambre)this.main.listeActions.get(6)).refresh();
                    this.main.getContentPane().add(this.main.getListeActions().get(6));
                    break;
                case "Ajouter réservation":
                    System.out.println("worksout");
                    VueAjoutReservation2 vue = ((VueAjoutReservation2)this.main.getListeActions().get(9));
                    vue.reservation.setChambre((Chambre)(vue.table.getModel()).getValueAt(intValue, 4));
                    vue.reservation.getHotel().addReservation(vue.reservation);
                    vue.reservation.getClient().addReservation(vue.reservation);
                    vue.reservation.getRoom().addReservation(vue.reservation);
                    System.out.println(vue.reservation.getClient().getPrenom());
                    System.out.println(vue.reservation.getClient().getReservations().get(vue.reservation.getClient().getReservations().size() - 1).getClient().getPrenom());
                    System.out.println(vue.reservation.getClient().getReservations().get(vue.reservation.getClient().getReservations().size() - 1).getStartReservation().toString());
                    System.out.println(vue.reservation.getClient().getReservations().get(vue.reservation.getClient().getReservations().size() - 1).getEndReservation().toString());
                    System.out.println(vue.reservation.getHotel().getReservations().get(vue.reservation.getHotel().getReservations().size() - 1).getStartReservation().toString());
                    System.out.println(vue.reservation.getHotel().getReservations().get(vue.reservation.getHotel().getReservations().size() - 1).getEndReservation().toString());
                    System.out.println(vue.reservation.getRoom().getFloor());
                    ((DefaultTableModel)((VueAjoutReservation)this.main.getListeActions().get(8)).getTable().getModel()).setRowCount(0);
                    ((VueGererReservation)this.main.listeActions.get(11)).refresh();
                    this.main.getContentPane().add(this.main.getListeActions().get(11));
                    break;
                case "Ajouter produit":
                    this.main.getHotel().addProduit(new Produit(listeStrFields.get(0), 0, prix, this.main.getHotel()));
                    ((VueGererProduit)this.main.listeActions.get(16)).refresh();
                    this.main.getContentPane().add(this.main.getListeActions().get(16));
                    break;
                default:
                    break;
            }
            for (int i = 0; i < this.listeJTextFields.size(); i++) {
                this.listeJTextFields.get(i).setText("");
            }
            this.main.repaint(); 
            this.main.pack();
        }
    }
}
