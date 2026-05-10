package vue;

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

    public VueGererChambre(VueHotel main) {
        super(new BorderLayout());
        this.main = main;

        JLabel title = new JLabel("Gestion des chambres");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        String[] columns = {"Étage", "Prix", "Type de Chambre", "Possède un minibar"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        this.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel();
        JButton modifier = new JButton("Modifier chambre");
        JButton rechercher = new JButton("Rechercher chambre");

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
                    c.getMinibar()
            });
        }
    }
}
