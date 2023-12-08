package SPEEDCLICKP;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anis_
 */
public class Partie {
    private Grille grille;
    private Chronometre chronometre;
    private boolean enCours;

    public Partie(int nbLignes, int nbColonnes, int dureePartieMillis) {
        grille = new Grille(nbLignes, nbColonnes);
        chronometre = new Chronometre();
        chronometre.setDuree(dureePartieMillis);
        enCours = false;
    }

    public void demarrerPartie() {
        if (!enCours) {
            grille.eteindreTousLesBoutons();
            grille.allumerBoutonAleatoire();
            chronometre.lancerChrono();
            enCours = true;
            System.out.println("Partie démarrée. Cliquez sur le bouton allumé !");
            afficherGrille();
        } else {
            System.out.println("La partie est déjà en cours !");
        }
    }

    public void arreterPartie() {
        if (enCours) {
            chronometre.arreterChrono();
            enCours = false;
            System.out.println("Partie terminée. Score final : " + grille.getScore());
            System.out.println("Temps écoulé : " + (chronometre.tempsEcoule() / 1000) + " secondes");
        } else {
            System.out.println("Aucune partie en cours !");
        }
    }

    public void clicBouton(int ligne, int colonne) {
        if (enCours) {
            grille.boutonClique();
            afficherGrille();

            if (grille.getScore() > 0 && grille.getScore() % 5 == 0) {
            }

            if (grille.getScore() > 0 && grille.getScore() % 10 == 0) {
            }

            if (grille.getScore() > 0 && grille.getScore() % 15 == 0) {
            }

            if (!grille.estBoutonAllume(ligne, colonne)) {
                // Gestion d'une erreur de clic
                System.out.println("Erreur de clic ! Score diminué.");
            }

            grille.allumerBoutonAleatoire();
        } else {
            System.out.println("Aucune partie en cours !");
        }
    }

    public void afficherGrille() {
        System.out.println(grille);
    }
}
