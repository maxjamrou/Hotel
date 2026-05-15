package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Client;

public class VueInfoClient extends JPanel{
    VueHotel main;
    JLabel titre;

    public VueInfoClient(VueHotel main){
        super(new BorderLayout());
        this.main = main;
        titre = new JLabel();
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }

    public void refresh(Client c){
        titre.setText("Information client " + c.getNom() + " " + c.getPrenom());
    }
}
