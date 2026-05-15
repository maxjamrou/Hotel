package vue;

import controller.ControllerMenu;
import controller.ControllerModifier;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Produit;

public class VueGererProduit extends JPanel {

    JTable table;
    DefaultTableModel model;
    VueHotel main;

    public VueGererProduit(VueHotel main) {
        super(new BorderLayout());
        this.main = main;

        JLabel title = new JLabel("Gestion des produits");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        String[] columns = {"Name", "Price", "Produit"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.removeColumn(table.getColumn("Produit"));

        this.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel();
        JButton ajouter = new JButton("Nouveau produit");
        JButton modifier = new JButton("Modifier produit");
        JButton rechercher = new JButton("Rechercher produit");

        ajouter.addActionListener(new ControllerMenu(main, main.listeActions));
        modifier.addActionListener(new ControllerModifier(main, table));

        boutonsPanel.add(ajouter);
        boutonsPanel.add(modifier);
        boutonsPanel.add(rechercher);
        this.add(boutonsPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getProducts().size() - 1 ; i>=0; i--) {
            Produit p = this.main.getHotel().getProducts().get(i);
            model.addRow(new Object[]{
                    p.getName(),
                    p.getPrice() + "€",
                    p
            });
        }
    }
}