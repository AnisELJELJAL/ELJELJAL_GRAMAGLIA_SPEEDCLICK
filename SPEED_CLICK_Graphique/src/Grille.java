/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mathi
 */
import java.util.Random;

public class Grille {
    private Bouton[][] matriceBoutons;
    private int nbLignes;
    private int nbColonnes;
    private int boutonAllumeLigne;
    private int boutonAllumeColonne;
    private int score;

    public Grille(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        matriceBoutons = new Bouton[nbLignes][nbColonnes];
        initialiserGrille();
        score = 0;
        allumerBoutonAleatoire();
    }

    private void initialiserGrille() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceBoutons[i][j] = new Bouton(false);
            }
        }
    }

    void allumerBoutonAleatoire() {
        Random random = new Random();
        boutonAllumeLigne = random.nextInt(nbLignes);
        boutonAllumeColonne = random.nextInt(nbColonnes);
        matriceBoutons[boutonAllumeLigne][boutonAllumeColonne].boutonAllume();
    }

    public boolean estBoutonAllume(int ligne, int colonne) {
        return matriceBoutons[ligne][colonne].getEtat();
    }
    public void eteindreTousLesBoutons() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceBoutons[i][j].boutonEteint();
            }
        }
    }

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
    public int getScore() {
        return score;
    }
    public int getNbLignes() {
        return nbLignes;
    }
    public int getNbColonnes() {
        return nbColonnes;
    }
    
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


