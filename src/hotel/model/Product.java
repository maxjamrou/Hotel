package model;

/**
 * 
 */
public class Product {

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private int quantity;

    /**
     * 
     */
    private double price;

    /**
     * Default constructor
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    
    public String getName() {return name;}

    public double getPrice() {return price;}

    public int getQuantity() {return quantity;}
    
    public void setPrice(double price) {this.price = price;}

    public void changeQuantity(int quantity) {this.quantity += quantity;}

    @Override
    public String toString() {return name + " (" + price + "€ | stock: " + quantity + ")";}
}