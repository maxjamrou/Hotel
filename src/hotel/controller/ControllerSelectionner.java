package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import vue.VueAjoutReservation2;
import vue.VueHotel;

public class ControllerSelectionner implements ActionListener{
    VueHotel main;
    JScrollPane scroller;

    public ControllerSelectionner(VueHotel main, JScrollPane scroll){
        this.main = main;
        this.scroller = scroll;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        ((VueAjoutReservation2)this.main.getListeActions().get(9)).labels.get(0).setText("");
        this.main.getListeActions().get(9).remove(scroller);
        if(((JRadioButton)e.getSource()).getText().equals("Oui")){
            VueAjoutReservation2 vueAjRes2 = ((VueAjoutReservation2)this.main.getListeActions().get(9)).refreshOui();

            JPanel grille = new JPanel(new GridLayout(2, 1));
        
        JPanel rechercherChambre = new JPanel(new BorderLayout());
        
        JPanel formulaire = new JPanel(new GridLayout(3, 2, 3, 3));
        
        
        Vector<JTextField> textFields = new Vector<>();
        Vector<JLabel> erreursMessage = new Vector<>();
        
        JLabel eltManquant = new JLabel();
        eltManquant.setHorizontalAlignment(SwingConstants.CENTER);
        eltManquant.setForeground(Color.red);
        erreursMessage.add(eltManquant);

        textFields.add(new JTextField("-1")); // On ne s'intéresse pas à l'étage de la chambre, -1 est la condition pour ignorer les étages dans Hotel.getChambreByCondition
        erreursMessage.add(new JLabel()); // Même principe, le message d'erreur pour Etage n'a pas d'importance ici

        JLabel prixL = new JLabel("Prix de la chambre :");
        
        JTextField prix = new JTextField();
        textFields.add(prix);
        
        JLabel prixErreur = new JLabel();
        prixErreur.setForeground(Color.red);
        prixErreur.setHorizontalAlignment(SwingConstants.CENTER);

        erreursMessage.add(prixErreur);

        JPanel prixPanel = new JPanel(new BorderLayout());

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
        
        prixPanel.add(prix, BorderLayout.CENTER);
        prixPanel.add(prixErreur, BorderLayout.SOUTH);
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

        formulaire.add(prixL);
        formulaire.add(prixPanel);
        formulaire.add(typeL);
        formulaire.add(listeTypeChambre);
        formulaire.add(minibarL);
        formulaire.add(minibarPanel);

        JButton rechercher = new JButton("Rechercher chambre");

        rechercher.addActionListener(new ControllerRecherche(this.main.getHotel(), vueAjRes2.table, textFields, erreursMessage, radioButtons, listeTypeChambre));

        rechercherChambre.add(eltManquant, BorderLayout.NORTH);
        rechercherChambre.add(formulaire, BorderLayout.CENTER);
        rechercherChambre.add(rechercher, BorderLayout.EAST);

        JPanel tableau = new JPanel(new BorderLayout());
        tableau.add(((VueAjoutReservation2)this.main.getListeActions().get(9)).labels.get(0), BorderLayout.NORTH);
        tableau.add(scroller, BorderLayout.CENTER);


        grille.add(rechercherChambre);
        grille.add(tableau);

        vueAjRes2.add(grille, BorderLayout.CENTER);
        } else if(((JRadioButton)e.getSource()).getText().equals("Non")){
            this.main.getListeActions().get(9).remove(main);
            ((VueAjoutReservation2)this.main.getListeActions().get(9)).refreshNon();
            JPanel tableau = new JPanel(new BorderLayout());
            tableau.add(((VueAjoutReservation2)this.main.getListeActions().get(9)).labels.get(0), BorderLayout.NORTH);
            tableau.add(scroller, BorderLayout.CENTER);
            this.main.getListeActions().get(9).add(tableau, BorderLayout.CENTER);
        }
        this.main.repaint();
        this.main.pack();
    }
    
}
