
import java.util.*;

/**
 * 
 */
public class Reservation {

    /**
     * Default constructor
     */
    public Reservation(Date debut, Date fin) {
        this.debut = debut;
        this.fin = fin;
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