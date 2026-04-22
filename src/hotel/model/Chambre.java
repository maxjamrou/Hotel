package model;

import java.util.*;

/**
 * 
 */
public class Chambre {

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

    /**
     * Default constructor
     */
    public Chambre(int etage, double prixChambre, boolean hasMinibar, TypeChambre type, Hotel hotel) {
        this.etage = etage;
        this.prixChambre = prixChambre;
        this.hasMinibar = hasMinibar;
        this.type = type;
        this.hotel = hotel;
        hotel.addChambre(this);
        this.listeReservation = new Vector<Reservation>();
    }

    public void addReservation(Reservation r){listeReservation.add(r);}

    public int getEtage(){return this.etage;}

    // public boolean estDisponible(){

    // }
}