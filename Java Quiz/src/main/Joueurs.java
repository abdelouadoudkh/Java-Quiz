package main;

public class Joueurs {
    private final static int TAILLE_DEFAULT = 20;
    private Joueur joueurs[];
    private int size;
    private int index;

    public Joueurs(int size) {
        joueurs = new Joueur[size];
        this.size = size;
        index = 0;
    }
    public void add(Joueur joueur){
        if(index<size) {
            joueurs[index] = joueur;
            index++;
        }else System.out.println("nombre max de joueurs atteint");
    }
    public static int getTailleDefault(){
        return TAILLE_DEFAULT;
    }
    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Joueur[] joueurs) {
        this.joueurs = new Joueur[joueurs.length];
        for (int i = 0; i < joueurs.length; i++){
            this.joueurs[i] = joueurs[i];
            System.out.println(joueurs);
        }
        size = joueurs.length;
        index = 0;
    }

    public int getSize() {
        return size;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i<index;i++){
            result += joueurs[i] + "\n";
        }
        return result;
    }
}
