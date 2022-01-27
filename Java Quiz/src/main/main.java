package main;

import java.util.Scanner;

public class main {
    public static void main(String arg[]){
        Database db = new Database();
        Themes themes = db.getThemes();
        Joueurs joueurs = db.getJoueurs();

        final String MENU = db.getMENU();
        final String CHOIX_DIFF = db.getMENU_DIFFICULTE();

        Scanner sc = new Scanner(System.in);
        int choix = 1;
        int choixTheme;
        Question question = null;
        Theme theme = null;
        while (choix > 0 && choix < 9 ){
            do {
                System.out.println(MENU);
                System.out.print("\t\t Votre choix : ");
                choix = sc.nextInt();
                if (choix < 1 || choix > 8) System.out.println("\n\t\t\t[ Veillez effectuer un choix valide! ]\n");
            }while(choix < 1 || choix > 8);
            if(choix != 8){
                switch (choix){
                    case 1:
                        System.out.print(themes.toString());
                        Utilities.waitForInput("continuer : ");
                        break;




                        case 2:
                        themes.saisirTheme();
                        break;




                        case 3:
                        System.out.println("Choisissez le theme parmis : \n" + themes.toString());
                        System.out.print("\t Votre choix : ");

                        do {
                            choixTheme = sc.nextInt();
                        }while (choixTheme < 0 || choixTheme >= themes.getThemes().size());
                        System.out.println(CHOIX_DIFF);
                        System.out.print("\t Votre choix : ");
                        int choixDifficulte;
                        do {
                            choixDifficulte = sc.nextInt();
                        }while (choixDifficulte < 1 || choixDifficulte > 3);
                        System.out.println(themes.getThemes().get(choixTheme).toString(choixDifficulte));
                        Utilities.waitForInput("continuer : ");
                        break;




                        case 4:
                        System.out.println("Choisissez le theme parmis : \n" + themes.toString());
                        System.out.print("\t Votre choix : ");
                        do {
                            choixTheme = sc.nextInt();
                        }while (choixTheme < 0 || choixTheme >= themes.getThemes().size());
                            System.out.print("\tQue faire : " +
                                    "\n\t\t(1) ajouter une question main.VF au theme " + themes.getThemes().get(choixTheme) +
                                    "\n\t\t(2) ajouter une question main.QCM au theme " + themes.getThemes().get(choixTheme) +
                                    "\n\t\t(3) ajouter une question main.RC au theme " + themes.getThemes().get(choixTheme) +
                                    "\n\n\t  Votre choix : ");
                            choix = sc.nextInt();
                            if(choix < 1 || choix > 3){
                                do {
                                    System.out.print("choix invalide : ");
                                    choix = sc.nextInt();
                                }while (choix < 1 || choix > 3);
                            }
                            switch (choix){
                                case 1:
                                    question = new VF();
                                    break;
                                case 2:
                                    question = new QCM();
                                    break;
                                case 3:
                                    question = new RC();
                                    break;
                                default:break;
                            }
                            question.saisirQuestion();
                            themes.getThemes().get(choixTheme).addQuestion(question);
                        System.out.println("la question : " + question + "\n ajouté avec succes");
                        break;



                        case 5:
                            int numQst;
                        System.out.println("donner le numero de la question a suprimer : \n");
                        System.out.print("\t Votre choix : ");
                        do {
                            numQst = sc.nextInt();
                        }while (numQst < 0);
                            for (Theme theme1 : themes){
                                for (Question question1 : theme1){
                                    if (question1.numQst == numQst){
                                        System.out.print("suprimer du theme " + theme1 + " la question : \n" + question1 + "\n (1) oui (2) non" +
                                                "\n\t Votre choix : ");
                                        do {
                                            choix = sc.nextInt();
                                            if(choix != 1 && choix != 2) System.out.println("Veillez effectuer un choix valide : ");
                                        }while (choix != 1 && choix != 2);
                                        if (choix == 1){
                                            theme1.getQuestions().getQuestions().remove(theme1.getQuestions().getQuestions().indexOf(question1));
                                            System.out.println("main.Question " + numQst + " suprimé avec succes!");
                                            Utilities.waitForInput("continuer : ");
                                        }
                                        break;
                                    }
                                }
                                if (question != null && question.numQst == numQst){break;}
                            }
                            if (question != null && question.numQst == numQst){break;}
                            System.out.println("numero de question invalide.");
                        break;




                        case 6:
                        System.out.println(joueurs.toString());
                        Utilities.waitForInput("continuer : ");
                        break;



                        case 7:
                        Phase p1 = new Phase1();
                        p1.selectionJoueurs(joueurs);
                        p1.derouler(themes);
                        break;
                }
            }else {
                sc.close();
                System.out.println("Fin du programme");
                choix = 0;
            }
        }
    }
}
