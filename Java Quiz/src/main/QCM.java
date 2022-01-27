package main;

import java.util.Scanner;

public class QCM extends Question{
    private String reponse1;
    private String reponse2;
    private String reponse3;
    private String reponseC;

    public QCM(int difficulté, boolean choisi, String theme, String text, String reponse1, String reponse2, String reponse3, String reponseC) {
        super(difficulté, choisi, theme, text);
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponseC = reponseC;
    }

    public QCM() {
        this(0,false,"","","","","","");
    }


    public boolean poserQuestion(Question question){
        QCM questionQCM = (QCM) question;
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\t Votre choix : ");
        int choix = sc.nextInt();
        while(choix < 1 || choix > 3) {
            System.out.print("Veuillez effectuer un choix valide (entre 1 et 3) : ");
            choix = sc.nextInt();
        }
        switch (choix){
            case 1:
                if (questionQCM.reponseC.equals(reponse1))return true;
                return false;
            case 2:
                if (questionQCM.reponseC.equals(reponse2))return true;
                return false;
            case 3 :
                if (questionQCM.reponseC.equals(reponse3))return true;
                return false;
        }
        return false;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public String getReponseC() {
        return reponseC;
    }

    public void setReponseC(String reponseC) {
        this.reponseC = reponseC;
    }

    @Override
    public void saisirQuestion() {
        super.setChoisi(false);
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tDebut de la saisie de question QCM de Numéro : " + numQst);
        System.out.print("\t\t\t Donner un text a la question : ");
        super.setText(sc.nextLine());
        System.out.print("\t\t\t Donner une difficulté a la question (1 : Facile / 2 : Moyenne / 3 : Difficile): ");
        int choix;
        do {
            choix = sc.nextInt();
            if(choix < 1 || choix > 3) System.out.println("Veillez effectuer un choix valide : ");
        }while (choix < 1 || choix > 3);
        super.setDifficulté(choix);
        System.out.print("\t\t\t Veillez saisir la réponse N°1 : ");
        sc.nextLine();
        reponse1 = sc.nextLine();
        System.out.print("\t\t\t Veillez saisir la réponse N°2 : ");
        reponse2 = sc.nextLine();
        System.out.print("\t\t\t Veillez saisir la réponse N°3 : ");
        reponse3 = sc.nextLine();
        System.out.print("\t\t\t Veillez saisir la réponse Correct : ");
        reponseC = sc.nextLine();

    }
    @Override
    public String toString(){
        return super.toString() + "\n\tType de question : QCM \n\t réponses aux choix : " +
                "\n\t\t(1) " + reponse1 +
                "\n\t\t(2) " + reponse2 +
                "\n\t\t(3) " + reponse3 ;
    }
}
