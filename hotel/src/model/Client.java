package src.model;

import java.util.*;

/**
 * 
 */
public class Client {

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    private Hotel hotel;

    /**
     * 
     */
    private Vector<Reservation> listeReservation;

    /**
     * Default constructor
     */
    public Client(String nom, String prenom, Hotel hotel) {
        this.nom = nom;
        this.prenom = prenom;
        this.listeReservation = new Vector<Reservation>();
        this.hotel = hotel;
        this.hotel.addClient(this);
    }

    public void addReservation(Reservation r){this.listeReservation.add(r);}
}