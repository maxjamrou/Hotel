
import java.util.*;

/**
 * 
 */
public class Reservation {

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

    /**
     * Default constructor
     */
    public Reservation(Date debut, Date fin, Hotel hotel, Chambre chambre, Client client) {
        this.debut = debut;
        this.fin = fin;
        this.hotel = hotel;
        hotel.addReservation(this);
        this.chambre = chambre;
        chambre.addReservation(this);
        this.client = client;
        client.addReservation(this);
    }

    public void setSejour(Sejour s){
        this.sejour = s;
    }
}