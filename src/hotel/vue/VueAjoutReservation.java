package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VueAjoutReservation extends JPanel{
    VueHotel main;
    JTextField anneeDebField;
    JTextField moisDebField;
    JTextField jourDebField;
    JTextField anneeFinField;
    JTextField moisFinField;
    JTextField jourFinField;
    JTextField nomClient;
    JTextField prenomClient;

    public VueAjoutReservation(){
        super(new BorderLayout());
        JLabel titre = new JLabel("Ajouter réservation");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }
}
