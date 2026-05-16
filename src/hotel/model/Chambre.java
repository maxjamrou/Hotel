package model;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Chambre {

    /**
     * 
     */
    private Floor etage;

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
    private String type;

    /**
     * 
     */
    private Vector<Reservation> listeReservation;

    private int roomId;

    private static Vector<Floor> lFloors = new Vector<>();

    /**
     * Default constructor
     */
    public Chambre(int etage, double prixChambre, boolean hasMinibar, String type, Hotel hotel) {
        boolean exist = false;
        for(Floor f : this.lFloors){
            if(f.getFloor() == etage){
                exist = true;
                this.etage = f;
                break;
            }
        }
        if(!exist){
            this.etage = new Floor(etage);
            lFloors.add(this.etage);
        }
        this.roomId = this.etage.incrIdRoom();
        this.prixChambre = prixChambre;
        this.hasMinibar = hasMinibar;
        this.type = type;
        this.hotel = hotel;
        this.listeReservation = new Vector<Reservation>();
    }

    public void addReservation(Reservation r){listeReservation.add(r);}

    public Vector<Reservation> getListReservations(){return this.listeReservation;}

    public void setPrice(double p) {prixChambre = p;}

    public void setHasMinibar(boolean hasMinibar){this.hasMinibar = hasMinibar;}

    public void setTypeChambre(String typeChambre){this.type = typeChambre;}

    public int getFloor(){return this.etage.getFloor();}

    public String getNumeroChambre(){
        String strIdRoom = this.roomId + "";
        if(this.roomId<10){strIdRoom = "0" + strIdRoom;}
        return this.etage.getFloor() + "-" + strIdRoom;
    }

    public double getPrice(){return this.prixChambre;}

    public boolean hasMinibar(){return this.hasMinibar;}

    public String getType(){return this.type;}

    public void removeReservation(Reservation r){listeReservation.remove(r);}

    public boolean estDisponible(LocalDate start, LocalDate end){
        for (int i = 0; i < listeReservation.size() ; i++){
            if (!start.isBefore(listeReservation.get(i).getStartReservation()) && !start.isAfter(listeReservation.get(i).getEndReservation())){
                return false;
            } else if (!end.isBefore(listeReservation.get(i).getStartReservation()) && !end.isAfter(listeReservation.get(i).getEndReservation())){
                return false;
            }
        }
        return true;
    }
}