package vue;

import controller.ControllerMenu;
import controller.ControllerModifier;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Chambre;

public class VueGererChambre extends JPanel{
    JTable table;
    DefaultTableModel model;
    VueHotel main;
    JLabel chambreEltManquant;

    public VueGererChambre(VueHotel main) {
        super(new BorderLayout(3, 3));
        this.main = main;

        JLabel title = new JLabel("Gestion des chambres");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        JPanel tableau = new JPanel(new BorderLayout());
        String[] columns = {"Étage", "Prix", "Type de Chambre", "Possède un minibar", "Chambre"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.removeColumn(table.getColumn("Chambre"));
        this.chambreEltManquant = new JLabel();
        tableau.add(new JScrollPane(table), BorderLayout.CENTER);
        tableau.add(this.chambreEltManquant, BorderLayout.SOUTH);
        this.add(tableau, BorderLayout.CENTER);
        JPanel boutonsPanel = new JPanel();
        JButton ajouter = new JButton("Nouvelle chambre");
        JButton modifier = new JButton("Modifier chambre");
        JButton rechercher = new JButton("Rechercher chambre");

        ajouter.addActionListener(new ControllerMenu(main, main.listeActions));
        modifier.addActionListener(new ControllerModifier(main, table, this.chambreEltManquant));

        boutonsPanel.add(ajouter);
        boutonsPanel.add(modifier);
        boutonsPanel.add(rechercher);

        this.add(boutonsPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getChambres().size() - 1 ; i>=0; i--) {
            Chambre c = this.main.getHotel().getChambres().get(i);
            model.addRow(new Object[]{
                    c.getFloor(),
                    c.getPrice() + "€",
                    c.getType(),
                    c.hasMinibar(),
                    c
            });
        }
    }

    public JLabel getLabelErreur(){return this.chambreEltManquant;}
}
