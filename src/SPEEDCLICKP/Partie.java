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
      public void startGame() {
        initializeGame();
        startGameTimer();
        playGame();
    }
      private void initializeGame() {
        buttons = new boolean[grille_taille][grille_taille];
        score = 0;
        timeRemaining = GAME_TEMPS;
        updateButtonState();
    }
       private void updateGame() {
        if (timeRemaining > 0) {
            timeRemaining--;

            if (timeRemaining == 0) {
                endGame();
            } else {
                updateButtonState();
            }
        }
    }
           private void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (timeRemaining > 0) {
            System.out.print("Entrer LIGNE ET COLONNE : ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidInput(row, col) && buttons[row][col]) {
                score++;
                updateButtonState();
            } else {
                System.out.println("Wrong button! Try again.");
            }
        }

        endGame();
        scanner.close();
    }
       private void endGame() {
        System.out.println("Game Over! Score: " + score);
    }
     
       private void printGrid() {
        System.out.println("Score: " + score);
        System.out.println("Time Remaining: " + timeRemaining + " seconds");

        for (int i = 0; i < grille_taille; i++) {
            for (int j = 0; j < grille_taille; j++) {
                System.out.print(buttons[i][j] ? "O " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
