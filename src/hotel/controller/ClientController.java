package hotel.controller;

import hotel.model.Hotel;

import java.util.Vector;

import hotel.model.Client;

public class ClientController {
    
    private Hotel hotel;

    public ClientController(Hotel h) {
        hotel = h;
    }

    public Vector<Client> getClients() {
        return hotel.getClients();
    }

    public void addClient(String fname, String lname) {
        Client c = new Client(fname, lname, hotel);
        hotel.addClient(c);
    }
}
