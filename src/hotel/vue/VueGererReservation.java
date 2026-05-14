package vue;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Reservation;

public class VueGererReservation extends JPanel {
    JTable table;
    DefaultTableModel model;
    VueHotel main;

    public VueGererReservation(VueHotel main) {
        super(new BorderLayout());
        JLabel titre = new JLabel("Gérer réservation");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
        this.main = main;

        JLabel title = new JLabel("Gérer réservation");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        String[] columns = {"Client", "Date", "Type chambre", "Etage", "Prix/nuit", "hasMinibar"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        this.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel();
        JButton modifier = new JButton("Modifier client");
        JButton rechercher = new JButton("Rechercher client");

        boutonsPanel.add(modifier);
        boutonsPanel.add(rechercher);
        this.add(boutonsPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getClients().size() - 1 ; i>=0; i--) {
            Reservation r = this.main.getHotel().getReservations().get(i);
            model.addRow(new Object[]{
                    r.getClient().getNom() + " " + r.getClient().getPrenom(),
                    r.getStartReservation() + " - " + r.getEndReservation(),
                    r.getRoom().getType(),
                    r.getRoom().getFloor(),
                    r.getRoom().getPrice(),
                    r.getRoom().hasMinibar()
            });
        }
    }
}