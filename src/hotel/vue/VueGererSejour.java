package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VueGererSejour extends JPanel{
    public VueGererSejour(){
        super(new BorderLayout());
        JLabel titre = new JLabel("Gérer séjour");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }
}
