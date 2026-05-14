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
        this.name = name;
        this.quantite = quantite;
        this.prix = prix;
        this.hotel = hotel;
    }

    
    public String getName() {return name;}
    
    public void setPrice(double p) {prix = p;}
    
    public double getPrice() {return prix;}

    public int getQuantity() {return quantite;}

    public void changeQuantity(int q) {quantite += q;}
}