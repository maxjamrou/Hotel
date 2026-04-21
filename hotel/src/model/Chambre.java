package src.model;

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

    public void setPrice(double p) {prixChambre = p;}

    public void setFloor(int f) {etage = f;}

    public int getFloor(){return this.etage;}

    public int getPrice(){return this.prixChambre;}

    public int getMinibar(){return this.hasMinibar;}

    public int getType(){return this.type;}

    public void addReservation(Reservation r){listeReservation.add(r);}

    public void removeReservation(Reservation r){listeReservation.remove(r);}

    public boolean estDisponible(LocalDate start, LocalDate end){
        for (int i = 0; i < listeReservation.capacity() ; i++){
            if (start.isAfter(listeReservation.get(i).getStartReservation() && start.isBefore(listeReservation.get(i).getEndReservation()))){
                return false;
            }
            if (end.isAfter(listeReservation.get(i).getStartReservation() && end.isBefore(listeReservation.get(i).getEndReservation()))){
                return false;
            }
        }
        return true;
    }
}