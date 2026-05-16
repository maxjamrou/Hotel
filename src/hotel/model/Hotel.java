package model;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Hotel {

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String adresse;

    /**
     * 
     */
    private Vector<Client> listeClient;

    /**
     * 
     */
    private Vector<Reservation> listeReservation;

    /**
     * 
     */
    private Vector<Chambre> listeChambre;

    /**
     * 
     */
    private Vector<Sejour> listeSejour;

     /**
     * 
     */
    private Vector<Produit> listeProduit;

    /**
     * Default constructor
     */
    public Hotel(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.listeChambre = new Vector<>();
        this.listeClient = new Vector<>();
        this.listeReservation = new Vector<>();
        this.listeSejour = new Vector<>();
        this.listeProduit = new Vector<>();
    }

    public void addChambre(Chambre c){this.listeChambre.add(c);}

    public void addClient(Client c){this.listeClient.add(c);}

    public void addReservation(Reservation r){this.listeReservation.add(r);}

    public void addSejour(Sejour s){this.listeSejour.add(s);}

    public void addProduit(Produit p){this.listeProduit.add(p);}

    public String getNom(){return this.nom;}

    public String getAdresse(){return adresse;};

    public Vector<Client> getClientByNom(String nom){
        Vector<Client> rClients = new Vector<Client>();
        for (int idx = 0; idx < this.listeClient.size(); idx++) {
            if(this.listeClient.get(idx).getNom().toLowerCase().equals(nom.toLowerCase())){rClients.add(this.listeClient.get(idx));}
        }
        return rClients;
    }

    public Vector<Client> getClientByPrenom(String prenom, Vector<Client> rClientsByNames){
        Vector <Client> rClients = new Vector<>();
        if(rClientsByNames == null){
            for (int idx = 0; idx < this.listeClient.size(); idx++) {
                if(this.listeClient.get(idx).getPrenom().toLowerCase().equals(prenom.toLowerCase())){rClients.add(this.listeClient.get(idx));}
            }
        } else {
            for (int idx = 0; idx < rClientsByNames.size(); idx++) {
                if(rClientsByNames.get(idx).getPrenom().toLowerCase().equals(prenom.toLowerCase())){rClients.add(rClientsByNames.get(idx));}
            }
        }
        return rClients;
    }

    public Vector<Client> getClientByNomAndPrenom(String nom, String prenom){
        if(nom.equals("")){return this.getClientByPrenom(prenom, null);}
        else if(prenom.equals("")){return this.getClientByNom(nom);}
        return this.getClientByPrenom(prenom, this.getClientByNom(nom));
    }

    public Vector<Chambre> getChambreByPrice(boolean sup, double prix){
        Vector<Chambre> rChambres = new Vector<>();
        for (Chambre c : this.listeChambre) {
            if(sup && c.getPrice() >= prix){
                rChambres.add(c);
            } else if (!sup && c.getPrice() <= prix){
                rChambres.add(c);
            }
        }
        return rChambres;
    }

    public Vector<Chambre> getChambreByMinibar(boolean hasMinibar, Vector<Chambre> lChambres){
        Vector<Chambre> rChambres = new Vector<>();
        if(lChambres == null){
            for (int idx = 0; idx < this.listeChambre.size(); idx++) {
                if((this.listeChambre.get(idx).hasMinibar() == hasMinibar)){rChambres.add(this.listeChambre.get(idx));}
            }
        } else {
            for (int idx = 0; idx < lChambres.size(); idx++) {
                if(lChambres.get(idx).hasMinibar() == hasMinibar){rChambres.add(lChambres.get(idx));}
            }
        }
        return rChambres;
    }


    public Vector<Chambre> getChambreByType(String type, Vector<Chambre> lChambres){
        Vector<Chambre> rChambres = new Vector<>();
        if(lChambres == null){
            for (int idx = 0; idx < this.listeChambre.size(); idx++) {
                if((this.listeChambre.get(idx).getType().equals(type))){rChambres.add(this.listeChambre.get(idx));}
            }
        } else {
            for (int idx = 0; idx < lChambres.size(); idx++) {
                if(lChambres.get(idx).getType().equals(type)){rChambres.add(lChambres.get(idx));}
            }
        }
        return rChambres;
    }

    public Vector<Chambre> getChambreByFloor(int floor, Vector<Chambre> lChambres){
        Vector<Chambre> rChambres = new Vector<>();
        if(lChambres == null){
            for (int idx = 0; idx < this.listeChambre.size(); idx++) {
                if((this.listeChambre.get(idx).getFloor() == floor)){rChambres.add(this.listeChambre.get(idx));}
            }
        } else {
            for (int idx = 0; idx < lChambres.size(); idx++) {
                if(lChambres.get(idx).getFloor() == floor){rChambres.add(lChambres.get(idx));}
            }
        }
        return rChambres;
    }

    public Vector<Chambre> getChambreByCondition(boolean sup, double prix, int minibar, String type, int floor){
        Vector<Chambre> rChambres = null;
        if(prix >= 0){rChambres = getChambreByPrice(sup, prix);}
        if(minibar != -1){
            if(minibar == 1){rChambres = getChambreByMinibar(true, rChambres);}
            else{rChambres = getChambreByMinibar(false, rChambres);}
        }
        if(!type.equals("")){rChambres = getChambreByType(type, rChambres);}
        if(floor>=0){rChambres = getChambreByFloor(floor, rChambres);}
        return rChambres;
    }

    public Vector<Produit> getProduitByName(String name){
        Vector<Produit> rProduits = new Vector<>();
        for (Produit p : this.listeProduit) {
            if(p.getName().replace(" ", "").equals(name.toUpperCase().replace(" ", ""))){rProduits.add(p);}
        }
        return rProduits;
    }

    public Vector<Produit> getProduitByPrice(double price, boolean sup, Vector<Produit> lProduits){
        Vector<Produit> rProduits = new Vector<>();
        if(lProduits == null){
            for (Produit p : this.listeProduit) {
                if(sup && p.getPrice() >= price){rProduits.add(p);}
                else if(!sup && p.getPrice() <= price){rProduits.add(p);}
            }
        } else {
            for (Produit p : lProduits){
                if(sup && p.getPrice() >= price){rProduits.add(p);}
                else if(!sup && p.getPrice() <= price){rProduits.add(p);}
            }
        }
        return rProduits;
    }

    public Vector<Produit> getProduitByCondition(String name, double price, boolean sup){
        Vector<Produit> rProduits = null;
        if(!name.equals("")){rProduits = this.getProduitByName(name);}
        if(price>=0){rProduits = this.getProduitByPrice(price, sup, rProduits);}
        return rProduits;
    }

    public String afficheAllClient(){
        String result = "";
        for (Client elem : this.listeClient) {
            result += "Nom : " +  elem.getNom() + " prénom :" + elem.getPrenom() + "\n";
        }
        return result;
    }

    public String afficheAllProduit(){
        String result = "";
        for (Produit elem : this.listeProduit) {
            result += "Nom : " +  elem.getName() + " prix : " + elem.getPrice() + " quantité : " + elem.getQuantity() +"\n";
        }
        return result;
    }
    
    public Vector<Chambre> listChambresDisponibles(LocalDate start, LocalDate end, Vector<Chambre> lChambres){
        Vector<Chambre> rChambres = new Vector<>();
        for (Chambre c : lChambres) {
            if(c.estDisponible(start, end)){
                rChambres.add(c);          
            }
        }
        return rChambres;
    }

    public boolean estDansCatalogueProduit(String nomProduit){
        for(Produit p : this.listeProduit){
            if (p.getName().replace(" ", "").equals(nomProduit.toUpperCase().replace(" ", ""))){
                return true;
            }
        }
        return false;
    }

    public Vector<Produit> getProducts() {
        return listeProduit;
    }

    public Vector<Client> getClients(){
        return this.listeClient;
    }

    public Vector<Chambre> getChambres(){
        return this.listeChambre;
    }

    public Vector<Reservation> getReservations(){
        return this.listeReservation;
    }

    public Vector<Sejour> getSejours(){
        return this.listeSejour;
    }

    public Vector<Sejour> getSejoursDone(){
        Vector<Sejour> Sejours = new Vector<>();
        for (Sejour elem : this.listeSejour) {
            if (elem.isSejourDone()){
                Sejours.add(elem);
            }
        }
        return Sejours;
    }

    public Vector<Sejour> getSejoursNotDone(){
        Vector<Sejour> Sejours = new Vector<>();
        for (Sejour elem : this.listeSejour) {
            if (!elem.isSejourDone()){
                Sejours.add(elem);
            }
        }
        return Sejours;
    }

    public Vector<Sejour> getSejoursByFields(String name, String type, LocalDate startDate, String surname, int floor, LocalDate endDate, double priceNight, Boolean hasMinibar, double priceCon, Vector<Sejour> sejours) {
        Vector<Sejour> filtered = new Vector<>();
        for (Sejour s : sejours) {
            if (!((!name.isEmpty() && !s.getReservation().getClient().getNom().equals(name)) || (!surname.isEmpty() && !s.getReservation().getClient().getPrenom().equals(surname)) || (!type.isEmpty() && !s.getReservation().getRoom().getType().equals(type)) || (floor != 0 && s.getReservation().getRoom().getFloor() != floor) || (startDate != null && !s.getReservation().getStartReservation().equals(startDate)) || (endDate != null && !s.getReservation().getEndReservation().equals(endDate)) || (priceNight != 0 && s.getReservation().getRoom().getPrice() != priceNight) || (priceCon != 0 && s.getConsommationMinibar().getTotalPrice() != priceCon) || (hasMinibar != null && s.getReservation().getRoom().hasMinibar() != hasMinibar))) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public void ResToSej() {
        Vector<Reservation> toSejours = new Vector<>();
        for (Reservation r : listeReservation) {
            if (LocalDate.now().isAfter(r.getEndReservation())) {
                addSejour(new Sejour(r, this));
                toSejours.add(r);
            }
        }
        listeReservation.removeAll(toSejours);
    }

    public Vector<Reservation> getReservationsByFields(String name, String type, LocalDate startDate, String surname, int floor, LocalDate endDate, double priceNight, Boolean hasMinibar, Vector<Reservation> reservations) {
        Vector<Reservation> filtered = new Vector<>();
        for (Reservation r : reservations) {
            if (!((!name.isEmpty() && !r.getClient().getNom().equals(name)) || (!surname.isEmpty() && !r.getClient().getPrenom().equals(surname)) || (!type.isEmpty() && !r.getRoom().getType().equals(type)) || (floor != 0 && r.getRoom().getFloor() != floor) || (startDate != null && r.getStartReservation().equals(startDate)) || (endDate != null && !r.getEndReservation().equals(endDate)) || (priceNight != 0 && r.getRoom().getPrice() != priceNight) || (hasMinibar != null && r.getRoom().hasMinibar() != hasMinibar))) {
                filtered.add(r);
            }
        }
        return filtered;
    }
}