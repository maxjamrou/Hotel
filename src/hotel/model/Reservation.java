package model;

import java.time.LocalDate;

/**
 * 
 */
public class Reservation {

    /**
     * 
     */
    private LocalDate debut;

    /**
     * 
     */
    private LocalDate fin;

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
    public Reservation(String debut, String fin, Hotel hotel, Chambre chambre, Client client) {
        this.debut = LocalDate.parse(debut);
        this.fin = LocalDate.parse(fin);
        this.hotel = hotel;
        hotel.addReservation(this);
        this.chambre = chambre;
        chambre.addReservation(this);
        this.client = client;
        client.addReservation(this);
    }

    /**
     * peut-être à changer...
     */

    // public void setSejour(Sejour s){
    //     this.sejour = s;
    // }

    /**
     * Nouvelle version
     */
    public void confirmationSejour(){
        this.sejour = new Sejour(this, this.hotel);
    }

    public LocalDate getStartReservation(){return debut;}

    public LocalDate getEndReservation(){return fin;}

    public Chambre getRoom(){return chambre;}

    public Client getClient(){return client;}
}