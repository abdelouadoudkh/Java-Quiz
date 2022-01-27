package main;

import java.util.Scanner;

public class Phase2 implements Phase{
    private static final int DIFFICULTE_PHASE = 2;
    private static final int NOMBRE_DE_THEMES_ALEATOIRE = 6;
    private final static int SCORE_AJOUTE = 3;
    private Joueur[] joueurs;
    public Phase2() {}

    @Override
    public void selectionJoueurs(Joueurs joueurs) {
        this.joueurs = joueurs.getJoueurs();
    }

    @Override
    public void derouler(Themes themes) {
        Scanner sc= new Scanner(System.in);
        Themes themesPhase2 = themes.getNThemes(NOMBRE_DE_THEMES_ALEATOIRE);
        Theme themeCourant;
        System.out.print("\n-------- Début de la phase 2 ----\n" +
                "\t---- Dans cette phase chaque un des joueurs choisira deux theme, puis pour chaque theme répondera a 2 questions moyennes \n"+
                "\nfaite rentrer n'importe quel valeur pour comancer la phase : ");
        sc.nextInt();
        for(int i = 0; i < NOMBRE_DE_THEMES_ALEATOIRE; i++){
         System.out.println("-- Au tour du joueur : " + joueurs[i % 3]);
            themeCourant = Utilities.selectionnerTheme(themesPhase2);
            themeCourant.setChoisis(true);

            Questions questions = themeCourant.getQuestions();
            System.out.println("\n\t\t\t\t---Le joueur " + joueurs[i % 3] + " vas répondre a deux questions du theme : [" + themeCourant + "]");
            if(questions.askQuestion(DIFFICULTE_PHASE)){joueurs[i % 3].setScore(SCORE_AJOUTE);}
            if(questions.askQuestion(DIFFICULTE_PHASE)){joueurs[i % 3].setScore(SCORE_AJOUTE);}
        }
        for (Theme theme : themes){theme.setChoisis(false);}
        Joueurs joueurQualifiees = new Joueurs(2);
        joueurQualifiees.setJoueurs(Utilities.sortJoueursParScore(joueurs, 2));

        System.out.println("\n\t\t----- Les joueurs qualifiés a la 3eme phase sont : ");
        for (int i = 0; i < 2; i++){
            System.out.println("\t\t\t\t" + joueurQualifiees.getJoueurs()[i]);
        }
        Utilities.waitForInput("comancer la 3eme phase : ");
        Phase p3 = new Phase3();
        p3.selectionJoueurs(joueurQualifiees);
        p3.derouler(themes);
    }
}
