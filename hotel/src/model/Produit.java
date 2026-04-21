package src.model;

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

    public void setName(double p) {prix = p;};

    public String getName(double p) {return name;};

    public int getQuantity(double p) {return quantite;};

    public double getPrice(double p) {return prix;};

    public void changeQuantity(int q) {quantite += p;};
}