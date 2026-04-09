import java.util.*;

/**
 * 
 */
public class Chambre {

    /**
     * Default constructor
     */
    public Chambre(int etage, double prixChambre, boolean hasMinibar, TypeChambre type, Hotel hotel) {
        this.etage = etage;
        this.prixChambre = prixChambre;
        this.hasMinibar = hasMinibar;
        this.type = type;
        this.listeReservation = new Vector<Reservation>();
        this.hotel = hotel;
    }

    /**
     * 
     */
    private int etage;

    /**
     * 
     */
    private double prixChambre;

    /**
     * 
     */
    private boolean hasMinibar;

    /**
     * 
     */
    private Hotel hotel;

    /**
     * 
     */
    private TypeChambre type;

    /**
     * 
     */
    private Vector<Reservation> listeReservation;

}