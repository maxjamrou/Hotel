import java.time.LocalDate;
import model.*;
import vue.*;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Best hotel ever", "Evry");
        VueHotel window = new VueHotel(hotel);
        for(int i = 0; i<4; i++){
            hotel.addClient(new Client("Personne", (i + ""), hotel));
            if(i == 2 || i == 3){
                hotel.addChambre(new Chambre(i, i, true, "Double", hotel));
                
            }
            hotel.addChambre(new Chambre(i, i, false, "Simple", hotel));
            Reservation r = new Reservation(LocalDate.parse("2026-04-21"), LocalDate.parse("2026-05-21"), hotel, hotel.getChambres().get(i), hotel.getClients().get(i));
            hotel.addReservation(r);
            hotel.getClients().get(i).addReservation(r);
            hotel.getChambres().get(i).addReservation(r);
            hotel.addProduit(new Produit(("Produit " + i), (2 + i), (5.2 + i), hotel));
        }
        hotel.addSejour(new Sejour(hotel.getReservations().get(1), hotel));
        hotel.addSejour(new Sejour(hotel.getReservations().get(2), hotel));
        hotel.getSejours().get(1).getConsommationMinibar().addProduit(hotel.getProducts().get(0));
        hotel.getSejours().get(1).getConsommationMinibar().addProduit(hotel.getProducts().get(1));
        hotel.addSejour(new Sejour(hotel.getReservations().get(3), hotel));
        hotel.getSejours().get(2).getConsommationMinibar().addProduit(hotel.getProducts().get(2));
        hotel.getSejours().get(2).getConsommationMinibar().addProduit(hotel.getProducts().get(3));
        hotel.addReservation(new Reservation(LocalDate.parse("2026-03-21"), LocalDate.parse("2026-04-21"), hotel, hotel.getChambres().get(2), hotel.getClients().get(2)));
        hotel.addSejour(new Sejour(hotel.getReservations().getLast(), hotel));
        hotel.getSejours().getLast().getConsommationMinibar().addProduit(hotel.getProducts().get(0));
        hotel.getSejours().getLast().getConsommationMinibar().addProduit(hotel.getProducts().get(1));
        hotel.getSejours().getLast().getConsommationMinibar().addProduit(hotel.getProducts().get(2));
    }
}
