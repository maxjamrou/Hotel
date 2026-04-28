package vue;

import model.Product;
import model.Hotel;

import javax.swing.*;
import java.awt.*;

public class ViewListProduct extends JPanel {

    private JList<Product> list;
    private DefaultListModel<Product> model;

    public ViewListProduct(Hotel hotel) {
        setLayout(new BorderLayout());

        model = new DefaultListModel<>();

        for (Product p : hotel.getProducts()) {
            model.addElement(p);
        }

        list = new JList<>(model);

        add(new JScrollPane(list), BorderLayout.CENTER);
    }

    public void refresh(Hotel hotel) {
        model.clear();
        for (Product p : hotel.getProducts()) {
            model.addElement(p);
        }
    }
}
