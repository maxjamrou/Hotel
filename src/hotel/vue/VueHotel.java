package vue;

import javax.swing.*;
import model.*;

public class VueHotel extends JFrame {
    public JMenuBar menu;
    public JMenu client;
    public JMenu produit;
    public JMenu chambre;
    public JMenu sejour;
    public JMenu reservation;

    public Hotel hotel;

    public VueHotel(Hotel hotel){
        this.hotel = hotel;
        super("Hotel " + hotel.getNom());
        setJMenuBar(menu);
        menu = new JMenuBar();
        client = new JMenu("Client");
        menu.add(client);
        produit = new JMenu("Produit");
        menu.add(produit);
        chambre = new JMenu("Chambre");
        menu.add(chambre);
        reservation = new JMenu("Reservation");
        menu.add(reservation);
        sejour = new JMenu("Sejour");
        menu.add(sejour);
    }
}
