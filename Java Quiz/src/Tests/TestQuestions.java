package Tests;

import main.*;

public class TestQuestions {
    public static void main(String arg[]){
        Question qcm = new QCM(2, false, "Sport", "Question QCM Sport 2","Reponse 2 QCM Sport 1","Reponse 2 QCM Sport 2","Reponse 2 QCM Sport 3","Reponse 2 QCM Sport 2");
        Question vf = new VF(1,false,"Sport","Rafael Nadal est un joueur de tennis",true);
        Question rc = new RC(3,false,"Sport","Question RC sport 2","Sport2");
        Questions questions = new Questions();
        questions.add(qcm);
        questions.add(vf);
        questions.add(rc);
        System.out.println(questions);
        Utilities.waitForInput("continuer : ");
        Question qst = null;
        if(questions.askQuestion(1)) System.out.println("Bonne réponse");
        else System.out.println("Mauvaise réponse");
        if(questions.askQuestion(2)) System.out.println("Bonne réponse");
        else System.out.println("Mauvaise réponse");
        if(questions.askQuestion(3)) System.out.println("Bonne réponse");
        else System.out.println("Mauvaise réponse");
    }
}
