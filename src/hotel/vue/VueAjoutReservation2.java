package vue;

import controller.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Chambre;
import model.Client;

public class VueAjoutReservation2 extends JPanel{
    VueHotel main;
    DefaultTableModel model;
    JTable table;
    
    Client client;

    public VueAjoutReservation2(VueHotel main){
        super(new BorderLayout(3,3));
        this.main = main;
        JPanel choixP = new JPanel();
        JLabel choixL = new JLabel("Choix particulier sur la chambre : ");
        ButtonGroup choixGroup = new ButtonGroup();
        JRadioButton choixOui = new JRadioButton("Oui");
        JRadioButton choixNon = new JRadioButton("Non");
        choixGroup.add(choixOui);
        choixGroup.add(choixNon);
        this.add(choixP, BorderLayout.NORTH);
        choixP.add(choixL);
        choixP.add(choixOui);
        choixP.add(choixNon);
        String[] columns = {"Étage", "Prix", "Type de Chambre", "Possède un minibar"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scroller = new JScrollPane(table);
        
        ControllerSelectionner selectionner = new ControllerSelectionner(this.main, scroller);
        choixOui.addActionListener(selectionner);
        choixNon.addActionListener(selectionner);
        // this.add(scroller, BorderLayout.CENTER);

        JPanel formulaire = new JPanel(new GridLayout());
        
        
        // this.add(formulaire, BorderLayout.CENTER);
        JPanel buttonJPanel = new JPanel();
        JButton precendent = new JButton("Précédent");
        JButton confirmer = new JButton("Confirmer");
        precendent.addActionListener(new ControllerSuivPrec(this.main, null));
        buttonJPanel.add(precendent);
        buttonJPanel.add(confirmer);
        this.add(buttonJPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getChambres().size() - 1 ; i>=0; i--) {
            Chambre c = this.main.getHotel().getChambres().get(i);
            model.addRow(new Object[]{
                    c.getFloor(),
                    c.getPrice() + "€",
                    c.getType(),
                    c.getMinibar()
            });
        }
    }
}
