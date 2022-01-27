package main;

import java.util.Iterator;

public class Theme implements Iterable<Question> {
    private Questions questions;
    private String theme;
    private boolean choisis;

    public Theme(Questions questions, String theme, boolean choisis) {
        this.questions = questions;
        this.theme = theme;
        this.choisis = choisis;
    }
    public Theme(){
        this.questions = new Questions();
        choisis = false;
    }
    public void addQuestion(Question question){questions.add(question);}
    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isChoisis() {
        return choisis;
    }

    public void setChoisis(boolean choisis) {
        this.choisis = choisis;
    }
    @Override
    public String toString(){
        return theme;
    }
    public String toString(int choix){
        String result = "Les question de niveau " + choix + " du theme " + theme + " sont : \n";
        for (Question question : questions.getQuestions()){
            if(question.getDifficulté() == choix){
                result += "\n"+question.toString();
            }
        }
        return result;
    }
    @Override
    public Iterator<Question> iterator() {
        return questions.getQuestions().iterator();
    }
}
