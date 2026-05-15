package model;

import java.io.*;
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
    
    public Vector<Chambre> listChambresDisponibles(LocalDate start, LocalDate end){
        Vector<Chambre> rChambres = new Vector<>();
        for (Chambre c : this.listeChambre) {
            if(c.estDisponible(start, end)){
                rChambres.add(c);          
            }
        }
        return rChambres;
    }

    public boolean estDansCatalogueProduit(String nomProduit){
        for(Produit p : this.listeProduit){
            System.out.println(p.getName() + " " + nomProduit);
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
}