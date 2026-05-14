package model;

import java.util.*;

/**
 * 
 */
public class Client {

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

    /**
     * Default constructor
     */
    public Client(String nom, String prenom, Hotel hotel) {
        this.nom = nom.toUpperCase();
        this.prenom = prenom;
        this.listeReservation = new Vector<Reservation>(0);
        this.hotel = hotel;
    }

    public void setNom(String nom){this.nom = nom;}

    public String getNom(){return this.nom;}

    public void setPrenom(String prenom){this.prenom = prenom;}

    public String getPrenom(){return this.prenom;}

    public void addReservation(Reservation r){this.listeReservation.add(r);}

    public boolean aDejaReserve(Reservation r){
        for(int i = 0; i < this.listeReservation.size(); i++){
            if (r.getStartReservation().isAfter(listeReservation.get(i).getStartReservation()) && r.getStartReservation().isBefore(listeReservation.get(i).getEndReservation())){
                return true;
            } else if (r.getEndReservation().isAfter(listeReservation.get(i).getStartReservation()) && r.getEndReservation().isBefore(listeReservation.get(i).getEndReservation())){
                return true;
            }
        }
        return false;
    }

    public Vector<Reservation> getReservations(){return this.listeReservation;}
}