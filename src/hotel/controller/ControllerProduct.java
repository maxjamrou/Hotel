package controller;

import model.Product;
import model.Hotel;
import vue.ViewAddProduct;

public class ControllerProduct {
    private Hotel hotel;
    private ViewAddProduct view;

    public ControllerProduct(Hotel hotel, ViewAddProduct view) {
        this.hotel = hotel;
        this.view = view;

        view.getBtnAjouter().addActionListener(e -> ajouterProduit());
    }

    private void ajouterProduit() {
        try {
            String name = view.getName();
            double price = view.getPrice();
            int quantity = view.getQuantity();

            Product p = new Product(name, price, quantity);
            hotel.addProduct(p);

            System.out.println("Product added !");
        } catch (Exception e) {
            System.out.println("Input error.");
        }
    }
}
