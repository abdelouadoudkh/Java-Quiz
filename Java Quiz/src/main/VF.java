package main;

import java.util.Scanner;

public class VF extends Question{
    private boolean vrai;

    public VF(int difficulté, boolean choisi, String theme, String text, boolean vrai) {
        super(difficulté, choisi, theme, text);
        this.vrai = vrai;
    }
    public VF(){this(0,false,"","",false);}

    public boolean poserQuestion(Question question){
        Scanner sc = new Scanner(System.in);
        VF questionVF = (VF) question;
        System.out.print("\t\t(1) Vrai  (2) Faux\n\t\t Votre choix : ");
        int choix = sc.nextInt();
        while(choix < 1 || choix > 2) {
            System.out.print("Veuillez effectuer un choix valide (sois 1 ou bien 2) : ");
            choix = sc.nextInt();
        }
        switch (choix){
            case 1:
                if (questionVF.isVrai())return true;
                return false;
            case 2:
                if (questionVF.isVrai())return false;
                return true;
        }
        return false;
    }
    public VF(boolean vrai) {
        this(0,false,"","",false);
    }

    public boolean isVrai() {
        return vrai;
    }

    public void setVrai(boolean vrai) {
        this.vrai = vrai;
    }

    @Override
    public void saisirQuestion() {
        super.setChoisi(false);
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tDebut de la saisie de question VF de Numéro : " + numQst);
        System.out.print("\t\t\t Donner un text a la question : ");
        super.setText(sc.nextLine());
        System.out.print("\t\t\t Donner une difficulté a la question (1 : Facile / 2 : Moyenne / 3 : Difficile): ");
        int choix;
        do {
            choix = sc.nextInt();
            if(choix < 1 || choix > 3) System.out.println("Veillez effectuer un choix valide : ");
        }while (choix < 1 || choix > 3);
        super.setDifficulté(choix);
        System.out.print("\t\t\t La réponse a cette question est : \n\t\t\t\t(1) Vrai   (2) Faux\n\t\t\t\tVotre Choix : ");
        do {
            choix = sc.nextInt();
            if(choix != 1 && choix != 2) System.out.println("Veillez effectuer un choix valide : ");
        }while (choix != 1 && choix != 2);
    }
    @Override
    public String toString(){
        return "Type de question : Vrai ou Faux \n" + super.toString();
    }
}
