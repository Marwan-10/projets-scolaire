package vue;

import modele.GenerateurDonjon.GenerateurDonjon;
import modele.Joueur;
import modele.arme.arme;
import modele.armure.armure;
import modele.objet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Ihm {

    public String choixTheme () {
        System.out.println("Les thèmes proposé actuelement sont médievale 1 et Steampunk 2");
        Scanner sc = new Scanner(System.in);
        String mot = sc.next();
        return mot;
    }

    public ArrayList<String> CreateJoueur() {

        ArrayList<String> data_joueur = new ArrayList<String>();

        GenerateurDonjon.genererDonjon(10, 20); //TODO à virer c'est du test

        Scanner scanner = new Scanner(System.in);

        // Demander les informations du joueur
        System.out.print("Entrez le nom du joueur: ");
        String nom = scanner.nextLine();

        System.out.print("Entrez la classe du joueur: ");
        String classe = scanner.nextLine();

        System.out.print("Entrez la race du joueur: (le scénario steampunk n'est pas influencé)");
        String race = scanner.nextLine();

        data_joueur.add(nom);
        data_joueur.add(classe);
        data_joueur.add(race);

        return data_joueur;

    }

    public String menu_principal(){
        System.out.println("que voulez vous faire : ");
        System.out.println("   1) ouvrir votre inventaire: ");
        System.out.println("   2) entrer dans le donjon");
        System.out.println("   3) mettre fin à la partie");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        return action;

    }


    public String menu_inventaire(Joueur joueur) {
        System.out.println("Inventaire du joueur:");
        int index = 1; // Début de l'index à 1

        for (Map.Entry<objet, Integer> entry : joueur.getInventaire().entrySet()) {
            System.out.println(index + ". " + entry.getKey().getNom() + ": " + entry.getValue());
            index++;
        }

        System.out.println("que voulez vous faire : ");
        System.out.println("   1) manger ");
        System.out.println("   2) jeter un élément");
        System.out.println("   3) s'équiper");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        return action;
    }

    public ArrayList<String> menu_jeter(){
        ArrayList<String> suppresseur = new ArrayList<String>();


        System.out.println("quel item vous vous jeter (nom complet pas d'id):");
        Scanner scanner = new Scanner(System.in);
        String id_item = scanner.nextLine();

        System.out.println("quel nombre de cette élément voulait vous jeter :");
        scanner = new Scanner(System.in);
        String nb_item = scanner.nextLine();

        suppresseur.add(id_item);
        suppresseur.add(nb_item);

        return suppresseur;

    }

    public String menu_equipement(){

        System.out.println("quel item vous vous équiper id:");
        Scanner scanner = new Scanner(System.in);
        String nom_item = scanner.nextLine();

        return nom_item;

    }

    public String menu_desequiper(Joueur joueur){

        for (int i = 0; i < 4; i++) { // 0 = casque 1 = plastron, 2 = jambière, 4 = botte

            armure armure = joueur.getEquipement_porter().get(i);

            System.out.println("nom: " + armure.getNom() +" valeur défensive" + armure.getValeurDefense());
        }
        for (int i = 0; i < 2; i++) { // 0 = casque 1 = plastron, 2 = jambière, 4 = botte

            arme arme = joueur.getArme_porter().get(i);
            System.out.println("nom: " + arme.getNom() +" nécessite des munition :" + arme.isBesoinmunition());
        }


        System.out.println("quel item vous vous déséquiper (nom complet pas d'id):");
        Scanner scanner = new Scanner(System.in);
        String nom_item = scanner.nextLine();

        return nom_item;

    }




}
