package vue;

import controller.ControllerMenu;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.*;
import model.Hotel;

public class VueHotel extends JFrame {
    public JMenuBar menu;
    public JMenu ajouter;
    public JMenu client;
    public JMenu produit;
    public JMenu chambre;
    public JMenu sejour;
    public JMenu reservation;
    public JMenu aide;
    public JMenuItem ajouterClient;
    public JMenuItem rechercherClient;
    public JMenuItem consulterClient;
    public JMenuItem ajouterChambre;
    public JMenuItem rechercherChambre;
    public JMenuItem consulterChambre;
    public JMenuItem ajouterReservation;
    public JMenuItem rechercherReservation;
    public JMenuItem consulterReservation;
    public JMenuItem rechercherSejour;
    public JMenuItem consulterSejour;
    public JMenuItem ajouterProduit;
    public JMenuItem rechercherProduit;
    public JMenuItem consulterProduit;
    //public JMenuItem annulerReservation;
    //public JMenuItem ajouterConsommation;
    //public JMenuItem nouveauSejour;
    //public JMenuItem facturation;
    public JMenuItem UML;


    public JMenu test;
    public JMenu soustest;
    public JMenuItem test1;
    public JMenuItem test2;


    public Vector<JPanel> listeActions = new Vector<>();
    private Hotel hotel;

    public VueHotel(Hotel hotel){
        super("Hotel " + hotel.getNom());
        this.hotel = hotel;
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
        ajouterClient = new JMenuItem("Nouveau client");
        rechercherClient = new JMenuItem("Rechercher client");
        consulterClient = new JMenuItem("Gérer la liste des clients");
        ajouterChambre = new JMenuItem("Nouvelle chambre");
        rechercherChambre = new JMenuItem("Rechercher chambre");
        consulterChambre = new JMenuItem("Gérer la liste des chambres");
        ajouterReservation = new JMenuItem("Nouvelle réservation");
        rechercherReservation = new JMenuItem("Rechercher réservation");
        consulterReservation = new JMenuItem("Gérer la liste des réservations");
        rechercherSejour = new JMenuItem("Rechercher un séjour");
        consulterSejour = new JMenuItem("Gérer la liste des séjours");
        ajouterProduit = new JMenuItem("Nouveau produit");
        rechercherProduit = new JMenuItem("Rechercher produit");
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
        client.add(rechercherClient);
        client.add(consulterClient);
        chambre.add(ajouterChambre);
        chambre.add(rechercherChambre);
        chambre.add(consulterChambre);
        reservation.add(ajouterReservation);
        reservation.add(rechercherReservation);
        //reservation.add(annulerReservation);
        reservation.add(consulterReservation);
        sejour.add(rechercherSejour);
        sejour.add(consulterSejour);
        produit.add(ajouterProduit);
        produit.add(rechercherProduit);
        produit.add(consulterProduit);
        aide.add(UML);
        listeActions.add(new VueAjoutClient(this));
        listeActions.add(new VueRechercherClient(this));
        listeActions.add(new VueGererClient(this));
        listeActions.add(new VueInfoClient(this));
        listeActions.add(new VueAjoutChambre(this));
        listeActions.add(new VueRechercherChambre(this));
        listeActions.add(new VueGererChambre(this));
        listeActions.add(new VueInfoChambre(this));
        listeActions.add(new VueAjoutReservation(this));
        listeActions.add(new VueAjoutReservation2(this));
        listeActions.add(new VueRechercherReservation(this));
        listeActions.add(new VueGererReservation(this));
        listeActions.add(new VueRechercherSejour(this));
        listeActions.add(new VueGererSejour(this));
        listeActions.add(new VueAjoutProduit(this));
        listeActions.add(new VueRechercherProduit(this));
        listeActions.add(new VueGererProduit(this));
        listeActions.add(new VueInfoProduit(this));
        ControllerMenu actionsJMenu = new ControllerMenu(this, listeActions);
        ajouterClient.addActionListener(actionsJMenu);
        rechercherClient.addActionListener(actionsJMenu);
        consulterClient.addActionListener(actionsJMenu);
        ajouterChambre.addActionListener(actionsJMenu);
        rechercherChambre.addActionListener(actionsJMenu);
        consulterChambre.addActionListener(actionsJMenu);
        ajouterReservation.addActionListener(actionsJMenu);
        rechercherReservation.addActionListener(actionsJMenu);
        consulterReservation.addActionListener(actionsJMenu);
        consulterSejour.addActionListener(actionsJMenu);
        rechercherSejour.addActionListener(actionsJMenu);
        ajouterProduit.addActionListener(actionsJMenu);
        rechercherProduit.addActionListener(actionsJMenu);
        consulterProduit.addActionListener(actionsJMenu);
        UML.addActionListener(actionsJMenu);
        setPreferredSize(new Dimension(800, 500));
        pack();
        show();
    }

    public Hotel getHotel(){
        return this.hotel;
    }

    public Vector<JPanel> getListeActions(){
        return this.listeActions;
    }

    public void homeScreen(){
        JLabel welcome = new JLabel("Bienvenu sur l'application de " + this.hotel.getNom());
        JLabel adresse = new JLabel(this.hotel.getAdresse());
    }
}
