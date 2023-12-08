package SPEEDCLICKP;


import java.util.Timer;
import java.util.TimerTask;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anis_
 */
public class Chronometre {
    private long debut;
    private long duree;

    public void lancerChrono() {
        debut = System.currentTimeMillis();
    }

    public void arreterChrono() {
        long fin = System.currentTimeMillis();
        duree = fin - debut;
    }

    public long tempsEcoule() {
        return duree;
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

    void setDuree(int dureePartieMillis) {
     }
}
