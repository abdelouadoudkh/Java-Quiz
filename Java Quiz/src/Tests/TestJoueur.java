package Tests;

import main.EtatJoueur;
import main.Joueur;

public class TestJoueur {
    public static void main(String arg[]){
        Joueur j = new Joueur(0, EtatJoueur.en_attente,"JoueurTest");
        Joueur j1 = new Joueur();
        j1.saisirJoueur();

        System.out.println(j);
        System.out.println(j1);

    }
}
