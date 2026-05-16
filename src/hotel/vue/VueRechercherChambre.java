package vue;

import controller.ControllerModifier;
import controller.ControllerRecherche;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class VueRechercherChambre extends JPanel{
    VueHotel main;
    JTable chambresTable;
    
    public VueRechercherChambre(VueHotel main){
        this.main = main;
        
        super(new BorderLayout(3,3));
        this.main = main;
        
        JLabel titre = new JLabel("Rechercher chambre");
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel grille = new JPanel(new GridLayout(2, 1));
        
        JPanel rechercherChambre = new JPanel(new BorderLayout());
        
        JPanel formulaire = new JPanel(new GridLayout(4, 2, 3, 3));
        
        
        Vector<JTextField> textFields = new Vector<>();
        Vector<JLabel> erreursMessage = new Vector<>();
        
        JLabel eltManquant = new JLabel();
        eltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        eltManquant.setForeground(Color.red);
        erreursMessage.add(eltManquant);
        
        JLabel etageL = new JLabel("Etage de la chambre :");

        JTextField etage = new JTextField();
        textFields.add(etage);

        JLabel etageErreur = new JLabel();
        etageErreur.setForeground(Color.RED);
        etageErreur.setHorizontalAlignment(SwingConstants.CENTER);
        erreursMessage.add(etageErreur);

        JPanel etagePanel = new JPanel(new BorderLayout());
        etagePanel.add(etage, BorderLayout.CENTER);
        etagePanel.add(etageErreur, BorderLayout.SOUTH);

        JLabel prixL = new JLabel("Prix de la chambre :");
        
        JTextField prix = new JTextField();
        textFields.add(prix);
        
        JLabel prixErreur = new JLabel();
        prixErreur.setForeground(Color.red);
        prixErreur.setHorizontalAlignment(SwingConstants.CENTER);

        erreursMessage.add(prixErreur);

        JPanel prixPanel = new JPanel(new BorderLayout());

        prixPanel.add(prix, BorderLayout.CENTER);
        prixPanel.add(prixErreur, BorderLayout.SOUTH);

        JPanel supInfPanel = new JPanel(new BorderLayout());

        Vector<JRadioButton> radioButtons = new Vector<>();

        ButtonGroup supInf = new ButtonGroup();
        JRadioButton inf = new JRadioButton("<");
        JRadioButton sup = new JRadioButton(">");

        supInf.add(inf);
        supInf.add(sup);

        supInfPanel.add(inf, BorderLayout.NORTH);
        supInfPanel.add(sup, BorderLayout.SOUTH);

        radioButtons.add(inf);

        prixPanel.add(supInfPanel, BorderLayout.WEST);
        prixPanel.add(prix, BorderLayout.CENTER);
        
        inf.setSelected(true);
        
        JLabel typeL = new JLabel("Type de la chambre :");
        Vector<String> listeType = new Vector<>();
        listeType.add("");
        listeType.add("Simple");
        listeType.add("Double");
        listeType.add("Suite Normale");
        listeType.add("Suite Présidentielle");
        JComboBox<String> listeTypeChambre = new JComboBox<>(listeType);
        listeTypeChambre.setSelectedItem("");
        
        JLabel minibarL = new JLabel("Possède un minibar :");
        JPanel minibarPanel = new JPanel();

        ButtonGroup minibar = new ButtonGroup();
        JRadioButton hasMinibar = new JRadioButton("Oui");
        JRadioButton hasNoMinibar = new JRadioButton("Non");
        JRadioButton peuImporte = new JRadioButton("Peu importe");
        peuImporte.setSelected(true);
        
        minibar.add(hasMinibar);
        minibar.add(hasNoMinibar);
        minibar.add(peuImporte);

        minibarPanel.add(hasMinibar);
        minibarPanel.add(hasNoMinibar);
        minibarPanel.add(peuImporte);

        radioButtons.add(hasMinibar);
        radioButtons.add(hasNoMinibar);
        radioButtons.add(peuImporte);

        formulaire.add(etageL);
        formulaire.add(etagePanel);
        formulaire.add(prixL);
        formulaire.add(prixPanel);
        formulaire.add(typeL);
        formulaire.add(listeTypeChambre);
        formulaire.add(minibarL);
        formulaire.add(minibarPanel);

        DefaultTableModel model = new DefaultTableModel();
        this.chambresTable = new JTable(model);
        model.addColumn("Etage");
        model.addColumn("€/Nuit");
        model.addColumn("Type de chambre");
        model.addColumn("Possède un minibar");
        model.addColumn("Chambre"); // utilisé pour ranger l'objet Chambre
        this.chambresTable.removeColumn(this.chambresTable.getColumn("Chambre")); // devient "invisible" dans le tableau, seulement accessible via le modèle du JTable
        JScrollPane scrollPane = new JScrollPane(this.chambresTable);
        // scrollPane.setVisible(false);

        JLabel chambreEltManquant = new JLabel();
        chambreEltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        chambreEltManquant.setForeground(Color.red);

        JButton rechercher = new JButton("Rechercher chambre");
        JButton modifier = new JButton("Modifier chambre");

        rechercher.addActionListener(new ControllerRecherche(this.main.getHotel(), chambresTable, textFields, erreursMessage, radioButtons, listeTypeChambre));
        modifier.addActionListener(new ControllerModifier(main, chambresTable, chambreEltManquant));

        rechercherChambre.add(eltManquant, BorderLayout.NORTH);
        rechercherChambre.add(formulaire, BorderLayout.CENTER);
        rechercherChambre.add(rechercher, BorderLayout.SOUTH);

        JPanel tableau = new JPanel(new BorderLayout());
        tableau.add(chambreEltManquant, BorderLayout.NORTH);
        tableau.add(scrollPane, BorderLayout.CENTER);
        tableau.add(modifier, BorderLayout.EAST);

        grille.add(tableau);
        grille.add(rechercherChambre);

        this.add(titre, BorderLayout.NORTH);
        this.add(grille, BorderLayout.CENTER);
    }
}
