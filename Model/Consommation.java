import java.io.*;
import java.util.*;

/**
 * 
 */
public class Consommation {

    /**
     * Default constructor
     */
    public Consommation() {
        this.listeProduit = new Vector<Produit>();
    }

    public void addProduit(Produit produit){
        listeProduit.add(produit);
    }

    /**
     * 
     */
    private Vector<Produit> listeProduit;


}