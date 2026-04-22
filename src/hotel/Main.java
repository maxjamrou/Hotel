

import model.*;
import vue.VueHotel;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Best hotel ever", "Evry");
        VueHotel window = new VueHotel(hotel);
        Client[] clients = new Client[4];
        Chambre[] chambres = new Chambre[4];
        Reservation[] reservations = new Reservation[4];
        Produit[] produits = new Produit[4];
        Sejour[] sejours = new Sejour[3];
        for(int i = 0; i<clients.length; i++){
            clients[i] = new Client("Personne", (i + ""), hotel);
            if(i == 2 || i == 3){
                chambres[i] = new Chambre(i, i, true, TypeChambre.Double, hotel);

            }
            chambres[i] = new Chambre(i, i, false, TypeChambre.Simple, hotel);
            reservations[i] = new Reservation("2026-04-21", "2026-05-21", hotel, chambres[i], clients[i]);
            produits[i] = new Produit(("Produit " + i), (2 + i), (5.2 + i), hotel);
        }
        sejours[0] = new Sejour(reservations[1], hotel);
        sejours[1] = new Sejour(reservations[2], hotel);
        sejours[1].getConsommationMinibar().addProduit(produits[0]);
        sejours[1].getConsommationMinibar().addProduit(produits[1]);
        sejours[2] = new Sejour(reservations[3], hotel);
        sejours[2].getConsommationMinibar().addProduit(produits[2]);
        sejours[2].getConsommationMinibar().addProduit(produits[3]);
        System.out.println(chambres[2].getEtage());
    }
}
