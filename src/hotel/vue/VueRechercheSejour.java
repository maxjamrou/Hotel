package vue;

import controller.ControllerAjoutConso;
import model.Produit;
import model.Sejour;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VueRechercheSejour extends JPanel {
    JTable table;
    JTable table2;
    DefaultTableModel model;
    DefaultTableModel model2;
    VueHotel main;

    public VueRechercheSejour(VueHotel main) {
        super(new GridLayout(3, 1));
        this.main = main;

        JPanel top = new JPanel(new BorderLayout(5,5));
        JPanel center = new JPanel(new BorderLayout(5,5));
        JPanel bottom = new JPanel(new BorderLayout(5,5));
        JPanel research = new JPanel(new GridLayout(3,3));
        JPanel addConPanel = new JPanel(new GridLayout(1,2));

        JLabel titre = new JLabel("Recherche séjour");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(titre, BorderLayout.NORTH);

        String[] columns = {"Client", "Type de chambre", "Etage", "Prix/Nuit", "hasMinibar", "Date", "prix conso", "Sejour"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.removeColumn(table.getColumn("Sejour"));

        top.add(new JScrollPane(table), BorderLayout.CENTER);

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        table.getColumnModel().getColumn(6).setPreferredWidth(20);

        JLabel name = new JLabel("Nom :");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField nameField = new JTextField();
        JLabel surname = new JLabel("Prenom :");
        surname.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField surnameField = new JTextField();
        JLabel type = new JLabel("Type :");
        type.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField typeField = new JTextField();
        JLabel floor = new JLabel("Etage :");
        floor.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField floorField = new JTextField();
        JLabel price = new JLabel("Prix/Nuit :");
        price.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField priceField = new JTextField();
        JLabel hasminibar = new JLabel("A un minibar :");
        hasminibar.setHorizontalAlignment(SwingConstants.CENTER);
        ButtonGroup buttonGroup = new ButtonGroup();
        JPanel buttons = new JPanel(new GridLayout(1, 1));
        JRadioButton hasminibarButton = new JRadioButton("Oui");
        JRadioButton hasnotminibarButton = new JRadioButton("Non");
        hasminibarButton.setFocusPainted(false);
        hasnotminibarButton.setFocusPainted(false);
        buttonGroup.add(hasminibarButton);
        buttonGroup.add(hasnotminibarButton);
        buttons.add(hasminibarButton);
        buttons.add(hasnotminibarButton);
        JLabel dateStart = new JLabel("Date de debut :");
        dateStart.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField dateStartField = new JTextField();
        JLabel dateEnd = new JLabel("Date de fin :");
        dateEnd.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField dateEndField = new JTextField();
        JLabel total = new JLabel("Prix conso :");
        total.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField totalField = new JTextField();
        JButton rechercher = new JButton("Rechercher");
        rechercher.setHorizontalAlignment(SwingConstants.CENTER);
        rechercher.setFocusPainted(false);

        research.add(name);
        research.add(nameField);
        research.add(type);
        research.add(typeField);
        research.add(dateStart);
        research.add(dateStartField);
        research.add(surname);
        research.add(surnameField);
        research.add(floor);
        research.add(floorField);
        research.add(dateEnd);
        research.add(dateEndField);
        research.add(price);
        research.add(priceField);
        research.add(hasminibar);
        research.add(buttons);
        research.add(total);
        research.add(totalField);

        center.add(research, BorderLayout.CENTER);
        center.add(rechercher, BorderLayout.EAST);

        String[] column = {"Nom des produits", "Produit"};
        model2 = new DefaultTableModel(column, 0);

        table2 = new JTable(model2);
        table2.removeColumn(table2.getColumn("Produit"));

        JLabel quantity = new JLabel("Quantite :");
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField quantityField = new JTextField();
        JPanel quantityPanel = new JPanel(new GridLayout(1, 1));

        quantityPanel.add(quantity);
        quantityPanel.add(quantityField);

        addConPanel.add(new JScrollPane(table2));
        addConPanel.add(quantityPanel);
        JButton addCon = new JButton("Ajouter conso");
        addCon.setHorizontalAlignment(SwingConstants.CENTER);
        addCon.setFocusPainted(false);

        //bottom.add(listProducts, BorderLayout.CENTER);
        bottom.add(addConPanel, BorderLayout.CENTER);
        bottom.add(addCon, BorderLayout.EAST);

        this.add(top);
        this.add(center);
        this.add(bottom);

        //ControllerAjoutConso controller = new ControllerAjoutConso(this.main, this.table);
        //addCon.addActionListener(controller);
    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getSejours().size() - 1; i >= 0; i--) {
            Sejour s = this.main.getHotel().getSejours().get(i);
            model.addRow(new Object[]{
                    s.getReservation().getClient().getNom() + " " + s.getReservation().getClient().getPrenom(),
                    s.getReservation().getRoom().getType(),
                    s.getReservation().getRoom().getFloor(),
                    s.getReservation().getRoom().getPrice(),
                    s.getReservation().getRoom().hasMinibar(),
                    s.getReservation().getStartReservation() + " - " + s.getReservation().getEndReservation(),
                    s.getConsommationMinibar().TotalPrice() + "€",
                    s
            });
        }
    }

    public void refresh2() {
        model2.setRowCount(0);

        for (int i = this.main.getHotel().getProducts().size() - 1; i >= 0; i--) {
            Produit p = this.main.getHotel().getProducts().get(i);
            model2.addRow(new Object[]{
                    p.getName(),
                    p
            });
        }
    }
}
