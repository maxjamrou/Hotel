
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Hotel {

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
    }

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

}