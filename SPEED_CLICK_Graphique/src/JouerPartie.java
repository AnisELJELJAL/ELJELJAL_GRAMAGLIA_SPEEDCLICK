/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mathi
 */
public class JouerPartie {
    private Grille grille;
    private Chronometre chronometre;
    private int score;

    public JouerPartie(int nbLignes, int nbColonnes) {
        grille = new Grille(nbLignes, nbColonnes);
        chronometre = new Chronometre();
        score = 0;
    }

    public void demarrerPartie() {
        grille.initialiserGrille();
        grille.allumerBoutonAleatoire();
        chronometre.lancerChrono();
        score = 0;
    }

    public void terminerPartie() {
        chronometre.arreterChrono();
        long tempsEcoule = chronometre.tempsEcoule();
        System.out.println("Temps écoulé : " + tempsEcoule + " millisecondes");
        System.out.println("Score final : " + score);
    }

    public void effectuerClic(int ligne, int colonne) {
        Bouton bouton = grille.getMatriceCellules()[ligne][colonne];
        if (!bouton.boutonEstEteint()) {
            grille.eteindreBouton(ligne, colonne);
            grille.allumerBoutonAleatoire();
            score++;
        } else {
            score--;
            grille.allumerBoutonAleatoire();
        }
    }

    public int getScore() {
        return score;
    }
    
}

