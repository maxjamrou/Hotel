import java.io.*;
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

}