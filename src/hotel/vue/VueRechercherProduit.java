package vue;

import controller.ControllerModifier;
import controller.ControllerRecherche;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class VueRechercherProduit extends JPanel{
    VueHotel main;
    JTable produitsTable;

    public VueRechercherProduit(VueHotel main){
        super(new BorderLayout(3,3));
        this.main = main;

        JLabel titre = new JLabel("Rechercher produit");
        titre.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel grille = new JPanel(new GridLayout(2, 1));

        JPanel rechercherProduit = new JPanel(new BorderLayout());

        JPanel formulaire = new JPanel(new GridLayout(2, 2, 3, 3));

        JLabel nomL = new JLabel("Nom du produit :");

        Vector<JTextField> textFields = new Vector<>();
        Vector<JLabel> erreursMessage = new Vector<>();

        JLabel eltManquant = new JLabel();
        eltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        eltManquant.setForeground(Color.red);
        erreursMessage.add(eltManquant);

        JTextField nom = new JTextField();

        textFields.add(nom);
        
        JLabel prixL = new JLabel("Prix du produit :");

        JPanel prixPanel = new JPanel(new BorderLayout());

        JTextField prix = new JTextField();
        JLabel prixErreur = new JLabel();
        prixErreur.setHorizontalAlignment(SwingConstants.CENTER);
        prixErreur.setForeground(Color.RED);
        erreursMessage.add(prixErreur);
        
        textFields.add(prix);

        ButtonGroup infSup = new ButtonGroup();
        JPanel supInfPanel = new JPanel(new BorderLayout());
        JRadioButton inf = new JRadioButton("<");
        JRadioButton sup = new JRadioButton(">");
        inf.setSelected(true);

        infSup.add(inf);
        infSup.add(sup);

        supInfPanel.add(inf, BorderLayout.NORTH);
        supInfPanel.add(sup, BorderLayout.SOUTH);

        prixPanel.add(prix, BorderLayout.CENTER);
        prixPanel.add(supInfPanel, BorderLayout.WEST);
        prixPanel.add(prixErreur, BorderLayout.SOUTH);

        formulaire.add(nomL);
        formulaire.add(nom);
        formulaire.add(prixL);
        formulaire.add(prixPanel);

        DefaultTableModel model = new DefaultTableModel();
        this.produitsTable = new JTable(model);
        model.addColumn("Nom");
        model.addColumn("Prix");
        model.addColumn("Produit"); // utilisé pour ranger l'objet Produit
        this.produitsTable.removeColumn(this.produitsTable.getColumn("Produit")); // devient "invisible" dans le tableau, seulement accessible via le modèle du JTable
        JScrollPane scrollPane = new JScrollPane(this.produitsTable);

        JLabel produitEltManquant = new JLabel();
        produitEltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        produitEltManquant.setForeground(Color.red);

        JButton rechercher = new JButton("Rechercher produit");
        JButton modifier = new JButton("Modifier produit");

        rechercher.addActionListener(new ControllerRecherche(this.main.getHotel(), produitsTable, textFields, erreursMessage, inf));
        modifier.addActionListener(new ControllerModifier(main, produitsTable, produitEltManquant));

        rechercherProduit.add(eltManquant, BorderLayout.NORTH);
        rechercherProduit.add(formulaire, BorderLayout.CENTER);
        rechercherProduit.add(rechercher, BorderLayout.SOUTH);

        JPanel tableau = new JPanel(new BorderLayout());
        tableau.add(produitEltManquant, BorderLayout.NORTH);
        tableau.add(scrollPane, BorderLayout.CENTER);
        tableau.add(modifier, BorderLayout.EAST);

        grille.add(tableau);
        grille.add(rechercherProduit);

        this.add(titre, BorderLayout.NORTH);
        this.add(grille, BorderLayout.CENTER);
    }
}
