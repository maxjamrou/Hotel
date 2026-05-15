package model;

import java.util.*;

/**
 * 
 */
public class Consommation {

    /**
     * 
     */
    private Vector<Produit> listeProduit;

    /**
     * Default constructor
     */
    public Consommation() {
        this.listeProduit = new Vector<Produit>();
    }

    public void addProduit(Produit p){this.listeProduit.add(p);}

    public Vector<Produit> getProductList(){return this.listeProduit;}

    public double getTotalPrice() {
        double total = 0;
        for (Produit p : this.listeProduit) {
            total += p.getPrice()*p.getQuantity();
        }
        return total;
    }
}