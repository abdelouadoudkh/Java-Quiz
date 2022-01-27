package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Questions implements Iterable<Question>{
    private List<Question> questions;
    public Questions() {
        questions = new LinkedList<>();
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public void add(Question question){
        questions.add(question);
    }

    public boolean askQuestion(int difficultePhase){
        int randIndex = (int)Math.floor(Math.random()*(questions.size()));
        //nous cherchons une question aléatoire qui a la difficulté passé en parametre et qui n'a jamais été posé
        while(questions.get(randIndex).getDifficulté() !=difficultePhase || questions.get(randIndex).isChoisi() != false){
                randIndex = (int)Math.floor(Math.random()*(questions.size()));
            }
        //l'état de la question change
        questions.get(randIndex).setChoisi(true);
        System.out.println(questions.get(randIndex));
        //nous utilisons la méthode poserQuestion pour poser la question d'une maniere spécifique au type de la question
        if(questions.get(randIndex) instanceof VF){
            return (questions.get(randIndex)).poserQuestion((VF)(questions.get(randIndex)));
        }else if (questions.get(randIndex) instanceof QCM){
            return (questions.get(randIndex)).poserQuestion(((QCM)questions.get(randIndex)));
        }else if (questions.get(randIndex) instanceof RC){
            return (questions.get(randIndex)).poserQuestion(((RC)questions.get(randIndex)));
        }
        return false;
    }
    public Iterator<Question> iterator() {
        return questions.iterator();
    }
    @Override
    public String toString(){
        String result = " Questions : \n";
        for(Question question : questions){
            result += question + "\n";
        }
        return result;
    }
}
