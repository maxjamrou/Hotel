package model;

/**
 * 
 */
public class Produit {

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private int quantite;

    /**
     * 
     */
    private double prix;

    /**
     * 
     */
    private Hotel hotel;

    /**
     * Default constructor
     */
    public Produit(String name, int quantite, double prix, Hotel hotel) {
        this.hotel = hotel;
        this.name = name;
        this.quantite = quantite;
        this.prix = prix;
    }
}