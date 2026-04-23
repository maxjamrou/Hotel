package vue;

import controller.Controller1;
import java.awt.Dimension;
import javax.swing.*;
import model.*;

public class VueHotel extends JFrame {
    public JMenuBar menu;
    public JMenu client;
    public JMenu produit;
    public JMenu chambre;
    public JMenu sejour;
    public JMenu reservation;
    public JMenuItem consulterClient;
    public JMenuItem ajouterClient;
    public JMenuItem ajouterProduit;
    public JMenuItem consulterProduit;
    public JMenuItem ajouterChambre;
    public JMenuItem consulterChambre;
    public JMenuItem ajouterReservation;
    public JMenuItem consulterReservation;
    //public JMenuItem annulerReservation;
    public JMenuItem consulterSejour;
    //public JMenuItem ajouterConsommation;
    //public JMenuItem nouveauSejour;
    //public JMenuItem facturation;

    public VueChambre vueChambre;

    public Hotel hotel;

    public VueHotel(Hotel hotel){
        this.hotel = hotel;
        super("Hotel " + hotel.getNom());
        menu = new JMenuBar();
        setJMenuBar(menu);
        client = new JMenu("Client");
        menu.add(client);
        chambre = new JMenu("Chambre");
        menu.add(chambre);
        reservation = new JMenu("Reservation");
        menu.add(reservation);
        sejour = new JMenu("Sejour");
        menu.add(sejour);
        produit = new JMenu("Produit");
        menu.add(produit);
        consulterClient = new JMenuItem("Gérer la liste des clients");
        ajouterClient = new JMenuItem("Nouveau client");
        ajouterProduit = new JMenuItem("Nouveau produit");
        consulterProduit = new JMenuItem("Gérer la liste des produits");
        ajouterChambre = new JMenuItem("Nouvelle chambre");
        consulterChambre = new JMenuItem("Gérer la liste des chambres");
        ajouterReservation = new JMenuItem("Nouvelle réservation");
        consulterReservation = new JMenuItem("Gérer la liste des réservations");
        consulterSejour = new JMenuItem("Gérer la liste des séjours");
        //annulerReservation = new JMenuItem("Annuler réservation");
        client.add(ajouterClient);
        client.add(consulterClient);
        chambre.add(ajouterChambre);
        chambre.add(consulterChambre);
        reservation.add(ajouterReservation);
        reservation.add(consulterReservation);
        //reservation.add(annulerReservation);
        sejour.add(consulterSejour);
        produit.add(ajouterProduit);
        produit.add(consulterProduit);
        vueChambre = new VueChambre();
        this.getContentPane().add(vueChambre);
        Controller1 afficheChambre = new Controller1(vueChambre);
        ajouterChambre.addActionListener(afficheChambre);
        setPreferredSize(new Dimension(800, 500));
        pack();
        show();
    }
}
