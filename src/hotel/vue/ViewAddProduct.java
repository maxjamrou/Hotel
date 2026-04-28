package vue;

import javax.swing.*;
import java.awt.*;

public class ViewAddProduct extends JPanel {

    private JTextField textName = new JTextField(10);
    private JTextField textPrice = new JTextField(10);
    private JTextField textQuantity = new JTextField(10);
    private JButton btnAadd = new JButton("Ajouter");

    public ViewAddProduct() {
        setSize(300, 200);
        setLayout(new GridLayout(4,2));

        add(new JLabel("Name:"));
        add(textName);

        add(new JLabel("Price:"));
        add(textPrice);

        add(new JLabel("Quantity:"));
        add(textQuantity);

        add(btnAadd);

        setVisible(true);
    }

    // GETTERS POUR LE CONTROLLER
    public String getName() {return textName.getText();}
    public double getPrice() {return Double.parseDouble(textPrice.getText());}
    public int getQuantity() {return Integer.parseInt(textQuantity.getText());}

    public JButton getBtnAjouter() {return btnAadd;}
}
