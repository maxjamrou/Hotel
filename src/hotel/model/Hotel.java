package hotel.model;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import hotel.model.Chambre;

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

    public String getNom(){return this.nom;}

    public String getAdresse(){return adresse;};

    public Vector<Chambre> getRooms(){return listeChambre;};

    public Vector<Client> getClients(){return listeClient;};

    public Vector<Reservation> getReservations(){return listeReservation;};

    public Vector<Sejour> getSejour(){return listeSejour;};

    public Vector<Chambre> getAllAvailableRooms(LocalDate start, LocalDate end){
        Vector<Chambre> lChambres = new Vector<Chambre>();
        for (int i = 0; i < listeChambre.capacity(); i++) {
            if (listeChambre.get(i).estDisponible(start, end)) {
                lChambres.add(listeChambre.get(i));
            }
        }
        return lChambres;
    }
}