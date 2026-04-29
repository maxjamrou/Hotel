package vue;

import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewListProduct extends JPanel {

    JTable table;
    DefaultTableModel model;
    VueHotel main;

    public ViewListProduct(VueHotel main) {
        super(new BorderLayout());
        this.main = main;

        String[] columns = {"Name", "Price", "Quantity"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        this.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // 🔥 refresh à la manière simple du prof
    public void refresh() {
        model.setRowCount(0);

        for (Product p : main.getHotel().getProducts()) {
            model.addRow(new Object[]{
                    p.getName(),
                    p.getPrice(),
                    p.getQuantity()
            });
        }
    }
}