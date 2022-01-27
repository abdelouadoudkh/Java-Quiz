package Tests;

import main.Themes;
import main.Utilities;

public class TestThemes {
    public static void main(String arg[]){
        Themes themes = new Themes();
        themes.saisirTheme();
        themes.saisirTheme();
        themes.saisirTheme();
        System.out.println(themes.getThemeIndex("test"));
        Utilities.waitForInput("tester getRandomtheme qui retourne un theme aléatoirement  : ");
        System.out.println(themes.getRandomTheme());
        Utilities.waitForInput("tester getNthemes qui retourne une liste de N themes aléatoirement  : ");
        System.out.println(themes.getNThemes(2));
        Utilities.waitForInput("afficher tout les themes : ");
        System.out.println(themes);
    }
}
