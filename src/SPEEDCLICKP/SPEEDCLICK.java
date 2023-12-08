/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SPEEDCLICKP;


public class SPEEDCLICK {


        public static void main(String[] args) {
        Partie partie = new Partie(3, 3, 30000); // Une grille de 3x3 et une durée de partie de 30 secondes
        partie.demarrerPartie();
        partie.arreterPartie();
    }
}
