package Tests;

import main.Question;
import main.RC;

public class TestRC {
    public static void main(String arg[]){
        Question rc = new RC();
        rc.saisirQuestion();
        System.out.println(rc);
        if (rc.poserQuestion(rc)){
            System.out.println("Bonne réponse");
        }else {
            System.out.println("Mauvaise réponse");
        }
    }
}
