package vue;

import controller.ControllerMenu;
import model.Hotel;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.*;

public class VueHotel extends JFrame {
    public JMenuBar menu;
    public JMenu ajouter;
    public JMenu client;
    public JMenu produit;
    public JMenu chambre;
    public JMenu sejour;
    public JMenu reservation;
    public JMenu aide;
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
    public JMenuItem UML;


    public JMenu test;
    public JMenu soustest;
    public JMenuItem test1;
    public JMenuItem test2;


    public Vector<JPanel> listeActions = new Vector<JPanel>();
    public Hotel hotel;

    public VueHotel(Hotel hotel){
        this.hotel = hotel;
        super("Hotel " + hotel.getNom());
        menu = new JMenuBar();
        setJMenuBar(menu);
        // ajouter = new JMenu("Ajouter");
        // menu.add(ajouter);
        // consulter = new JMenu("Consulter");
        // menu.add(consulter);
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
        aide = new JMenu("Aide");
        menu.add(aide);
        consulterClient = new JMenuItem("Gérer la liste des clients");
        ajouterClient = new JMenuItem("Nouveau client");
        ajouterProduit = new JMenuItem("Nouveau produit");
        ajouterChambre = new JMenuItem("Nouvelle chambre");
        consulterChambre = new JMenuItem("Gérer la liste des chambres");
        ajouterReservation = new JMenuItem("Nouvelle réservation");
        consulterReservation = new JMenuItem("Gérer la liste des réservations");
        consulterSejour = new JMenuItem("Gérer la liste des séjours");
        consulterProduit = new JMenuItem("Gérer la liste des produits");
        //annulerReservation = new JMenuItem("Annuler réservation");
        UML = new JMenuItem("Ouvrir l'UML");


        test = new JMenu("Test");
        menu.add(test);
        soustest = new JMenu("Soustest");
        test.add(soustest);
        test1 = new JMenuItem("test1");
        soustest.add(test1);
        test2 = new JMenuItem("test2");
        soustest.add(test2);

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
        aide.add(UML);
        listeActions.add(new VueAjoutClient());
        listeActions.add(new VueGererClient());
        listeActions.add(new VueAjoutChambre());
        listeActions.add(new VueGererChambre());
        listeActions.add(new VueAjoutReservation());
        listeActions.add(new VueGererReservation());
        listeActions.add(new VueGererSejour());
        listeActions.add(new VueAjoutProduit());
        listeActions.add(new VueGererProduit());
        ControllerMenu actionsJMenu = new ControllerMenu(this, listeActions);
        ajouterClient.addActionListener(actionsJMenu);
        consulterClient.addActionListener(actionsJMenu);
        ajouterChambre.addActionListener(actionsJMenu);
        consulterChambre.addActionListener(actionsJMenu);
        ajouterReservation.addActionListener(actionsJMenu);
        consulterReservation.addActionListener(actionsJMenu);
        consulterSejour.addActionListener(actionsJMenu);
        ajouterProduit.addActionListener(actionsJMenu);
        consulterProduit.addActionListener(actionsJMenu);
        UML.addActionListener(actionsJMenu);
        setPreferredSize(new Dimension(800, 500));
        pack();
        show();
    }
}
