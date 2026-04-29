package vue;

import model.Product;
import model.Hotel;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ViewAddProduct extends JPanel {

    private JTextField textName = new JTextField();
    private JTextField textPrice = new JTextField();
    private JTextField textQuantity = new JTextField();
    private JButton btnAdd = new JButton("Add");

    public ViewAddProduct(Hotel hotel) {

        setLayout(new BorderLayout());

        // TITLE
        JLabel title = new JLabel("Add Product");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // FORM
        JPanel form = new JPanel(new GridLayout(3,2));

        form.add(new JLabel("Name:"));
        form.add(textName);

        form.add(new JLabel("Price:"));
        form.add(textPrice);

        form.add(new JLabel("Quantity:"));
        form.add(textQuantity);

        add(form, BorderLayout.CENTER);

        // BUTTON
        btnAdd.setBackground(Color.GREEN);
        btnAdd.setFocusPainted(false);

        add(btnAdd, BorderLayout.SOUTH);

        // ACTION
//        Vector<JTextField> listJTextFields = new Vector<JTextField>(0);
//        listJTextFields.add(textName);
//        listJTextFields.add(textPrice);
//        listJTextFields.add(textQuantity);
//        ControllerAccepter accepter = new ControllerAccepter(this, title.getText(), listJTextFields, listJLabels, null, null);
//        btnAdd.addActionListener(accepter);
        btnAdd.addActionListener(e -> {
            try {
                String name = getProductName();
                double price = getProductPrice();
                int quantity = getProductQuantity();

                Product p = new Product(name, price, quantity);
                hotel.addProduct(p);

                JOptionPane.showMessageDialog(this, "Product added !");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input error");
            }
        });
    }

    // 🔥 GETTERS (IMPORTANT)

    public String getProductName() {
        return textName.getText();
    }

    public double getProductPrice() {
        return Double.parseDouble(textPrice.getText());
    }

    public int getProductQuantity() {
        return Integer.parseInt(textQuantity.getText());
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }
}