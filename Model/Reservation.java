
import java.util.*;

/**
 * 
 */
public class Reservation {

    /**
     * Default constructor
     */
    public Reservation(Date debut, Date fin, Hotel hotel, Chambre chambre, Client client) {
        this.debut = debut;
        this.fin = fin;
        this.hotel = hotel;
        this.chambre = chambre;
        this.client = client;
    }

    /**
     * 
     */
    private Date debut;

    /**
     * 
     */
    private Date fin;

    /**
     * 
     */
    private Hotel hotel;

    /**
     * 
     */
    private Client client;

    /**
     * 
     */
    private Sejour sejour;

    /**
     * 
     */
    private Chambre chambre;

}