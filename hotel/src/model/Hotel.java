package src.model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Hotel {

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String adresse;

    /**
     * 
     */
    private Vector<Client> listeClient;

    /**
     * 
     */
    private Vector<Reservation> listeReservation;

    /**
     * 
     */
    private Vector<Chambre> listeChambre;

    /**
     * 
     */
    private Vector<Sejour> listeSejour;

     /**
     * 
     */
    private Vector<Produit> listeProduit;

    /**
     * Default constructor
     */
    public Hotel(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.listeChambre = new Vector<Chambre>();
        this.listeClient = new Vector<Client>();
        this.listeReservation = new Vector<Reservation>();
        this.listeSejour = new Vector<Sejour>();
        this.listeProduit = new Vector<Produit>();
    }

    public void addChambre(Chambre c){this.listeChambre.add(c);}

    public void addClient(Client c){this.listeClient.add(c);}

    public void addReservation(Reservation r){this.listeReservation.add(r);}

    public void addSejour(Sejour s){this.listeSejour.add(s);}

    public void addProduit(Produit p){this.listeProduit.add(p);}

    public String getName(){return nom;};

    public String getAdresse(){return adresse;};
}