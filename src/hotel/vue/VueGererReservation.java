package vue;

import controller.ControllerMenu;
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

        String[] columns = {"Client", "Type chambre", "Etage", "Prix/nuit", "hasMinibar", "Date", "Reservation"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.removeColumn(table.getColumn("Reservation"));

        this.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel();
        JButton ajouter = new JButton("Nouvelle réservation");
        JButton modifier = new JButton("Annuler réservation");
        JButton rechercher = new JButton("Rechercher réservation");

        ajouter.addActionListener(new ControllerMenu(main, main.listeActions));

        boutonsPanel.add(ajouter);
        boutonsPanel.add(modifier);
        boutonsPanel.add(rechercher);
        this.add(boutonsPanel, BorderLayout.SOUTH);

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(30);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getReservations().size() - 1 ; i>=0; i--) {
            Reservation r = this.main.getHotel().getReservations().get(i);
            model.addRow(new Object[]{
                    r.getClient().getNom() + " " + r.getClient().getPrenom(),
                    r.getRoom().getType(),
                    r.getRoom().getFloor(),
                    r.getRoom().getPrice(),
                    r.getRoom().hasMinibar(),
                    r.getStartReservation() + " - " + r.getEndReservation(),
                    r
            });
        }
    }
}