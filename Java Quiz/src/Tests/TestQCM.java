package Tests;

import main.QCM;
import main.Question;

public class TestQCM {
    public static void main(String arg[]){
        Question qcm = new QCM();
        qcm.saisirQuestion();
        System.out.println(qcm);
        if (qcm.poserQuestion(qcm)){
            System.out.println("Bonne réponse");
        }else {
            System.out.println("Mauvaise réponse");
        }
    }
}
