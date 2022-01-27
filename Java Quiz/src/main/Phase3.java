package main;

import java.util.Scanner;

public class Phase3 implements Phase{
    private final String FELECITATION = "\t\t\t\t\t\t\t\t_______________________________________________________________\n" +
                                        "\t\t\t\t\t\t\t\t|                        FELECITATION!                        |\n" +
                                        "\t\t\t\t\t\t\t\t---------------------------------------------------------------\n";
    private static final int DIFFICULTE_PHASE = 3;
    private static final int NOMBRE_DE_THEMES_ELIMNE = 7;
    private final static int SCORE_AJOUTE = 5;
    private Joueur[] joueurs;

    @Override
    public void selectionJoueurs(Joueurs joueurs) {this.joueurs = joueurs.getJoueurs();}

    @Override
    public void derouler(Themes themes) {
        Themes themeElimination = themes;
        Scanner sc= new Scanner(System.in);
        System.out.print("\n-------- Début de la phase 3 ----\n" +
                "\t---- Dans cette phase les joueurs élimineront à tour de rôle les thèmes jusqu'à ce qu'il en reste 3," +
                " ils répondront à nouveau à tour de rôle à une question difficile par thème  \n"+
                "\nfaite rentrer n'importe quel valeur pour comancer la phase : ");
        sc.nextInt();
        for(int i = 0; i< NOMBRE_DE_THEMES_ELIMNE; i++){
            System.out.println(" \t\t\t\t\t\t[joueur " + joueurs[i % 2] + "]");
            themeElimination = Utilities.ProcessusDeliminationThemes(themeElimination);
        }
        for(Theme theme : themeElimination){
            theme.setChoisis(true);
            Questions questions = theme.getQuestions();
            System.out.println("\n\t\t\t\t--- Chargement du theme : [" + theme + "]");
            for (int i = 0; i < 2; i++){
                System.out.println("Au tour du joueur : " + joueurs[i]);
                if(questions.askQuestion(DIFFICULTE_PHASE)){joueurs[i].setScore(SCORE_AJOUTE);}
            }
        }
        for (Theme theme : themes){theme.setChoisis(false);}
        Joueurs joueurQualifiees = new Joueurs(1);
        joueurQualifiees.setJoueurs(Utilities.sortJoueursParScore(joueurs, 1));

        System.out.println(FELECITATION + "\n\t\t----- Le gagnant est : \n\t\t\t\t " + joueurQualifiees.getJoueurs()[0]);
        Utilities.resetGame(themes);
        Utilities.waitForInput("Revenir au menu : ");
    }
}
