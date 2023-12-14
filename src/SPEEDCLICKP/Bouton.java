package SPEEDCLICKP;


import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anis_
 */

 public class Bouton {
    private boolean etat;

    public Bouton(boolean unEtat) {
        this.etat = unEtat;
    }

    public void boutonEteint() {
        etat = false;
    }

    public void boutonAllume() {
        etat = true;
    }

    public boolean boutonEstEteint() {
        return !etat;
    }

    public boolean getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        return etat ? "O" : "X";
    }
}

