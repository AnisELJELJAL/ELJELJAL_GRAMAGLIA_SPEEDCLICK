package SPEEDCLICKP;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La classe Partie représente une session de jeu dans Speed-Click.
 * Les joueurs doivent cliquer sur des boutons allumés dans une grille pendant une durée définie.
 * Le but est d'obtenir le meilleur score possible dans le temps imparti.
 * @author anis_
 */
public class Partie {
    private Grille grille;
    private Chronometre chronometre;
    private boolean enCours;

    public Partie(int nbLignes, int nbColonnes, int dureePartieMillis) {
        grille = new Grille(nbLignes, nbColonnes);
       
        
        enCours = false;
    }

    /**
     * lance la partie
     */
    public void demarrerPartie() {
        if (!enCours) {
            grille.eteindreTousLesBoutons();
            grille.allumerBoutonAleatoire();
//            chronometre.lancerChrono();
            enCours = true;
            afficherGrille();
        } else {
            System.out.println("La partie est déjà en cours !");
        }
    }

    /**
     * arrete la partie
     */
    public void arreterPartie() {
        if (enCours) {
//            chronometre.arreterChrono();
            enCours = false;
            System.out.println("Partie terminée. Score final : " + grille.getScore());
            System.out.println("Temps écoulé : " + (chronometre.tempsEcoule() / 1000) + " secondes");
        } else {
            System.out.println("Aucune partie en cours !");
        }
    }

    /**
     * score lorsque l'ont clique
     * @param ligne
     * @param colonne
     */
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

            if (grille.estBoutonAllume(ligne, colonne)) {
               
                grille.eteindreBouton(ligne, colonne);
                System.out.println("Erreur de clic ! Score diminué.");
            }
            else {
                grille.allumerBouton(ligne,colonne);
            }

            grille.allumerBoutonAleatoire();
        } else {
            System.out.println("Aucune partie en cours !");
        }
    }

    /**
     * affiche la grille 
     */
    public void afficherGrille() {
        System.out.println(grille);
    }
}
