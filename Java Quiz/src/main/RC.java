package main;

import java.util.Scanner;

public class RC extends Question{
    private String reponseC;

    public RC(int difficulté, boolean choisi, String theme, String text, String reponseC) {
        super(difficulté, choisi, theme, text);
        this.reponseC = reponseC;
    }

    public RC() {
        this(0, false, "", "", "");
    }

    public boolean poserQuestion(Question question){
        RC questionRC = (RC) question;
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\t Votre réponse : ");
        String choix = sc.nextLine();
        if(reponseC.equals(choix))return true;
        return false;
    }

    @Override
    public void saisirQuestion() {
        super.setChoisi(false);
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tDebut de la saisie de question RC de Numéro : " + numQst);
        System.out.print("\t\t\t Donner un text a la question : ");
        super.setText(sc.nextLine());
        System.out.print("\t\t\t Donner une difficulté a la question (1 : Facile / 2 : Moyenne / 3 : Difficile): ");
        int choix;
        do {
            choix = sc.nextInt();
            if(choix < 1 || choix > 3) System.out.println("Veillez effectuer un choix valide : ");
        }while (choix < 1 || choix > 3);
        super.setDifficulté(choix);

        System.out.print("\t\t\t Veillez saisir la réponse Correct : ");
        sc.nextLine();
        reponseC = sc.nextLine();
    }
    @Override
    public String toString(){
        return super.toString() + " Type de question : Reponse Courte";
    }
}
