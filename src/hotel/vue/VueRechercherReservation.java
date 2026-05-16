package vue;

import controller.ControllerAnnuler;
import controller.ControllerRecherche;
import model.Reservation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Vector;

public class VueRechercherReservation extends JPanel{
    JTable table;
    DefaultTableModel model;
    VueHotel main;
    ControllerRecherche controllerRecherche;

    public VueRechercherReservation(VueHotel main){
        super(new GridBagLayout());
        this.main = main;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        JPanel top = new JPanel(new BorderLayout(5, 5));

        JPanel bottom = new JPanel(new GridBagLayout());

        JLabel titre = new JLabel("Recherche reservation");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(titre, BorderLayout.NORTH);

        String[] columns = {"Client", "Type de chambre", "num chambre", "Prix/Nuit", "hasMinibar", "Date", "Reservation"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.removeColumn(table.getColumn("Reservation"));
        JScrollPane scrollPane = new JScrollPane(table);

        top.add(scrollPane, BorderLayout.CENTER);

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);

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
        JButton searchBtn = new JButton("Rechercher reservation");
        searchBtn.setFocusPainted(false);
        JButton cancelBtn = new JButton("Annuler");
        searchBtn.setFocusPainted(false);

        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(5, 5, 5, 5);
        b.fill = GridBagConstraints.HORIZONTAL;
        b.anchor = GridBagConstraints.CENTER;

        b.gridy = 0;
        b.weightx = 0;
        b.gridx = 0;
        bottom.add(name, b);
        b.weightx = 1;
        b.gridx = 1;
        bottom.add(nameField, b);
        b.weightx = 0;
        b.gridx = 2;
        bottom.add(type, b);
        b.weightx = 1;
        b.gridx = 3;
        bottom.add(typeField, b);
        b.weightx = 0;
        b.gridx = 4;
        bottom.add(dateStart, b);
        b.weightx = 1;
        b.gridx = 5;
        bottom.add(dateStartField, b);
        b.gridy = 1;
        b.weightx = 0;
        b.gridx = 0;
        bottom.add(surname, b);
        b.weightx = 1;
        b.gridx = 1;
        bottom.add(surnameField, b);
        b.weightx = 0;
        b.gridx = 2;
        bottom.add(floor, b);
        b.weightx = 1;
        b.gridx = 3;
        bottom.add(floorField, b);
        b.weightx = 0;
        b.gridx = 4;
        bottom.add(dateEnd, b);
        b.weightx = 1;
        b.gridx = 5;
        bottom.add(dateEndField, b);
        b.gridy = 2;
        b.weightx = 0;
        b.gridx = 0;
        bottom.add(priceNight, b);
        b.weightx = 1;
        b.gridx = 1;
        bottom.add(priceNightField, b);
        b.weightx = 0;
        b.gridx = 2;
        bottom.add(hasminibar, b);
        b.weightx = 1;
        b.gridx = 3;
        b.fill = GridBagConstraints.NONE;
        bottom.add(radioBtnPanel, b);
        b.fill = GridBagConstraints.HORIZONTAL;
        b.weightx = 0;
        b.gridx = 4;
        b.gridwidth = 2;
        bottom.add(searchBtn, b);

        gbc.gridy = 0;
        this.add(top, gbc);
        gbc.gridy = 1;
        this.add(bottom, gbc);
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.add(cancelBtn, gbc);

        Vector<JComponent> textFields = new Vector<>();
        textFields.add(nameField);
        textFields.add(typeField);
        textFields.add(dateStartField);
        textFields.add(surnameField);
        textFields.add(floorField);
        textFields.add(dateEndField);
        textFields.add(priceNightField);
        textFields.add(hasminibarButton);
        textFields.add(hasnotminibarButton);

        controllerRecherche = new ControllerRecherche(main, table, textFields);
        searchBtn.addActionListener(controllerRecherche);

        ControllerAnnuler controllerAnnuler = new ControllerAnnuler(main);
        searchBtn.addActionListener(controllerRecherche);

    }

    public void refresh() {
        model.setRowCount(0);

        for (int i = this.main.getHotel().getReservations().size() - 1 ; i>=0; i--) {
            Reservation r = this.main.getHotel().getReservations().get(i);
            model.addRow(new Object[]{
                    r.getClient().getNom() + " " + r.getClient().getPrenom(),
                    r.getRoom().getNumeroChambre(),
                    r.getRoom().getNumeroChambre(),
                    r.getRoom().getPrice(),
                    r.getRoom().hasMinibar(),
                    r.getStartReservation() + " - " + r.getEndReservation(),
                    r
            });
        }
    }

    public void refreshSearch(String name, String type, LocalDate startDate, String surname, int floor, LocalDate endDate, double priceNight, Boolean hasMinibar) {
        model.setRowCount(0);

        Vector<Reservation> reservationsFiltered = this.main.getHotel().getReservationsByFields(name, type, startDate, surname, floor, endDate, priceNight, hasMinibar, this.main.getHotel().getReservations());
        for (int i = reservationsFiltered.size() - 1; i >= 0; i--) {
            Reservation r = reservationsFiltered.get(i);
            model.addRow(new Object[]{
                    r.getClient().getNom() + " " + r.getClient().getPrenom(),
                    r.getRoom().getType(),
                    r.getRoom().getFloor(),
                    r.getRoom().getPrice(),
                    r.getRoom().hasMinibar(),
                    r.getStartReservation() + " - " + r.getEndReservation(),
                    r
            });
        }
    }
}
