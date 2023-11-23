/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package speed.click;

import java.util.Scanner;

/**
 *
 * @author mathi
 */
import java.util.Scanner;

public class SPEEDCLICK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu SPEED-CLICK !");

        // Instancier la classe JouerPartie
        JouerPartie jeu = new JouerPartie(3, 3);

        // Utiliser la méthode pour initialiser la partie
        jeu.initialiserPartie();

        // Utiliser la méthode pour jouer la partie
        jeu.jouerPartie();
    }
}

