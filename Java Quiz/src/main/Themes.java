package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Themes implements Iterable<Theme>{
    private List<Theme> themes;

    public Themes() {
        themes = new ArrayList<>();
    }

    public Themes(ArrayList<Theme> themes){
        this.themes = themes;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void add(Theme theme){
        themes.add(theme);
    }

    public void saisirTheme(){
        Theme newTheme = new Theme();
        Scanner sc = new Scanner(System.in);
        System.out.print("Debut de la saisie du nouveau theme : \n\tDonner le nom du nouveau theme : ");
        newTheme.setTheme(sc.nextLine());
        Questions questions = new Questions();
        int choix = 1;
        while(choix != 4){
            System.out.print("\tQue faire : " +
                    "\n\t\t(1) ajouter une question VF au theme " + newTheme.getTheme() +
                    "\n\t\t(2) ajouter une question QCM au theme " + newTheme.getTheme() +
                    "\n\t\t(3) ajouter une question RC au theme " + newTheme.getTheme() +
                    "\n\t\t(4) fin de saisie" +
                    "\n\n\t  Votre choix : ");
            choix = sc.nextInt();
            if(choix < 1 || choix > 4){
                do {
                    System.out.print("choix invalide : ");
                    choix = sc.nextInt();
                }while (choix < 1 || choix > 4);
            }
            Question question = null;
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
            if (choix != 4){
                question.saisirQuestion();
                questions.add(question);
            }
        }
        newTheme.setQuestions(questions);
        themes.add(newTheme);
    }

    public int getThemeIndex(String theme){
        for(int i = 0; i < themes.size(); i++){
            if (themes.get(i).getTheme() == theme){
                return i;
            }
        }
            System.out.println("theme ne figure pas dans la liste des themes");
            return -1;
    }

    public Theme getRandomTheme(){
        int randIndex = (int)Math.floor(Math.random()*(themes.size()));
        while (themes.get(randIndex).isChoisis()){
            randIndex = (int)Math.floor(Math.random()*(themes.size()));
        }
        themes.get(randIndex).setChoisis(true);
        return themes.get(randIndex);
    }

    public Themes getNThemes(int n){
        ArrayList<Theme> randomNThemes = new ArrayList<>();
        for (int i = 0; i < n; i++){
            randomNThemes.add(getRandomTheme());
        }
        for (Theme theme : themes){theme.setChoisis(false);}
        Themes resultNThemes = new Themes();
        resultNThemes.setThemes(randomNThemes);
        return resultNThemes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < themes.size(); i++){
            result += "\t[" + i + "] " + themes.get(i).getTheme() + "\n";
        }
        return result;
    }
    @Override
    public Iterator<Theme> iterator() {
        return themes.iterator();
    }
}

