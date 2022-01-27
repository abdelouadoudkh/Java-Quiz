public class Database {
    private Themes themes = new Themes();
    private Joueurs joueurs = new Joueurs(Joueurs.getTailleDefault());

    private final String MENU = "Que voulez vous faire : " +
            "\n\t1) Afficher les thèmes choisis" +
            "\n\t2) Créer un theme et ca liste de questions" +
            "\n\t3) Afficher toutes les questions d’un niveau donné par thème" +
            "\n\t4) Ajouter une question à la liste pour un thème donné [Work in progress]" +
            "\n\t5) Supprimer une question de numéro donné de la liste pour un thème donné [Work in progress]" +
            "\n\t6) afficher les jouers et leurs états" +
            "\n\t7) Dérouler une premiere phase " +
            "\n\t8) Quitter";

    private final String MENU_DIFFICULTE = "Choisissez le niveau de difficulté :" +
            "\n (1) facile" +
            "\n (2) moyen" +
            "\n (3) difficile";

    public Database() {
        loadData();
    }

    public void loadData(){
        Questions questionSport = new Questions();
        questionSport.add(new VF(1,false,"Sport","Rafael Nadal est un joueur de tennis",true));
        questionSport.add(new VF(1,false,"Sport","Messi est le meuilleur buteur de l'histoire",false));
        questionSport.add(new VF(1,false,"Sport","l'algerie a remporté une medaille d'or lors des jeux olympiques 2021",true));
        questionSport.add(new VF(1,false,"Sport","Sebastien Vetel est le champion du F1 2020",false));
        questionSport.add(new QCM(2, false, "Sport", "Quel tournoi du grand chelem est disputé sur gazon en juin et en juillet?","l'ATP","US Open","Wimbledon","Wimbledon"));
        questionSport.add(new QCM(2, false, "Sport", "Quelle est la distance officielle d'un marathon?","42km","42,1km","42,2km","42,2km"));
        questionSport.add(new RC(3,false,"Sport","HOCKEY : Dans la LNH, combien de minutes de punition sont données à un joueur impliqué dans une bagarre?","5"));
        questionSport.add(new RC(3,false,"Sport","BASEBALL : En 2004, les Expos de Montréal ont été relocalisés aux États-Unis. Dans quelle ville l'équipe évolue-t-elle depuis ce jour?","Washington"));
        Theme sport = new Theme(questionSport, "Sport",false);
        themes.add(sport);

        Questions questionSeries = new Questions();
        questionSeries.add(new VF(1,false,"Séries","Est ce que le personnage le plus célèbre dans la série Breaking bad est Walter White ",true));
        questionSeries.add(new VF(1,false,"Séries","Ryan Murphy a sorti au moins deux séries sur Netflix cette année",true));
        questionSeries.add(new VF(1,false,"Séries","La troisième saison d'Elite n'a pas connu la mort d'un des personnages principaux",false));
        questionSeries.add(new VF(1,false,"Séries","La série Away avec Hilary Swank n'aura pas de seconde saison sur Netflix",true));
        questionSeries.add(new QCM(2, false, "Séries", "Combien de saisons sur Prison break","1","10","5","5"));
        questionSeries.add(new QCM(2, false, "Séries", "Le psudo de Walter white est ","Pinkman","Danger","Heisunburg","Heisunburg"));
        questionSeries.add(new RC(3,false,"Séries","Le genre de la serie ELITE est ","Dramatique"));
        questionSeries.add(new RC(3,false,"Séries","Dans Riverdale, qui est vraiment le Gargoyle King ?","Chic"));
        Theme series = new Theme(questionSeries, "Séries",false);
        themes.add(series);

        Questions questionHistoire = new Questions();
        questionHistoire.add(new VF(1,false,"Histoire","La date d'indépendance du Maroc est le 7 avril 1965",true));
        questionHistoire.add(new VF(1,false,"Histoire","La date d'indépendance d' Algerie est le 5 juillet 1962",true));
        questionHistoire.add(new VF(1,false,"Histoire","La date d'indépendance du Tunisie est le 20 mars 1956",true));
        questionHistoire.add(new VF(1,false,"Histoire","La date d'indépendance de la France est le 1793",false));
        questionHistoire.add(new QCM(2, false, "Histoire", "En 1500 av. J.-C., la conquête du territoire français commence avec les.","Celtes","Tribus","arvernes","Celtes"));
        questionHistoire.add(new QCM(2, false, "Histoire", "Vercingétorix est vaincu à Alésia en 52 av. J.-C. par ","PLN","JULES César","Vikings","JULES César"));
        questionHistoire.add(new RC(3,false,"Histoire","Quel astre rythmait la vie des Gaulois et servait à compter le temps ","La lune"));
        questionHistoire.add(new RC(3,false,"Histoire","Charlemagne est couronné empereur d’Occident par le pape Léon III en l’an","800"));
        Theme histoire = new Theme(questionHistoire, "Histoire",false);
        themes.add(histoire);

        Questions questionJava = new Questions();
        questionJava.add(new VF(1,false,"Java","Java est un language compilé et interprété",true));
        questionJava.add(new VF(1,false,"Java","Java est un langage développé par James Gosling DZ",false));
        questionJava.add(new VF(1,false,"Java","Java est un langage de programmation orienté objet",true));
        questionJava.add(new VF(1,false,"Java","Java est le langage de balisage",false));
        questionJava.add(new QCM(2, false, "Java", "String en Java est","une classe","un objet","une variable","une classe"));
        questionJava.add(new QCM(2, false, "Java", "Lequel de ces opérateurs peut être utilisé pour concaténer deux ou plusieurs objets String?","+","=+","+=","+"));
        questionJava.add(new RC(3,false,"Java","Quel packages qui contient toutes les classes de collection?","java.util"));
        questionJava.add(new RC(3,false,"Java","Quelle méthode qui supprime tous les éléments d’une collection?","Clear()"));
        Theme java = new Theme(questionJava, "Java",false);
        themes.add(java);

        Questions questionFilms = new Questions();
        questionFilms.add(new VF(1,false,"films","Le film Jumanji de 1995 est une adaptation d'un livre",true));
        questionFilms.add(new VF(1,false,"films","Pirates des Caraïbes est une adaptation d'un livre",false));
        questionFilms.add(new VF(1,false,"films","La franchise Fast and Furious est une adaptation d'un livre",false));
        questionFilms.add(new VF(1,false,"films","Charlie et la Chocolaterie est une adaptation d'un livre",true));
        questionFilms.add(new QCM(2, false, "films", "Ils ont inventé le cinéma, ce sont"," les frères Trouvetout"," les frères Dalton","les frères Lumière","les frères Lumière"));
        questionFilms.add(new QCM(2, false, "films", "avant de faire des films, Georges Méliès a exercé la profession de"," meneur de revue","prestidigitateur","cosmonaute","prestidigitateur"));
        questionFilms.add(new RC(3,false,"films","le film Steamboat Willie impose définitivement un célèbre personnage","Mickey la souris"));
        questionFilms.add(new RC(3,false,"films","Le titre du film Au revoir Là haut (2017) fait allusion à une scène où","le héros pense mourir"));
        Theme films = new Theme(questionFilms, "films",false);
        themes.add(films);

        Questions questionVoiture = new Questions();
        questionVoiture.add(new VF(1,false,"voiture","Le créateur du régulateur de vitesse était aveugle",true));
        questionVoiture.add(new VF(1,false,"voiture","Le premier parcmètre a été installé à New York.",false));
        questionVoiture.add(new VF(1,false,"voiture","Michelin a inventé la chambre à air pour les pneus.",false));
        questionVoiture.add(new VF(1,false,"voiture","La marque Jaguar appartient au groupe indien TATA Motors.",true));
        questionVoiture.add(new QCM(2, false, "voiture", "Meilleur marque de voiture","Renaut","Mercedes","BMW","Mercedes"));
        questionVoiture.add(new QCM(2, false, "voiture", "À quelle vitesse peut rouler la Bugatti Veyron","345km/h","430km/h","434.2 km/h","434.211 km/h"));
        questionVoiture.add(new RC(3,false,"voiture","Combien coûte une Koenigsegg Agera R","1 336 400 €"));
        questionVoiture.add(new RC(3,false,"voiture","Combien coûte une Mercedes AMG GTS","150 000 €"));
        Theme voiture = new Theme(questionVoiture, "voiture",false);
        themes.add(voiture);

        Questions questionCulturegenerale = new Questions();
        questionCulturegenerale.add(new VF(1,false,"Culturegenerale","Canberra est la capitale de l'Australie",true));
        questionCulturegenerale.add(new VF(1,false,"Culturegenerale","La Turquie ne fait pas partie de l'Europe ?",true));
        questionCulturegenerale.add(new VF(1,false,"Culturegenerale","Descartes qui a dit : \"je pense donc je suis\" ?",true));
        questionCulturegenerale.add(new VF(1,false,"Culturegenerale","La vache en Inde est un animal est sacré",true));
        questionCulturegenerale.add(new QCM(2, false, "Culturegenerale", "Quel célèbre dictateur dirigea l’URSS du milieu des années 1920 à 1953 ","Staline","lenine","Trotski","Staline"));
        questionCulturegenerale.add(new QCM(2, false, "Culturegenerale", "Quel pays a remporté la coup du monde de football","Bresil","Algerie","Allemange","Allemange"));
        questionCulturegenerale.add(new RC(3,false,"Culturegenerale","Quel animaux peut se deplacer le plus rapidement","Le springbok"));
        questionCulturegenerale.add(new RC(3,false,"Culturegenerale","Dans quelle ville italienne l'action de la pièces de Shakespeare Romeo et Julliette se situe t elle","Verone"));
        Theme Culturegenerale = new Theme(questionCulturegenerale, "Culturegenerale",false);
        themes.add(Culturegenerale);

        Questions questionlangageSms = new Questions();
        questionlangageSms.add(new VF(1,false,"LangageSms","Cc en langage SMS est coucou",true));
        questionlangageSms.add(new VF(1,false,"LangageSms","Mdr en langage SMS est mort de rire",true));
        questionlangageSms.add(new VF(1,false,"LangageSms","Br en langage SMS est Bonjour",false));
        questionlangageSms.add(new VF(1,false,"LangageSms","Cbn en langage SMS est C'est bon",false));
        questionlangageSms.add(new QCM(2, false, "LangageSms", "Slt veut dire","Salut","Salam","Salade","Salut"));
        questionlangageSms.add(new QCM(2, false, "LangageSms", "K == ","OK","KO","Kill","OK"));
        questionlangageSms.add(new RC(3,false,"LangageSms","Bonsoir en langagesms est ","Bsr"));
        questionlangageSms.add(new RC(3,false,"LangageSms","bonne nuit est :  ","Bn8"));
        Theme LangageSms = new Theme(questionlangageSms, "LangageSms",false);
        themes.add(LangageSms);

        Questions questionJeuxvideo = new Questions();
        questionJeuxvideo.add(new VF(1,false,"jeux","Farcry est crée en 2009",false));
        questionJeuxvideo.add(new VF(1,false,"jeux","Rainbow 6 siege est le meilleur jeux de l'année",true));
        questionJeuxvideo.add(new VF(1,false,"jeux","FIFA 2022 est sorti ",true));
        questionJeuxvideo.add(new VF(1,false,"jeux","Ubisoft qui a crée Farcry",true));
        questionJeuxvideo.add(new QCM(2, false, "jeux", "Pupg est un jeux  ","Mobile","Console","Les deux","Les deux"));
        questionJeuxvideo.add(new QCM(2, false, "jeux", "uncharted est sur ","xbox","PS4","les deux","PS4"));
        questionJeuxvideo.add(new RC(3,false,"jeux","La date de sortie GTA5 est ","2013"));
        questionJeuxvideo.add(new RC(3,false,"jeux","Les mise a jour sont sur GTA5 sont chaque ","Lundi"));
        Theme jeux = new Theme(questionJeuxvideo, "jeux",false);
        themes.add(jeux);

        Questions questionCodeDeLaRoute = new Questions();
        questionCodeDeLaRoute.add(new VF(1,false,"Code de la route","Sur autoroute, la vitesse minimale imposée sur la file la plus à gauche est de 80km",true));
        questionCodeDeLaRoute.add(new VF(1,false,"Code de la route","Le temps de réaction est d'environ 1 seconde",true));
        questionCodeDeLaRoute.add(new VF(1,false,"Code de la route","L’ABS permet de réduire les distances de sécurité",false));
        questionCodeDeLaRoute.add(new VF(1,false,"Code de la route","Les véhicules taxis sont soumis à une visite technique qui doit être renouvelée tous les 3 ans",false));
        questionCodeDeLaRoute.add(new QCM(2, false, "Code de la route", "La distance entre deux voiture est ","70 m","80 m ","100 m ","70 m "));
        questionCodeDeLaRoute.add(new QCM(2, false, "Code de la route", "La vitesse max sur l 'autoroute est ","130km/h","100mk/h","128km/h","130km/h"));
        questionCodeDeLaRoute.add(new RC(3,false,"Question RC sport","Pour dépasser un cycliste en agglomération, je dois laisser un intervalle d’au moins","1 mètre"));
        questionCodeDeLaRoute.add(new RC(3,false,"Question RC sport","Je circule alors que mon permis est annulé, quelles sont les peines prévues par le code de la route","4 500 € d’amende au maximum"));
        Theme codeDeLaRoute = new Theme(questionCodeDeLaRoute, "Code de la route",false);
        themes.add(codeDeLaRoute);

        for(char c = 'A'; c <= 'T'; ++c){
            joueurs.add(new Joueur(0,EtatJoueur.en_attente,Character.toString(c)));
        }
    }

    public Themes getThemes() {
        return themes;
    }

    public Joueurs getJoueurs() {
        return joueurs;
    }

    public String getMENU() {
        return MENU;
    }

    public String getMENU_DIFFICULTE() {
        return MENU_DIFFICULTE;
    }
}
