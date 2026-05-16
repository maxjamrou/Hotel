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

        Vector<JTextField> lFields = new Vector<>();
        Vector<JLabel> lJLabels = new Vector<>();

        JLabel title = new JLabel("Ajouter produit");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

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

        btnAdd.setFocusPainted(false);

        ControllerAccepter accepter = new ControllerAccepter(main, lFields, lJLabels);
        btnAdd.addActionListener(accepter);

        add(btnAdd, BorderLayout.SOUTH);
    }

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