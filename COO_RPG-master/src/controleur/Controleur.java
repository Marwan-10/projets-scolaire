package controleur;

import modele.Joueur;
import modele.armure.ArmureBasique;
import modele.armure.ArmureRouille;
import modele.armure.armure;
import modele.consomable.Fromage;
import modele.consomable.Huile;
import modele.consomable.consomable;
import modele.objet;
import vue.Ihm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controleur {

    private Ihm ihm;
    protected boolean fin = false;
    protected Joueur joueur = null; // Déclarer joueur

    public String theme_rp;
    protected Fromage fromage = new Fromage();
    protected Huile huile = new Huile();

    public Controleur(Ihm i) {
        this.ihm = i;
    }

    public void choixM() {
        String theme = ihm.choixTheme();
        while (true) {
            if (theme.equals("1") || theme.equals("2")) {
                if (theme.equals("1")){
                    theme_rp = "medievale";
                } else if (theme.equals("2")) {
                    theme_rp = "steampunk";
                }
                System.out.println(theme_rp);
                break;
            }
            System.out.println("Erreur , choix possible : 1 , 2");
            theme = ihm.choixTheme();
        }
    }

    public Joueur choixPersonnage() {
        ArrayList<String> perso = ihm.CreateJoueur();


        Map<objet, Integer> inventaire = new HashMap<>();


        inventaire.put(new Fromage(), 3);

        if ("steampunk".equals(theme_rp)) { // en vrai ya pas besoin de if else

            if (perso.get(1).equals("humain") || perso.get(1).equals("cyborg") || perso.get(1).equals("automate")){
                joueur = new Joueur(perso.get(0), perso.get(1), inventaire,  0, perso.get(2), 100, 5, theme_rp);}
            else{
                System.out.println("erreur de création du personnage");
                choixPersonnage();}

        } else if ("medieval".equals(theme_rp)) {

            joueur = new Joueur(perso.get(0), perso.get(1), inventaire,  0, perso.get(2), 100, 5, theme_rp);
        }

        // Vérifier si le joueur est non null avant d'afficher les informations
        if (joueur != null) {
            // Affichage des informations du joueur
            System.out.println("Nom du joueur: " + joueur.getNom());
            System.out.println("Classe du joueur: " + joueur.getClasse());


        }

        return joueur;
    }


    public void inventaire_menu(){
        // Affichage de l'inventaire du joueur
        String reponse = ihm.menu_inventaire(joueur);


        // section miam miam
        if (reponse.equals("1")){

            if (theme_rp.equals("steampunk")){

                if (joueur.est_daslinv("Fromage")) {
                    switch (joueur.getClasse()){

                        case "humain":
                            joueur.setVie(joueur.getVie()+ fromage.getValeurNutritive());
                            System.out.println("vous récupérer de la santé vous avez :" + joueur.getVie());
                            joueur.manger(fromage, 1);
                            break;
                        case "cyborg":
                            joueur.setVie(joueur.getVie() + fromage.getValeurNutritive() / 2);
                            joueur.manger(fromage, 1);
                            System.out.println("vous récupérer de la santé vous avez :" + joueur.getVie());
                            break;
                        case "automate":
                            System.out.println("vous n'êtes pas compatible avec cette aliments");
                            break;
                    }

                }

                if (joueur.est_daslinv("Huile")) {
                    switch (joueur.getClasse()){
                        case "humain":
                            System.out.println("vous n'êtes pas compatible avec cette aliments");
                            break;
                        case "cyborg":
                            joueur.setVie(joueur.getVie() + huile.getValeurNutritive() / 2);
                            joueur.manger(huile, 1);
                            System.out.println("vous récupérer de la santé vous avez :" + joueur.getVie());
                            break;
                        case "automate":
                            joueur.setVie(joueur.getVie()+ huile.getValeurNutritive());
                            joueur.manger(huile, 1);
                            System.out.println("vous récupérer de la santé vous avez :" + joueur.getVie());
                            break;
                    }

                }

            } else {
                // theme médievale
            }

        } else if (reponse.equals("2")) { // jeter un élément de l'inventaire
            ArrayList<String> jeter_list = ihm.menu_jeter();

            for (Map.Entry<objet, Integer> entry : joueur.getInventaire().entrySet()) {
                if (entry.getKey().getNom().equals(jeter_list.get(0))){
                    joueur.inventaire_scanner(entry.getKey().getNom(), Integer.parseInt(jeter_list.get(1)));
                }
            }

        } else if (reponse.equals("3")) {  // équiper un équipement
            String equipement = ihm.menu_equipement();  //TODO tester et vérifier le système d'armure

            for (Map.Entry<objet, Integer> entry : joueur.getInventaire().entrySet()) {

                if(entry.getKey().getNom().equals(equipement)){
                    //TODO à voir pour ajouter un vérificateur si c'est une armure ou pas
                        joueur.equiperArmure((armure) entry.getKey());

                }
            }


        }else if (reponse.equals("4")) {
            String desequiper = ihm.menu_desequiper(joueur);

            for (Map.Entry<objet, Integer> entry : joueur.getInventaire().entrySet()) {

                if(entry.getKey().getNom().equals(desequiper)){
                    //TODO à voir pour ajouter un vérificateur si c'est une armure ou pas
                    joueur.desequiperArmure((armure) entry.getKey());

                }
            }

        } else {
            System.out.println("erreur lors du traitement de votre réponse");
        }
    }

    public void main_menu(){
        String action = ihm.menu_principal();

        switch (action){
            case "1":
                inventaire_menu();
                main_menu();
                break; // demander si on veut équiper ou manger ou jeter
            case "2":
                System.out.println("vous entrez dans le donjon");
                break; // à modifier

            case "3":
                fin = true;
                break;

            default:
                System.out.println("erreur lors du traitement de votre réponse");
                main_menu();
                break;

        }
    }


    public void Deroulement() {
        choixM();
        choixPersonnage();
        while (!fin){
            main_menu();
        }


    }

}
