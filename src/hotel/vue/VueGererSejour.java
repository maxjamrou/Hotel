package vue;

import model.Sejour;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VueGererSejour extends JPanel{

    JTable table;
    DefaultTableModel model;
    VueHotel main;

    public VueGererSejour(VueHotel main){
        super(new BorderLayout());
        this.main = main;

        JLabel title = new JLabel("Gérer séjour");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        String[] columns = {"Client", "Type de chambre", "etage", "hasMinibar", "Date", "prix conso"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        this.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel();
        JButton ajtConso = new JButton("Ajouter Consommation");
        JButton rechercher = new JButton("Rechercher");

        boutonsPanel.add(ajtConso);
        boutonsPanel.add(rechercher);
        this.add(boutonsPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getSejours().size() - 1; i >= 0; i--) {
            Sejour s = this.main.getHotel().getSejours().get(i);
            model.addRow(new Object[]{
                    s.getReservation().getClient().getNom() + " " + s.getReservation().getClient().getPrenom(),
                    s.getReservation().getRoom().getType(),
                    s.getReservation().getRoom().getFloor(),
                    s.getReservation().getStartReservation() + " - " + s.getReservation().getEndReservation(),
                    s.getConsommationMinibar() + "€"
            });
        }
    }
}
