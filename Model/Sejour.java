/**
 * 
 */
public class Sejour {

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

    /**
     * Default constructor
     */
    
    public Sejour(Reservation reservation, Hotel hotel) {
        this.reservation = reservation;
        this.hotel = hotel;
        hotel.addSejour(this);
        this.consommationMinibar = new Consommation();
    }

    public Consommation getConsommationMinibar(){
        return this.consommationMinibar;
    }
}