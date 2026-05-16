package vue;

import controller.ControllerActionSejour;
import controller.ControllerRecherche;
import java.awt.*;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    ControllerRecherche controllerRecherche;

    public VueRechercherSejour(VueHotel main) {
        super(new GridBagLayout());
        this.main = main;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;

        JPanel top = new JPanel(new BorderLayout(5, 5));
        JPanel center = new JPanel(new BorderLayout(5, 5));

        bottomActions = new JPanel(new GridBagLayout());
        GridBagConstraints ba = new GridBagConstraints();
        ba.insets = new Insets(5, 5, 5, 5);
        ba.fill = GridBagConstraints.BOTH;

        bottomInvoice = new JPanel(new GridBagLayout());
        GridBagConstraints bi = new GridBagConstraints();
        bi.insets = new Insets(5, 5, 5, 5);
        bi.fill = GridBagConstraints.BOTH;

        bottomAddCon  = new JPanel(new GridBagLayout());
        GridBagConstraints bac = new GridBagConstraints();
        bac.insets = new Insets(5, 5, 5, 5);
        bac.fill = GridBagConstraints.BOTH;

        JPanel research = new JPanel(new GridBagLayout());
        JPanel invoicePanel = new JPanel(new GridBagLayout());
        JPanel addConPanel  = new JPanel(new GridBagLayout());

        JLabel titre = new JLabel("Recherche séjour");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(titre, BorderLayout.NORTH);

        String[] columns = {"Client", "Type de chambre", "N° de chambre", "Prix/Nuit", "hasMinibar", "Date", "prix conso", "Sejour fini", "Sejour"};
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
        JTextField nameField = new JTextField();
        JLabel surname = new JLabel("Prenom :");
        JTextField surnameField = new JTextField();
        JLabel type = new JLabel("Type :");
        JTextField typeField = new JTextField();
        JLabel floor = new JLabel("Etage :");
        JTextField floorField = new JTextField();
        JLabel priceNight = new JLabel("Prix/Nuit :");
        JTextField priceNightField = new JTextField();
        JLabel hasminibar = new JLabel("A un minibar :");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton hasminibarButton    = new JRadioButton("Oui");
        JRadioButton hasnotminibarButton = new JRadioButton("Non");
        hasminibarButton.setFocusPainted(false);
        hasnotminibarButton.setFocusPainted(false);
        buttonGroup.add(hasminibarButton);
        buttonGroup.add(hasnotminibarButton);
        JPanel radioBtnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));
        radioBtnPanel.add(hasminibarButton);
        radioBtnPanel.add(hasnotminibarButton);
        JLabel dateStart = new JLabel("Date debut :");
        JTextField dateStartField = new JTextField();
        JLabel dateEnd = new JLabel("Date fin :");
        JTextField dateEndField = new JTextField();
        JLabel priceConLabel = new JLabel("Prix conso :");
        JTextField priceConField = new JTextField();
        JButton searchBtn = new JButton("Rechercher");
        searchBtn.setFocusPainted(false);

        GridBagConstraints r = new GridBagConstraints();
        r.insets = new Insets(5, 5, 5, 5);
        r.fill = GridBagConstraints.HORIZONTAL;

        r.gridy = 0;
        r.weightx = 0;
        r.gridx = 0;
        research.add(name, r);
        r.weightx = 1;
        r.gridx = 1;
        research.add(nameField, r);
        r.weightx = 0;
        r.gridx = 2;
        research.add(type, r);
        r.weightx = 1;
        r.gridx = 3;
        research.add(typeField, r);
        r.weightx = 0;
        r.gridx = 4;
        research.add(dateStart, r);
        r.weightx = 1;
        r.gridx = 5;
        research.add(dateStartField, r);
        r.gridy = 1;
        r.weightx = 0;
        r.gridx = 0;
        research.add(surname, r);
        r.weightx = 1;
        r.gridx = 1;
        research.add(surnameField, r);
        r.weightx = 0;
        r.gridx = 2;
        research.add(floor, r);
        r.weightx = 1;
        r.gridx = 3;
        research.add(floorField, r);
        r.weightx = 0;
        r.gridx = 4;
        research.add(dateEnd, r);
        r.weightx = 1;
        r.gridx = 5;
        research.add(dateEndField, r);
        r.gridy = 2;
        r.weightx = 0;
        r.gridx = 0;
        research.add(priceNight, r);
        r.weightx = 1;
        r.gridx = 1;
        research.add(priceNightField, r);
        r.weightx = 0;
        r.gridx = 2;
        research.add(hasminibar, r);
        r.weightx = 1;
        r.gridx = 3;
        r.fill = GridBagConstraints.NONE;
        research.add(radioBtnPanel, r);
        r.fill = GridBagConstraints.HORIZONTAL;
        r.weightx = 0;
        r.gridx = 4;
        research.add(priceConLabel, r);
        r.weightx = 1;
        r.gridx = 5;
        research.add(priceConField, r);

        r.gridy = 1;
        r.gridx = 6;
        r.weightx = 0;
        research.add(searchBtn, r);

        center.add(research, BorderLayout.CENTER);

        JButton invoice1 = new JButton("Facturer un sejour");
        JButton addCon1  = new JButton("Ajouter une consommation");

        ba.gridx = 0;
        ba.gridy = 0;
        ba.fill = GridBagConstraints.NONE;
        ba.anchor = GridBagConstraints.CENTER;
        bottomActions.add(invoice1, ba);
        ba.gridx = 1;
        bottomActions.add(addCon1, ba);

        String[] columnsInvoice = {"Nom des produits", "Quantite", "Prix stack", "Produit"};
        modelInvoice = new DefaultTableModel(columnsInvoice, 0);

        tableInvoice = new JTable(modelInvoice);
        tableInvoice.removeColumn(tableInvoice.getColumn("Produit"));
        JScrollPane scrollPaneInvoice = new JScrollPane(tableInvoice);
        JButton refreshBtn = new JButton("Rafraichir");

        JLabel totalCon   = new JLabel("Total consomme :");
        JLabel totalPrice = new JLabel("Total des nuits :");
        JLabel total      = new JLabel("Total a payer :");
        totalCon.setHorizontalAlignment(SwingConstants.CENTER);
        totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
        total.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel totalCalcPane = new JPanel(new GridLayout(2, 1));
        totalCalcPane.add(totalCon);
        totalCalcPane.add(totalPrice);

        JPanel totalPane = new JPanel(new GridLayout(2, 1));
        totalPane.add(totalCalcPane);
        totalPane.add(total);

        JButton invoiceButton = new JButton("Facturer");
        invoiceButton.setFocusPainted(false);

        GridBagConstraints bip = new GridBagConstraints();
        bip.insets = new Insets(5, 5, 5, 5);
        bip.fill = GridBagConstraints.BOTH;
        bip.anchor = GridBagConstraints.CENTER;
        bip.weighty = 1;

        bip.gridx = 0;
        bip.weightx = 0.7;
        bip.weighty = 1;
        invoicePanel.add(scrollPaneInvoice, bip);
        bip.gridx = 1;
        bip.weightx = 0.1;
        bip.fill = GridBagConstraints.NONE;
        invoicePanel.add(refreshBtn, bip);
        bip.gridx = 2;
        bip.weightx = 0.2;
        bip.fill = GridBagConstraints.BOTH;
        invoicePanel.add(totalPane, bip);

        bi.gridx = 0;
        bi.gridy = 0;
        bi.weightx = 0.8;
        bi.weighty = 1;
        bottomInvoice.add(invoicePanel, bi);
        bi.gridx = 1;
        bi.weightx = 0.2;
        bip.weighty = 0;
        bi.fill = GridBagConstraints.NONE;
        bi.anchor = GridBagConstraints.CENTER;
        bottomInvoice.add(invoiceButton, bi);

        String[] columnsProduct = {"Nom des produits", "Produit"};
        modelProduct = new DefaultTableModel(columnsProduct, 0);

        tableProduct = new JTable(modelProduct);
        tableProduct.removeColumn(tableProduct.getColumn("Produit"));
        JScrollPane scrollPaneProduct = new JScrollPane(tableProduct);

        JLabel quantity = new JLabel("Quantite :");
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField quantityField = new JTextField();
        JButton addCon2 = new JButton("Ajouter conso");
        addCon2.setFocusPainted(false);

        GridBagConstraints acp = new GridBagConstraints();
        acp.insets = new Insets(5, 5, 5, 5);
        acp.fill = GridBagConstraints.BOTH;
        acp.weighty = 1;

        acp.gridx = 0;
        acp.weightx = 0.8;
        acp.gridheight = 2;
        addConPanel.add(scrollPaneProduct, acp);
        acp.gridheight = 1;
        acp.gridx = 1;
        acp.weightx = 0.2;
        acp.weighty = 0.1;
        addConPanel.add(quantity, acp);
        acp.weightx = 0.2;
        acp.weighty = 0.9;
        addConPanel.add(quantityField, acp);

        bac.gridx = 0;
        bac.gridy = 1;
        bac.weightx = 0.8;
        bac.weighty = 1;
        bottomAddCon.add(addConPanel, bac);
        bac.gridx = 1;
        bac.weightx = 0.2;
        bac.weighty = 1;
        bac.fill = GridBagConstraints.NONE;
        bottomAddCon.add(addCon2, bac);

        gbc.gridy = 0;
        gbc.weighty = 0.5;
        this.add(top, gbc);
        gbc.gridy = 1;
        gbc.weighty = 0.2;
        this.add(center, gbc);
        gbc.gridy = 2;
        gbc.weighty = 0.3;
        this.add(bottomActions, gbc);

        Vector<JComponent> bottomPanes = new Vector<>();
        bottomPanes.add(bottomActions);
        bottomPanes.add(bottomInvoice);
        bottomPanes.add(bottomAddCon);

        Vector<JLabel> totalGroup = new Vector<>();
        totalGroup.add(total);
        totalGroup.add(totalCon);
        totalGroup.add(totalPrice);

        Vector<JComponent> textFields = new Vector<>();
        textFields.add(quantityField);
        textFields.add(nameField);
        textFields.add(typeField);
        textFields.add(dateStartField);
        textFields.add(surnameField);
        textFields.add(floorField);
        textFields.add(dateEndField);
        textFields.add(priceNightField);
        textFields.add(priceConField);
        textFields.add(hasminibarButton);
        textFields.add(hasnotminibarButton);

        controllerRecherche = new ControllerRecherche(main, table, textFields);
        searchBtn.addActionListener(controllerRecherche);

        ControllerActionSejour controllerActionSejour = new ControllerActionSejour(main, table, tableProduct, bottomPanes, totalGroup, textFields, controllerRecherche);
        addCon1.addActionListener(controllerActionSejour);
        invoice1.addActionListener(controllerActionSejour);
        refreshBtn.addActionListener(controllerActionSejour);
        invoiceButton.addActionListener(controllerActionSejour);
        addCon2.addActionListener(controllerActionSejour);
    }

    public void refreshTable() {
        model.setRowCount(0);
        for (int i = this.main.getHotel().getSejours().size() - 1; i >= 0; i--) {
            Sejour s = this.main.getHotel().getSejours().get(i);
            model.addRow(new Object[]{
                    s.getReservation().getClient().getNom() + " " + s.getReservation().getClient().getPrenom(),
                    s.getReservation().getRoom().getType(),
                    s.getReservation().getRoom().getNumeroChambre(),
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
        modelInvoice.setRowCount(0);
        for (int i = s.getConsommationMinibar().getProductList().size() - 1; i >= 0; i--) {
            Produit p = s.getConsommationMinibar().getProductList().get(i);
            modelInvoice.addRow(new Object[]{
                    p.getName(),
                    p.getQuantity(),
                    p.getPrice() * p.getQuantity() + "€",
                    p
            });
        }
    }

    public void refreshInvoiceProducts() { modelInvoice.setRowCount(0); }

    public void refreshSelectProducts() {
        modelProduct.setRowCount(0);
        for (int i = this.main.getHotel().getProducts().size() - 1; i >= 0; i--) {
            Produit p = this.main.getHotel().getProducts().get(i);
            modelProduct.addRow(new Object[]{p.getName(), p});
        }
    }

    public void refreshTableSejoursDone() {
        model.setRowCount(0);
        for (int i = this.main.getHotel().getSejoursDone().size() - 1; i >= 0; i--) {
            Sejour s = this.main.getHotel().getSejoursDone().get(i);
            model.addRow(new Object[]{
                    s.getReservation().getClient().getNom() + " " + s.getReservation().getClient().getPrenom(),
                    s.getReservation().getRoom().getType(),
                    s.getReservation().getRoom().getNumeroChambre(),
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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 5, 5, 5);

        if (bottomInvoice.getParent() == this) {
            this.remove(bottomInvoice);
            this.add(bottomActions, gbc);
        }
        if (bottomAddCon.getParent() == this) {
            this.remove(bottomAddCon);
            this.add(bottomActions, gbc);
        }
    }

    public void refreshSearch(String name, String type, LocalDate startDate, String surname, int floor, LocalDate endDate, double priceNight, Boolean hasMinibar, double priceCon, String tableType) {
        model.setRowCount(0);
        Vector<Sejour> source = tableType.equals("Done") ? this.main.getHotel().getSejoursDone()
                : tableType.equals("NotDone") ? this.main.getHotel().getSejoursNotDone()
                  : this.main.getHotel().getSejours();
        Vector<Sejour> results = this.main.getHotel().getSejoursByFields(name, type, startDate, surname, floor, endDate, priceNight, hasMinibar, priceCon, source);
        for (int i = results.size() - 1; i >= 0; i--) {
            Sejour s = results.get(i);
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

    public void resetMode() { controllerRecherche.setMode("All"); }
}