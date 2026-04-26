package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VueGererProduit extends JPanel{
    public VueGererProduit(){
        super(new BorderLayout());
        JLabel titre = new JLabel("Gérer produit");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }
}
