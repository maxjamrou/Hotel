package model;

import java.util.*;

/**
 * 
 */
public class Consommation {

    /**
     * 
     */
    private Vector<Product> listeProduct;

    /**
     * Default constructor
     */
    public Consommation() {
        this.listeProduct = new Vector<Product>();
    }

    public void addProduit(Product p){this.listeProduct.add(p);}

}