import java.util.*;

/**
 * 
 */
public class Client {

    /**
     * Default constructor
     */
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.listeReservation = new Vector<Reservation>();
    }

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

}