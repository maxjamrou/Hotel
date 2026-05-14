package vue;

import controller.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Chambre;
import model.Reservation;

public class VueAjoutReservation2 extends JPanel{
    public VueHotel main;
    public DefaultTableModel model;
    public JTable table;
    public JScrollPane scroller;
    public ButtonGroup choixGroup;
    public Vector<JTextField> lFields;
    public Reservation reservation;

    public VueAjoutReservation2(VueHotel main){
        super(new BorderLayout(3,3));
        this.main = main;
        this.lFields = ((VueAjoutReservation)this.main.getListeActions().get(4)).lFields;
        JPanel choixP = new JPanel();
        JLabel choixL = new JLabel("Choix particulier sur la chambre : ");
        this.choixGroup = new ButtonGroup();
        JRadioButton choixOui = new JRadioButton("Oui");
        JRadioButton choixNon = new JRadioButton("Non");
        this.choixGroup.add(choixOui);
        this.choixGroup.add(choixNon);
        this.add(choixP, BorderLayout.NORTH);
        choixP.add(choixL);
        choixP.add(choixOui);
        choixP.add(choixNon);
        String[] columns = {"Étage", "Prix/Nuit", "Type de Chambre", "Possède un minibar", "Chambre"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.removeColumn(table.getColumn("Chambre"));
        scroller = new JScrollPane(table);
        
        ControllerSelectionner selectionner = new ControllerSelectionner(this.main, scroller);
        choixOui.addActionListener(selectionner);
        choixNon.addActionListener(selectionner);
        // this.add(scroller, BorderLayout.CENTER);

        JPanel formulaire = new JPanel(new GridLayout());
        
        
        // this.add(formulaire, BorderLayout.CENTER);

        Vector<JTextField> textFields = new Vector<>();
        Vector<JLabel> labels = new Vector<>();
        textFields.add(new JTextField("okokok"));
        labels.add(new JLabel());

        JPanel buttonJPanel = new JPanel();
        JButton precendent = new JButton("Précédent");
        JButton confirmer = new JButton("Ajouter réservation");
        precendent.addActionListener(new ControllerSuivPrec(this.main, this.choixGroup));
        confirmer.addActionListener(new ControllerAccepter(main, this.lFields, labels, choixNon));
        buttonJPanel.add(precendent);
        buttonJPanel.add(confirmer);
        this.add(buttonJPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().listChambresDisponibles(this.reservation.getStartReservation(), this.reservation.getEndReservation()).size() - 1 ; i>=0; i--) {
            Chambre c = this.main.getHotel().listChambresDisponibles(this.reservation.getStartReservation(), this.reservation.getEndReservation()).get(i);
            model.addRow(new Object[]{
                    c.getFloor(),
                    c.getPrice() + "€",
                    c.getType(),
                    c.hasMinibar()
            });
        }
    }
}
