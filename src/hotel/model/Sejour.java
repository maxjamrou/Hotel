package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
        this.consommationMinibar = new Consommation();
    }

    public Consommation getConsommationMinibar(){
        return this.consommationMinibar;
    }
    
    public Reservation getReservation(){
        return this.reservation;
    }

    public boolean isSejourDone() {
        if (LocalDate.now().isAfter(this.reservation.getEndReservation())) {
            return true;
        }
        return false;
    }

    public double getPrixReservation(LocalDate startDate, LocalDate endDate) {
        long nDays = startDate.until(endDate, ChronoUnit.DAYS);
        double RoomPrice = getReservation().getRoom().getPrice();
        return nDays*RoomPrice;
    }

    public void deleteSejour(Sejour s) {
        hotel.getSejours().remove(s);
        hotel.getSejoursDone().remove(s);
        hotel.getSejoursNotDone().remove(s);
    }
}