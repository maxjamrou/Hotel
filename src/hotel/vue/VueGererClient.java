package vue;

import controller.ControllerMenu;
import controller.ControllerModifier;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Client;

public class VueGererClient extends JPanel {

    JTable table;
    DefaultTableModel model;
    VueHotel main;
    JLabel clientEltManquant;

    public VueGererClient(VueHotel main) {
        super(new BorderLayout(3, 3));
        this.main = main;

        JLabel title = new JLabel("Gestion des clients");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        String[] columns = {"Nom", "Prénom", "Client"};
        model = new DefaultTableModel(columns, 0);

        JPanel tableau = new JPanel(new BorderLayout());
        this.clientEltManquant = new JLabel();
        table = new JTable(model);
        table.removeColumn(table.getColumn("Client"));

        tableau.add(new JScrollPane(table), BorderLayout.CENTER);
        tableau.add(clientEltManquant, BorderLayout.SOUTH);

        this.add(tableau, BorderLayout.CENTER);
        JPanel boutonsPanel = new JPanel();
        JButton ajouter = new JButton("Nouveau client");
        JButton modifier = new JButton("Modifier client");
        JButton rechercher = new JButton("Rechercher client");

        ajouter.addActionListener(new ControllerMenu(main, main.listeActions));
        modifier.addActionListener(new ControllerModifier(main, table, clientEltManquant));

        boutonsPanel.add(ajouter);
        boutonsPanel.add(modifier);
        boutonsPanel.add(rechercher);
        this.add(boutonsPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getClients().size() - 1 ; i>=0; i--) {
            Client c = this.main.getHotel().getClients().get(i);
            model.addRow(new Object[]{
                    c.getNom(),
                    c.getPrenom(),
                    c
            });
        }
    }

    public JLabel getLabelErreur(){return this.clientEltManquant;}
}