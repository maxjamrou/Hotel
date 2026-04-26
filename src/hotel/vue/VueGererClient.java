package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VueGererClient extends JPanel{
    public VueGererClient(){
        super(new BorderLayout());
        JLabel titre = new JLabel("Gérer client");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titre, BorderLayout.NORTH);
    }
}
