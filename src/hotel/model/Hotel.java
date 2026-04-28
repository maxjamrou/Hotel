package model;

import java.io.*;
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
            if(this.listeClient.get(idx).getNom().equals(nom)){rClients.add(this.listeClient.get(idx));}
        }
        return rClients;
    }

    public Vector<Client> getClientByPrenom(String prenom, Vector<Client> rClients){
        if(rClients == null){rClients = new Vector<Client>();}
        for (int idx = 0; idx < this.listeClient.size(); idx++) {
            if(this.listeClient.get(idx).getNom().toLowerCase().equals(prenom.toLowerCase())){rClients.add(this.listeClient.get(idx));}
        }
        return rClients;
    }

    public Vector<Client> getClientByNomAndPrenom(String nom, String prenom){
        if(nom.equals("")){return this.getClientByPrenom(prenom, null);}
        else if(prenom.equals("")){return this.getClientByNom(nom);}
        return this.getClientByPrenom(prenom, this.getClientByNom(nom));
    }
}