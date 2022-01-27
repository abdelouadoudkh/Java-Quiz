package Tests;

import main.Question;
import main.VF;

public class TestVF {
    public static void main(String arg[]){
        Question vf = new VF();
        vf.saisirQuestion();
        System.out.println(vf);
        if (vf.poserQuestion(vf)){
            System.out.println("Bonne réponse");
        }else {
            System.out.println("Mauvaise réponse");
        }
    }
}
