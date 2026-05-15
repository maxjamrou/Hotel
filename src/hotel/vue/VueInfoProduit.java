package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Produit;

public class VueInfoProduit extends JPanel{
    VueHotel main;
    JLabel titre;

    public VueInfoProduit(VueHotel main){
        super(new BorderLayout());
        this.main = main;
        titre = new JLabel();
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }

    public void refresh(Produit p){
        titre.setText("Information produit " + p.getName());
    }
}
