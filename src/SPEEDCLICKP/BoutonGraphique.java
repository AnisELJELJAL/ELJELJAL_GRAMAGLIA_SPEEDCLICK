package SPEEDCLICKP;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anis_
 */


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
public class BoutonGraphique extends JButton {
 int largeur; // largeur en pixel de la cellule
 int hauteur; // hauteur en pixel de la cellule
 Bouton BoutonLumineuxAssociee;
 // constructeur (appelé depuis FenetrePrincipale)
 public BoutonGraphique(Bouton celluleLumineuseAssociee, int l,int h) {
 this.largeur = l;
 this.hauteur = h;
 this.BoutonLumineuxAssociee = celluleLumineuseAssociee ; 
 }

    /**
     * creation de la forme des boutons graphiques 
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        // Définir la couleur du cercle en fonction de l'état du bouton (éteint ou allumé)
        if (BoutonLumineuxAssociee.boutonEstEteint()) {
            g.setColor(Color.gray);
        } else {
            g.setColor(Color.YELLOW);
        }

        // Dessiner un cercle
        g.fillOval(2, 2, w - 4, h - 4);
    }
}
 
