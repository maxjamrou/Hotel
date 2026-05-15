package vue;

import controller.ControllerAccepter;
import java.awt.*;
import java.util.Vector;
import javax.swing.*;

public class VueAjoutProduit extends JPanel {
    VueHotel main;
    private JTextField textName = new JTextField();
    private JTextField textPrice = new JTextField();
    private JTextField textQuantity = new JTextField();
    private JButton btnAdd = new JButton("Ajouter produit");

    public VueAjoutProduit(VueHotel main) {
        super(new BorderLayout());
        this.main = main;

        // VECTORS
        Vector<JTextField> lFields = new Vector<>();
        Vector<JLabel> lJLabels = new Vector<>();


        // TITLE
        JLabel title = new JLabel("Ajouter produit");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // FORM
        JPanel form = new JPanel(new GridLayout(2,2,3,3));

        form.add(new JLabel("Nom :"));

        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel nomEltManquant = new JLabel();
        lFields.add(textName);
        lJLabels.add(nomEltManquant);
        namePanel.add(textName, BorderLayout.CENTER);
        namePanel.add(nomEltManquant, BorderLayout.SOUTH);
        form.add(namePanel);

        form.add(new JLabel("Prix :"));

        JPanel pricePanel = new JPanel(new BorderLayout());
        JLabel prixEltManquant = new JLabel();
        lFields.add(textPrice);
        lJLabels.add(prixEltManquant);
        pricePanel.add(textPrice, BorderLayout.CENTER);
        pricePanel.add(prixEltManquant, BorderLayout.SOUTH);
        form.add(pricePanel);

        add(form, BorderLayout.CENTER);

        // BUTTON
        btnAdd.setBackground(Color.GREEN);
        btnAdd.setFocusPainted(false);

        // CONTROLLER
        ControllerAccepter accepter = new ControllerAccepter(main, lFields, lJLabels);
        btnAdd.addActionListener(accepter);

        add(btnAdd, BorderLayout.SOUTH);

        // ACTION
//        Vector<JTextField> listJTextFields = new Vector<JTextField>(0);
//        listJTextFields.add(textName);
//        listJTextFields.add(textPrice);
//        listJTextFields.add(textQuantity);
//        ControllerAccepter accepter = new ControllerAccepter(this, title.getText(), listJTextFields, listJLabels, null, null);
//        btnAdd.addActionListener(accepter);



        // btnAdd.addActionListener(e -> {
        //     try {
        //         String name = getProductName();
        //         double price = getProductPrice();
        //         int quantity = getProductQuantity();

        //         this.main.getHotel().addProduit(new Produit(name, quantity, price, this.main.getHotel()));

        //         JOptionPane.showMessageDialog(this, "Product added !");
        //     } catch (Exception ex) {
        //         JOptionPane.showMessageDialog(this, "Input error");
        //     }
        // });
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