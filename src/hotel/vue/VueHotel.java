package vue;

import controller.ControllerMenu;
import java.awt.Dimension;
import java.util.Vector;

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
    public VueAjoutChambre vueAjoutChambre;
    public VueAjoutClient vueAjoutClient;

    public Vector<JPanel> listeActions = new Vector<JPanel>();
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
        listeActions.add(new VueAjoutChambre());
        listeActions.add(new VueAjoutClient());
        ControllerMenu actionsJMenu = new ControllerMenu(this, listeActions);
        ajouterChambre.addActionListener(actionsJMenu);
        ajouterClient.addActionListener(actionsJMenu);
        setPreferredSize(new Dimension(800, 500));
        pack();
        show();
    }
}
