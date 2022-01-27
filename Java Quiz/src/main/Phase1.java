package main;

import java.util.Scanner;

public class Phase1 implements Phase{
    private static final int DIFFICULTE_PHASE = 1;
    private final static int SCORE_AJOUTE = 2;
    private Joueur[] joueurs=new Joueur[4];
    @Override
    //Sélection de 4 joueurs parmis 20 d'une maniere aléatoire
    public void selectionJoueurs(Joueurs joueursMain) {
        Joueur[] joueursTemp = joueursMain.getJoueurs();
        int randIndex = (int)Math.floor(Math.random()*(Joueurs.getTailleDefault()));
        for(int i = 0; i < 4; i++){
            //recherche d'un joueur aléatoire qui a l'etat en_attente
            while(joueursTemp[randIndex].getEtat() != EtatJoueur.en_attente){
                randIndex = (int)Math.floor(Math.random()*(Joueurs.getTailleDefault()));
            }
            joueursTemp[randIndex].setEtat(EtatJoueur.selectione);
            //sauvgarde du joueur
            joueurs[i] = joueursTemp[randIndex];
        }
    }

    @Override
    public void derouler(Themes themes) {
        Scanner sc= new Scanner(System.in);
        System.out.print("\n-------- Début de la phase 1 ----\n" +
                "\t---- Dans cette phase chaque un des joueurs répondera a une seul question facile de chaque un des themes suivants : \n" + themes +
                "\nfaite rentrer n'importe quel valeur pour comancer le jeu : ");
        sc.nextInt();
        for(Theme theme : themes){
            theme.setChoisis(true);
            Questions questions = theme.getQuestions();
            System.out.println("\n\t\t\t\t--- Chargement du theme : [" + theme + "]");
            for(int i = 0; i < 4; i++){
                System.out.println("-- Au tour du joueur : " + joueurs[i]);
                if(questions.askQuestion(DIFFICULTE_PHASE)){
                    joueurs[i].setScore(SCORE_AJOUTE);
                }
            }
        }

        for (Theme theme : themes){theme.setChoisis(false);}
        Joueurs joueurQualifiees = new Joueurs(3);
        joueurQualifiees.setJoueurs(Utilities.sortJoueursParScore(joueurs, 3));

        System.out.println("\n\t\t----- Les joueurs qualifiés a la 2eme phase sont : ");
        for (int i = 0; i < 3; i++){
            System.out.println("\t\t\t\t" + joueurQualifiees.getJoueurs()[i]);
        }
        Utilities.waitForInput("comancer la 2eme phase : ");

        Phase p2 = new Phase2();
        p2.selectionJoueurs(joueurQualifiees);
        p2.derouler(themes);
    }
}
