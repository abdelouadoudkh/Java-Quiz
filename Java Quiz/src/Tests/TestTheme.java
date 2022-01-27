package Tests;

import main.*;

public class TestTheme {
    public static void main(String arg[]){
        Question qcm = new QCM(2, false, "Sport", "Question QCM Sport 2","Reponse 2 QCM Sport 1","Reponse 2 QCM Sport 2","Reponse 2 QCM Sport 3","Reponse 2 QCM Sport 2");
        Question vf = new VF(1,false,"Sport","Rafael Nadal est un joueur de tennis",true);
        Question rc = new RC(3,false,"Sport","Question RC sport 2","Sport2");
        Questions questions = new Questions();
        questions.add(qcm);
        questions.add(vf);
        questions.add(rc);
        Theme testTheme1 = new Theme(questions,"theme de test", false);
        Theme testTheme2 = new Theme();
        testTheme2.setTheme("theme de test2");
        testTheme2.addQuestion(new VF(1,false,"Sport","Rafael Nadal est un joueur de tennis",true));

        for (int difficulte = 1 ; difficulte < 4; difficulte++){
            System.out.println(testTheme1.toString(difficulte));
        }
        Utilities.waitForInput("continuer : ");
        try{
            for (int difficulte = 1 ; difficulte < 4; difficulte++){
                    System.out.println(testTheme2.toString(difficulte));
            }
        }catch (NullPointerException e){
            System.out.println("null pointer exception");
        }

    }
}
