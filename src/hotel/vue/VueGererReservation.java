package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VueGererReservation extends JPanel {
    public VueGererReservation(){
        super(new BorderLayout());
        JLabel titre = new JLabel("Gérer réservation");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }
}
