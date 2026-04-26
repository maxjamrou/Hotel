package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VueAjoutProduit extends JPanel{
    public VueAjoutProduit(){
        super(new BorderLayout());
        JLabel titre = new JLabel("Ajouter produit");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }
}
