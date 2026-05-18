import java.time.LocalDate;
import model.*;
import vue.*;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel 5 Etoiles", "Evry");
        VueHotel window = new VueHotel(hotel);
        Reservation r;
        for(int i = 0; i<4; i++){
            hotel.addClient(new Client("Personne", (i + ""), hotel));
            if(i == 2 || i == 3){
                hotel.addChambre(new Chambre(i, i, true, "Double", hotel));
                
            }
            hotel.addChambre(new Chambre(i, i, false, "Simple", hotel));
            r = new Reservation(LocalDate.parse("2026-04-21"), LocalDate.parse("2026-05-21"), hotel, hotel.getChambres().get(i), hotel.getClients().get(i));
            hotel.addReservation(r);
            hotel.getClients().get(i).addReservation(r);
            hotel.getChambres().get(i).addReservation(r);
            hotel.addProduit(new Produit(("Produit " + i), (2 + i), (5.2 + i), hotel));
        }
        hotel.addClient(new Client("Personne", "4", hotel));
        r = new Reservation(LocalDate.parse("2026-03-21"), LocalDate.parse("2026-04-21"), hotel, hotel.getChambres().get(2), hotel.getClients().get(4));
        r.confirmationSejour();
        r.getSejour().getConsommationMinibar().addProduit(hotel.getProducts().get(1));
        r.getSejour().getConsommationMinibar().addProduit(hotel.getProducts().get(2));
        hotel.addSejour(r.getSejour());

        r = new Reservation(LocalDate.parse("2026-05-21"), LocalDate.parse("2026-06-21"), hotel, hotel.getChambres().get(2), hotel.getClients().get(2));
        hotel.addReservation(r);
        hotel.getClients().get(2).addReservation(r);
        hotel.getChambres().get(2).addReservation(r);
    }
}
