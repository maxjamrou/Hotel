package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Chambre;
import model.Client;
import vue.VueHotel;

public class ControllerAccepter implements ActionListener{
    VueHotel main;
    String titre;
    Vector<JTextField> listeJTextFields;
    Vector<JLabel> listJLabels;
    JRadioButton jRadioButton;
    JComboBox<String> jComboBox;
    
    public ControllerAccepter(VueHotel main, String titre, Vector<JTextField> listTextFields, Vector<JLabel> listJLabels, JRadioButton jrb, JComboBox<String> jcb){
        this.main = main;
        this.titre = titre;
        this.listeJTextFields = listTextFields;
        this.listJLabels = listJLabels;
        this.jRadioButton = jrb;
        this.jComboBox = jcb;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        boolean canBePerformed = true;
        Vector<String> listeStrFields = new Vector<String>();
        for (int i = 0; i < this.listeJTextFields.capacity(); i++) {
            listeStrFields.add(listeJTextFields.get(i).getText());
            if(listeStrFields.get(i).length() == 0){
                this.listJLabels.get(i).setText("*Elément manquant");
                canBePerformed = false;
            } else {
                this.listJLabels.get(i).setText("");
            }
        }
        if(canBePerformed){
            if(titre.equals("Ajouter client")){
                this.main.getHotel().addClient(new Client(listeStrFields.get(0), listeStrFields.get(1), this.main.getHotel()));
            } else if (titre.equals("Ajouter chambre")){
                boolean isSelected = false;
                if(this.jRadioButton.isSelected()){isSelected = true;}
                this.main.getHotel().addChambre(new Chambre(Integer.parseInt(listeStrFields.get(0)), Double.parseDouble(listeStrFields.get(1)), isSelected, (String)this.jComboBox.getSelectedItem(), this.main.getHotel()));
                this.jRadioButton.setSelected(true);
                this.jComboBox.setSelectedItem("Simple");
            }
            for (int i = 0; i < this.listeJTextFields.capacity(); i++) {
                this.listeJTextFields.get(i).setText("");
            }
            this.main.getContentPane().removeAll();
            this.main.repaint(); 
        }
    }
}
