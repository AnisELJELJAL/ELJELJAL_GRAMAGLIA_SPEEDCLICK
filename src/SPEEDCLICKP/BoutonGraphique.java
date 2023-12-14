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
 protected void paintComponent(Graphics g) {
 int w = this.getWidth();
 int h = this.getHeight();
 if ( BoutonLumineuxAssociee.boutonEstEteint() == true) {
 g.setColor(Color.red);
 } else {
 g.setColor(Color.yellow);
 }
 g.fillRect(2, 2, w - 4, h - 4);
 }

 }
 
