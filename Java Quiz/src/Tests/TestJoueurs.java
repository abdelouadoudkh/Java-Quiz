package Tests;

import main.EtatJoueur;
import main.Joueur;
import main.Joueurs;

public class TestJoueurs {
    public static void main(String arg[]){
        Joueurs joueurs = new Joueurs(4);
        Joueur j1 = new Joueur(0, EtatJoueur.en_attente, "J1");
        joueurs.add(j1);
        Joueur j2 = new Joueur(0, EtatJoueur.elemine, "J2");
        joueurs.add(j2);
        Joueur j3 = new Joueur(0, EtatJoueur.selectione, "J3");
        joueurs.add(j3);
        Joueur j4 = new Joueur(0, EtatJoueur.gagnant, "J4");
        joueurs.add(j4);
        joueurs.add(j1);
        System.out.println(joueurs);
    }
}
