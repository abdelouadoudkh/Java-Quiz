package main;

import java.util.Scanner;

public class Joueur {
    private static int numSequenciel = 1;
    private int numJoueur;
    private int score;
    private EtatJoueur etat;
    private String nom;
    private final static int COEF_JOUEUR = 10;
    private final static int COEF_PREMIER_JOUEUR = 100;

    public Joueur(int score, EtatJoueur etat, String nom) {
        this.numJoueur = numSequenciel * COEF_JOUEUR + COEF_PREMIER_JOUEUR;
        numSequenciel++;
        this.score = score;
        this.etat = etat;
        this.nom = nom;
    }

    public Joueur()
    {
        this(0,EtatJoueur.en_attente,"");
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public EtatJoueur getEtat() {
        return etat;
    }

    public void setEtat(EtatJoueur etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public void saisirJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le nom du nouveau joueur : ");
        nom = sc.nextLine();
    }
    @Override
    public String toString(){
        return "Joueur N°" + numJoueur + " / nom : " + nom + " / score : " + score + " / est "+etat.toString();
    }
}
