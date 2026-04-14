

/**
 * 
 */
public class Sejour {

    /**
     * Default constructor
     */
    public Sejour(Reservation reservation, Hotel hotel, Consommation consommationMinibar) {
        this.reservation = reservation;
        this.hotel = hotel;
        this.consommationMinibar = consommationMinibar;
    }

    /**
     * 
     */
    private Reservation reservation;

    /**
     * 
     */
    private Hotel hotel;

    /**
     * 
     */
    private Consommation consommationMinibar;

}