/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.speed_click2;

/**
 *
 * @author mathi
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Partie {
    private Grille grille;
    private Chronometre chronometre;
    private boolean enCours;
    private Map<Integer, int[]> touches;

    public Partie(int nbLignes, int nbColonnes, int dureePartieMillis) {
        grille = new Grille(nbLignes, nbColonnes);
        chronometre = new Chronometre();
        chronometre.setDuree(dureePartieMillis);
        enCours = false;

        // Initialisez la correspondance des touches avec les touches numériques
        touches = new HashMap<>();
        int touche = 1;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                touches.put(touche, new int[]{i, j});
                touche++;
            }
        }
    }

    public void jouerPartie() {
        demarrerPartie();

        Scanner scanner = new Scanner(System.in);

        while (enCours) {
            System.out.println("Appuyez sur une touche correspondant à un bouton (1-9) : ");

            try {
                int touche = scanner.nextInt();

                if (touches.containsKey(touche)) {
                    int[] coordonnees = touches.get(touche);
                    clicBouton(coordonnees[0], coordonnees[1]);
                } else {
                    System.out.println("Touche non valide. Appuyez sur une touche correspondant à un bouton (1-9).");
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la saisie. Assurez-vous de saisir un nombre valide (1-9).");
                scanner.nextLine(); // Nettoyer la ligne incorrecte du scanner
            }
        }

        arreterPartie();
    }

    public void demarrerPartie() {
        if (!enCours) {
            grille.eteindreTousLesBoutons();
            grille.allumerBoutonAleatoire();
            enCours = true;
            System.out.println("Cliquez sur le bouton allumé pour démarrer la partie !");
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
        if (!chronometre.estEnMarche()) {
            chronometre.lancerChrono();
            System.out.println("La partie a commencé !");
        }

        // Vérifiez si le bouton actuel est correctement allumé
        if (grille.estBoutonAllume(ligne, colonne)) {
            grille.boutonClique();
            afficherGrille();

            // Vérifiez si le bouton actuel a déjà été cliqué
            while (grille.estBoutonAllume(ligne, colonne)) {
                System.out.println("Erreur de clic ! Score diminué.");
                grille.boutonClique(); // Éteindre le bouton déjà allumé
                grille.allumerBoutonAleatoire(); // Allumer un nouveau bouton
                afficherGrille();
            }
        } else {
            System.out.println("Erreur de clic ! Score diminué.");
        }
    } else {
        System.out.println("Aucune partie en cours !");
    }

    }

    public void afficherGrille() {
        System.out.println(grille);
    }

}


