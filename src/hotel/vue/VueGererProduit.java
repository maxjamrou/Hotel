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
    JLabel produitEltManquant;

    public VueGererProduit(VueHotel main) {
        super(new BorderLayout(3, 3));
        this.main = main;

        JLabel title = new JLabel("Gestion des produits");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        String[] columns = {"Name", "Price", "Produit"};
        model = new DefaultTableModel(columns, 0);

        JPanel tableau = new JPanel(new BorderLayout());
        table = new JTable(model);
        table.removeColumn(table.getColumn("Produit"));
        this.produitEltManquant = new JLabel();

        tableau.add(new JScrollPane(table), BorderLayout.CENTER);
        tableau.add(produitEltManquant, BorderLayout.SOUTH);

        this.add(tableau, BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel();
        JButton ajouter = new JButton("Nouveau produit");
        JButton modifier = new JButton("Modifier produit");
        JButton rechercher = new JButton("Rechercher produit");

        ControllerMenu menu = new ControllerMenu(main, main.listeActions);
        ajouter.addActionListener(menu);
        modifier.addActionListener(new ControllerModifier(main, table, produitEltManquant));
        rechercher.addActionListener(menu);

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

    public JLabel getLabelErreur(){return this.produitEltManquant;}
}