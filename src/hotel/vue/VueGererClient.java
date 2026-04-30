package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Client;

public class VueGererClient extends JPanel {

    JTable table;
    DefaultTableModel model;
    VueHotel main;

    public VueGererClient(VueHotel main) {
        super(new BorderLayout());
        this.main = main;

        JLabel title = new JLabel("Gestion des cliens");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        String[] columns = {"Nom", "Prénom"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        this.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getClients().size() - 1 ; i>=0; i--) {
            Client c = this.main.getHotel().getClients().get(i);
            model.addRow(new Object[]{
                    c.getNom(),
                    c.getPrenom()
            });
        }
    }
}