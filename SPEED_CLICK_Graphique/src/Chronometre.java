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

    void setDuree(int dureePartieMillis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
