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
    private Bouton[][] matriceCellules;

    public Grille(int nbLignes, int nbColonnes) {
        matriceCellules = new Bouton[nbLignes][nbColonnes];
        initialiserGrille();
        allumerBoutonAleatoire();
    }

    public void initialiserGrille() {
        for (int i = 0; i < matriceCellules.length; i++) {
            for (int j = 0; j < matriceCellules[i].length; j++) {
                matriceCellules[i][j] = new Bouton(false);
            }
        }
    }
    public Bouton[][] getMatriceCellules() {
        return matriceCellules;
    }

    public void allumerBoutonAleatoire() {
        Random random = new Random();
        int ligne = random.nextInt(matriceCellules.length);
        int colonne = random.nextInt(matriceCellules[0].length);

        matriceCellules[ligne][colonne].boutonAllume();
    }

    public boolean cliquerBouton(int ligne, int colonne) {
        Bouton bouton = matriceCellules[ligne][colonne];
        if (!bouton.boutonEstEteint()) {
            eteindreBouton(ligne, colonne);
            allumerBoutonAleatoire();

            return true; // Clic réussi
        } else {
            return false; // Clic incorrect
        }
    }

    public void eteindreBouton(int ligne, int colonne) {
        matriceCellules[ligne][colonne].boutonEteint();
    }

    public boolean allumerBouton() {
        for (int i = 0; i < matriceCellules.length; i++) {
            for (int j = 0; j < matriceCellules[i].length; j++) {
                if (!matriceCellules[i][j].boutonEstEteint()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder grilleString = new StringBuilder();

        for (int i = 0; i < matriceCellules.length; i++) {
            for (int j = 0; j < matriceCellules[i].length; j++) {
                grilleString.append(matriceCellules[i][j].getEtat() ? "O " : "X "); // O pour allumé, X pour éteint
            }
            grilleString.append("\n");
        }
        return grilleString.toString();
    }
}
