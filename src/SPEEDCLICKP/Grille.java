package SPEEDCLICKP;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anis_
 */
import java.util.Random;

/**
 * La classe Grille représente la grille de boutons dans le jeu Speed-Click. Les
 * joueurs doivent cliquer sur les boutons allumés pour marquer des points.
 */

public class Grille {

    Bouton[][] matriceBoutons;
    private int nbLignes;
    private int nbColonnes;
    private int boutonAllumeLigne;
    private int boutonAllumeColonne;
    private int score;

    /**
     * Constructeur de la classe Grille.
     *
     * @param nbLignes Le nombre de lignes dans la grille.
     * @param nbColonnes Le nombre de colonnes dans la grille.
     */
        public Grille(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        matriceBoutons = new Bouton[nbLignes][nbColonnes];
        initialiserGrille();
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceBoutons[i][j] = new Bouton(false);
            }
        }
        score = 0;
        allumerBoutonAleatoire();
    }

    /**
     * creation de la grile
     * Initialise la grille en créant des boutons éteints pour chaque cellule.
     * Cette méthode est appelée lors de la création d'une nouvelle instance de la classe Grille
     * @param g
     */
    private void initialiserGrille() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceBoutons[i][j] = new Bouton(false);
            }
        }
    }
    
    /**
     * Allume un bouton aléatoire dans la grille.
     */
    void allumerBoutonAleatoire() {
        Random random = new Random();
        boutonAllumeLigne = random.nextInt(nbLignes);
        boutonAllumeColonne = random.nextInt(nbColonnes);
        if (matriceBoutons[boutonAllumeLigne][boutonAllumeColonne].getEtat() == true) {
            allumerBoutonAleatoire();
        } else {
            matriceBoutons[boutonAllumeLigne][boutonAllumeColonne].boutonAllume();
        }
    }
    /**
     * Allume un bouton dans la grille.
     */
    void allumerBouton(int ligne, int colonne) {
        matriceBoutons[ligne][colonne].boutonAllume();
    }
    /**
     * Eteint un bouton dans la grille.
     */
    void eteindreBouton(int ligne, int colonne) {
        matriceBoutons[ligne][colonne].boutonEteint();

    }

    /**
     * verifie si un bouton est allume
     * @param ligne
     * @param colonne
     * @return
     */
    public boolean estBoutonAllume(int ligne, int colonne) {
        return matriceBoutons[ligne][colonne].getEtat();
    }

    /**
     * eteint tous les boutons
     */
    public void eteindreTousLesBoutons() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceBoutons[i][j].boutonEteint();
            }
        }
    }

    /**
     * rajoute du score lorsque l'ont clique
     */
    public void boutonClique() {
        if (estBoutonAllume(boutonAllumeLigne, boutonAllumeColonne)) {
            score++;
            matriceBoutons[boutonAllumeLigne][boutonAllumeColonne].boutonEteint();
            allumerBoutonAleatoire();
        } else {
            if (score > 0) {
                score--;
            }
        }
    }

    /**
     * renvoie le score
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * renvoie la ligne
     * @return
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * renvoie loa colonne
     * @return
     */
    public int getNbColonnes() {
        return nbColonnes;
    }

    /**
     * Affiche la représentation textuelle de la grille.
     * @return Une représentation textuelle de la grille.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (estBoutonAllume(i, j)) {
                    sb.append("[O] "); // [O] pour représenter un bouton allumé
                } else {
                    sb.append("[X] "); // [X] pour représenter un bouton éteint
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

