package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {
    public static Joueur[] sortJoueursParScore(Joueur[] tempJoueurs, int size){
        Joueur[] joueurs = tempJoueurs.clone();
        for (int i = 0; i < size; i++){
            Joueur max = joueurs[i];
            int indexMax = i;
            for (int j = i+1; j < size + 1; j++){
                if (joueurs[j].getScore() > max.getScore()){
                    max = joueurs[j];
                    indexMax = j;
                }
            }
            Joueur temp = joueurs[i];
            joueurs[i] = joueurs[indexMax];
            joueurs[indexMax] = temp;
        }
        Joueur[] joueurQualifies = new Joueur[size];
        for (int i = 0; i < size; i++){
            joueurQualifies[i] = joueurs[i];
        }
        joueurs[size].setEtat(EtatJoueur.elemine);
        return joueurQualifies;
    }
    public static Theme selectionnerTheme(Themes themes){
        //imprime une liste de themes, attend un input pour choisir l'un des themes puis le retourne
        if (themes.getThemes().size() == 1){
            System.out.print("\n\t\t\t--- Dernier theme ["+ themes.getThemes().get(0) +"] choisi automatiquement");
            return themes.getThemes().get(0);
        }
        System.out.println("Choisissez un parmis les themes suivants : \n" + themes);
        System.out.print("\tVotre Choix : ");
        Scanner sc = new Scanner(System.in);
        int choixTheme;
        do {
            choixTheme = sc.nextInt();
            if (choixTheme < 0 || choixTheme > themes.getThemes().size() - 1) System.out.print("Veillez effectuer un choix valide : ");
        }while(choixTheme < 0 || choixTheme > themes.getThemes().size() - 1);
        Theme newTheme = themes.getThemes().get(choixTheme);
        themes.getThemes().remove(choixTheme);
        return newTheme;
    }
    public static void waitForInput(String action){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n faite rentrer une valeur pour " + action);
        sc.nextInt();
    }
    public static Themes ProcessusDeliminationThemes(Themes themes){
        ArrayList<Theme> themeArrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choix;
        System.out.print("Choisisser un theme a eliminer parmis : \n" + themes + "\n\t Votre choix : ");
        do {
            choix = sc.nextInt();
            if (choix < 0 || choix > themes.getThemes().size()) System.out.print("Veillez effectuer un choix valide : ");
        }while (choix < 0 || choix > themes.getThemes().size());
        for(int i = 0; i < themes.getThemes().size(); i++){
            if(i != choix)themeArrayList.add(themes.getThemes().get(i));
        }
        return new Themes(themeArrayList);
    }
    public static void resetGame(Themes themes){
        for (Theme theme : themes){
            theme.setChoisis(false);
            for (Question question : theme){
                question.setChoisi(false);
            }
        }
    }

}
