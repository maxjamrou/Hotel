package vue;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Sejour;

public class VueGererSejour extends JPanel{
    JTable table;
    DefaultTableModel model;
    VueHotel main;

    public VueGererSejour(VueHotel main){
        super(new BorderLayout());
        JLabel titre = new JLabel("Gérer séjour");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
        this.main = main;

        JLabel title = new JLabel("Gérer séjour");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        String[] columns = {"Client", "Type de chambre", "Etage", "€/Nuit", "hasMinibar", "Date", "prix conso"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        this.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel();
        JButton ajtConso = new JButton("Ajouter Consommation");
        JButton rechercher = new JButton("Rechercher");

        boutonsPanel.add(ajtConso);
        boutonsPanel.add(rechercher);
        this.add(boutonsPanel, BorderLayout.SOUTH);

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        table.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getSejours().size() - 1; i >= 0; i--) {
            Sejour s = this.main.getHotel().getSejours().get(i);
            model.addRow(new Object[]{
                    s.getReservation().getClient().getNom() + " " + s.getReservation().getClient().getPrenom(),
                    s.getReservation().getRoom().getType(),
                    s.getReservation().getRoom().getFloor(),
                    s.getReservation().getRoom().getPrice(),
                    s.getReservation().getRoom().hasMinibar(),
                    s.getReservation().getStartReservation() + " - " + s.getReservation().getEndReservation(),
                    s.getConsommationMinibar().getTotalPrice() + "€",
                    s
            });
        }
    }
}
