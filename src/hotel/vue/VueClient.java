package hotel.vue;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.*;

import hotel.controller.ClientController;

public class VueClient extends JFrame {
    
    private ClientController controller;

    public VueClient(ClientController controller) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Liste des clients");
        add.title(BorderLayout.NORTH);

        String[][] data = {};
        for (int i = 0; i < controller.getClient().capacity(); i++) {
            String[] tmp = {controller.getClients().get(i).getNom(), controller.getClients().get(i).getPrenom()};
        }

        Vector<String> columns = new Vector<String>();
        columns.add("n");
        columns.add("p");
        JTable table = new JTable(data, columns);
    }
}
