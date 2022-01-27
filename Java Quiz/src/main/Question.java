package main;

public abstract class Question {
    private static int numSequenciel = 0;
    protected int numQst;
    private int difficulté;
    private boolean choisi;
    private String text;

    public Question(int difficulté, boolean choisi, String theme, String text) {
        this.numQst = numSequenciel;
        numSequenciel++;
        this.difficulté = difficulté;
        this.choisi = choisi;
        this.text = text;
    }

    public Question() {
        this(0,false,"","");
    }

    public int getDifficulté() {
        return difficulté;
    }

    public void setDifficulté(int difficulté) {
        this.difficulté = difficulté;
    }

    public boolean isChoisi() {
        return choisi;
    }

    public void setChoisi(boolean choisi) {
        this.choisi = choisi;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void saisirQuestion();

    public abstract boolean poserQuestion(Question question);

    @Override
    public String toString(){
        return "Question N°" + numQst + "\n\t Difficulté : " + difficulté + "\n\t Text : " + text;
    }
}
