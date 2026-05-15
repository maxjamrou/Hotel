package vue;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ControllerActionSejour;
import model.Produit;
import model.Sejour;

public class VueRechercherSejour extends JPanel {
    JTable table;
    JTable tableInvoice;
    JTable tableProduct;
    DefaultTableModel model;
    DefaultTableModel modelInvoice;
    DefaultTableModel modelProduct;
    VueHotel main;
    JPanel bottomActions;
    JPanel bottomInvoice;
    JPanel bottomAddCon;

    public VueRechercherSejour(VueHotel main) {
        super(new GridLayout(3, 1));
        this.main = main;

        JPanel top = new JPanel(new BorderLayout(5,5));
        JPanel center = new JPanel(new BorderLayout(5,5));
        bottomActions = new JPanel(new BorderLayout(5,5));
        bottomInvoice = new JPanel(new BorderLayout(5,5));
        bottomAddCon = new JPanel(new BorderLayout(5,5));
        JPanel research = new JPanel(new GridLayout(3,3));
        JPanel invoicePanel = new JPanel(new GridLayout(1,2));
        JPanel addConPanel = new JPanel(new GridLayout(1,2));

        JLabel titre = new JLabel("Recherche séjour");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(titre, BorderLayout.NORTH);

        String[] columns = {"Client", "Type de chambre", "Etage", "Prix/Nuit", "hasMinibar", "Date", "prix conso", "Sejour fini", "Sejour"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.removeColumn(table.getColumn("Sejour"));
        JScrollPane scrollPane1 = new JScrollPane(table);

        top.add(scrollPane1, BorderLayout.CENTER);

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
        JLabel totalLabel = new JLabel("Prix conso :");
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
        research.add(totalLabel);
        research.add(totalField);

        center.add(research, BorderLayout.CENTER);
        center.add(rechercher, BorderLayout.EAST);

        JButton invoice1 = new JButton("Facturer un sejour");
        JButton addCon1 = new JButton("Ajouter une consommation");

        JPanel actionsPane = new JPanel(new FlowLayout());
        actionsPane.add(invoice1);
        actionsPane.add(addCon1);
        bottomActions.add(actionsPane, BorderLayout.SOUTH);

        String[] columnsInvoice = {"Nom des produits", "Quantite", "Prix stack", "Produit"};
        modelInvoice = new DefaultTableModel(columnsInvoice, 0);

        tableInvoice = new JTable(modelInvoice);
        tableInvoice.removeColumn(tableInvoice.getColumn("Produit"));
        JScrollPane scrollPaneInvoice = new JScrollPane(tableInvoice);
        JButton refreshBtn = new JButton("Rafraichir");

        JLabel total = new JLabel("Total a payer :");
        JLabel totalCon = new JLabel("Total consomme :");
        JLabel totalPrice = new JLabel("Total des nuits :");

        JPanel totalCalcPane = new JPanel(new GridLayout(2,1));
        totalCalcPane.add(totalCon);
        totalCalcPane.add(totalPrice);

        JPanel invoiceTablePanel = new JPanel(new BorderLayout());
        invoiceTablePanel.add(scrollPaneInvoice, BorderLayout.CENTER);
        invoiceTablePanel.add(refreshBtn, BorderLayout.EAST);

        JPanel totalPane = new JPanel(new GridLayout(2, 1));
        totalPane.add(total);
        totalPane.add(totalCalcPane);

        invoicePanel.add(invoiceTablePanel);
        invoicePanel.add(totalPane);

        JButton invoiceButton = new JButton("Facturer");
        invoiceButton.setFocusPainted(false);

        bottomInvoice.add(invoicePanel, BorderLayout.CENTER);
        bottomInvoice.add(invoiceButton, BorderLayout.EAST);

        String[] columnsProduct = {"Nom des produits", "Produit"};
        modelProduct = new DefaultTableModel(columnsProduct, 0);

        tableProduct = new JTable(modelProduct);
        tableProduct.removeColumn(tableProduct.getColumn("Produit"));
        JScrollPane scrollPaneProduct = new JScrollPane(tableProduct);

        JLabel quantity = new JLabel("Quantite :");
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField quantityField = new JTextField();
        JPanel quantityPanel = new JPanel(new GridLayout(1, 1));

        quantityPanel.add(quantity);
        quantityPanel.add(quantityField);
        addConPanel.add(scrollPaneProduct);
        addConPanel.add(quantityPanel);
        JButton addCon2 = new JButton("Ajouter conso");
        addCon2.setFocusPainted(false);

        bottomAddCon.add(addConPanel, BorderLayout.CENTER);
        bottomAddCon.add(addCon2, BorderLayout.EAST);

        this.add(top);
        this.add(center);
        this.add(bottomActions);

        Vector<JComponent> bottomPanes = new Vector<>();
        bottomPanes.add(bottomActions);
        bottomPanes.add(bottomInvoice);
        bottomPanes.add(bottomAddCon);

        Vector<JLabel> totalGroup = new Vector<>();
        totalGroup.add(total);
        totalGroup.add(totalCon);
        totalGroup.add(totalPrice);

        ControllerActionSejour controllerActionSejour = new ControllerActionSejour(main, tableInvoice, bottomPanes, totalGroup);
        addCon1.addActionListener(controllerActionSejour);
        invoice1.addActionListener(controllerActionSejour);
        refreshBtn.addActionListener(controllerActionSejour);
        addCon2.addActionListener(controllerActionSejour);
    }

    public void refreshTable() {
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
                    s.getConsommationMinibar().getTotalPrice() + "€",
                    s.isSejourDone(),
                    s
            });
        }
    }

    public void refreshInvoiceProducts(Sejour s) {
        modelProduct.setRowCount(0);

        for (int i = s.getConsommationMinibar().getProductList().size() - 1; i >= 0; i--) {
            Produit p = s.getConsommationMinibar().getProductList().get(i);
            modelProduct.addRow(new Object[]{
                    p.getName(),
                    p.getQuantity(),
                    p.getPrice()*p.getQuantity() + "€",
                    p
            });
        }
    }

    public void refreshSelectProducts() {
        modelProduct.setRowCount(0);

        for (int i = this.main.getHotel().getProducts().size() - 1; i >= 0; i--) {
            Produit p = this.main.getHotel().getProducts().get(i);
            modelProduct.addRow(new Object[]{
                    p.getName(),
                    p
            });
        }
    }

    public void refreshTableSejoursDone() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getSejoursDone().size() - 1; i >= 0; i--) {
            Sejour s = this.main.getHotel().getSejoursDone().get(i);
            model.addRow(new Object[]{
                    s.getReservation().getClient().getNom() + " " + s.getReservation().getClient().getPrenom(),
                    s.getReservation().getRoom().getType(),
                    s.getReservation().getRoom().getFloor(),
                    s.getReservation().getRoom().getPrice(),
                    s.getReservation().getRoom().hasMinibar(),
                    s.getReservation().getStartReservation() + " - " + s.getReservation().getEndReservation(),
                    s.getConsommationMinibar().getTotalPrice() + "€",
                    s.isSejourDone(),
                    s
            });
        }
    }

    public void refreshTableSejoursNotDone() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getSejoursNotDone().size() - 1; i >= 0; i--) {
            Sejour s = this.main.getHotel().getSejoursNotDone().get(i);
            model.addRow(new Object[]{
                    s.getReservation().getClient().getNom() + " " + s.getReservation().getClient().getPrenom(),
                    s.getReservation().getRoom().getType(),
                    s.getReservation().getRoom().getFloor(),
                    s.getReservation().getRoom().getPrice(),
                    s.getReservation().getRoom().hasMinibar(),
                    s.getReservation().getStartReservation() + " - " + s.getReservation().getEndReservation(),
                    s.getConsommationMinibar().getTotalPrice() + "€",
                    s.isSejourDone(),
                    s
            });
        }
    }

    public void refreshButtons() {
        if (bottomInvoice.getParent() == this) {
            this.remove(bottomInvoice);
            this.add(bottomActions);
        }
        if (bottomAddCon.getParent() == this) {
            this.remove(bottomAddCon);
            this.add(bottomActions);
        }
    }
}