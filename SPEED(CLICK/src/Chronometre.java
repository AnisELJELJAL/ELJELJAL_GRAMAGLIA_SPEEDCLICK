/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mathi
 */
public class Chronometre {
    private long debut;
    private long duree;

    public void lancerChrono() {
        debut = System.nanoTime();
    }

    public void arreterChrono() {
        long fin = System.nanoTime();
        duree = fin - debut;
    }

    public long tempsEcoule() {
        return duree / 1_000_000; // Convertir de nanosecondes à millisecondes
    }

    public long tempsRestant() {
        return Math.max(0, duree - tempsEcoule());
    }

    public boolean estEnMarche() {
        return debut > 0 && !aTermine();
    }

    public boolean aTermine() {
        return tempsRestant() == 0;
    }

    public void setDuree(int dureeMillis) {
        this.duree = dureeMillis * 1_000_000; // Convertir de millisecondes à nanosecondes
    }
}



