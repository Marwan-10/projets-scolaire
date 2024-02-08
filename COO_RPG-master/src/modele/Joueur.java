package modele;

import modele.arme.arme;
import modele.armure.armure;
import modele.consomable.consomable;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Joueur {

    private String race;
    private String nom;
    private classe classe;
    private Map<objet, Integer> inventaire; // Utilisation d'une HashMap pour l'inventaire
    private int defense;
    private int offense;
    private int experience;

    private ArrayList<armure> equipement_porter = new ArrayList<>(); // représente les pièce d'armure ( 4 slot )
    private ArrayList<arme> arme_porter = new ArrayList<>(); // représenter par 2 slot

    private int vie;


    // Constructeur
    public Joueur(String nom, String classe, Map<objet, Integer> inventaire, int defense, String race, int experience, int vie, String theme) {

        classe classe_joueur = new classe(classe, theme);
        this.classe = classe_joueur;
        this.nom = nom;
        this.inventaire = inventaire;
        this.defense = defense;
        this.race = race;
        this.experience = experience;
        this.vie = classe_joueur.getConstitution() * vie;
        this.offense = classe_joueur.getForce();

        for (int i = 0; i < 4; i++) { // 0 = casque 1 = plastron, 2 = jambière, 3 = botte
            equipement_porter.add(new armure("", 0, ""));
        }

        arme_porter.add(new arme("main", offense, false, 0, 1, ""));
        arme_porter.add(new arme("", 0, false, 0, 1, ""));


    }

    // Méthodes getters et setters

    public String getNom() {
        return nom;
    }


    public String getClasse() {
        return this.classe.getNom_classe();
    }
    public classe getvclasse() { return this.classe;}


    public Map<objet, Integer> getInventaire() {
        return inventaire;
    }
    public void setInventaire(Map<objet, Integer> inventaire) {
        this.inventaire = inventaire;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getVie(){
        return vie;
    }

    public boolean est_daslinv(String nom){
        for (Map.Entry<objet, Integer> entry : this.getInventaire().entrySet()) {
            if (entry.getKey().getNom().equals(nom)){
                return true;
            }
        }
        return false;
    }


    public void inventaire_scanner(String nom, int nombre) {
        Map<objet, Integer> inventaire = this.getInventaire();
        for (Map.Entry<objet, Integer> entry : this.getInventaire().entrySet()) {
            objet objet = entry.getKey();

            if (objet.getNom().equals(nom)) {
                // Si la clé correspond au nom spécifié
                int oldValue = entry.getValue();
                int newValue = oldValue - nombre;

                if (newValue <= 0) {
                    // Si la nouvelle valeur est 0 ou inférieure, retire la clé de l'inventaire
                    inventaire.remove(objet);
                    System.out.println("L'objet '" + objet.getNom() + "' a été retiré de l'inventaire.");
                } else {
                    // Sinon, met à jour la valeur dans l'inventaire
                    inventaire.put(objet, newValue);
                    System.out.println(nombre + " " + objet.getNom() + "(s) ont été retiré(s) de l'inventaire.");
                }
                this.setInventaire(inventaire);
                // Arrête la boucle après avoir traité la clé spécifiée
                break;
            }
        }
    }

    public void add_inventaire(objet item, int nombre) {
        Map<objet, Integer> inventaire = this.getInventaire();

        // Vérifier si l'objet est déjà dans l'inventaire
        if (inventaire.containsKey(item)) {
            int oldValue = inventaire.get(item);
            int newValue = oldValue + nombre;

            inventaire.put(item, newValue);
            System.out.println(nombre + " " + item.getNom() + "(s) ont été ajouté(s) à l'inventaire.");
        } else {
            // Si l'objet n'est pas dans l'inventaire, l'ajouter
            inventaire.put(item, nombre);
            System.out.println(nombre + " " + item.getNom() + "(s) ont été ajouté(s) à l'inventaire.");
        }

        this.setInventaire(inventaire);
    }


    public void manger(consomable aliment, int quantite) { // à déplacer dans la classe joueur
        if (aliment.estMangeablePar(this)) {
            inventaire_scanner(aliment.getNom(), quantite);
            System.out.println("Vous avez mangé " + quantite + " " + aliment.getNom() + ".");
        } else {
            System.out.println("Vous ne pouvez pas manger cet aliment avec votre classe de joueur.");
        }
    }


    public void equiperArmure(armure armure) {
        System.out.println("Vous vous êtes équipé de l'armure : " + armure.getNom());
        this.inventaire_scanner(armure.getNom(), 1);
        switch (armure.getType()){

            case "casque":
                equipement_porter.set(0, armure);
                break;
            case "plastron":
                equipement_porter.set(1, armure);
                break;
            case "jambiere":
                equipement_porter.set(2, armure);
                break;
            case "botte":
                equipement_porter.set(3, armure);
                break;

        }

        System.out.println("Valeur de défense des armures :");
        int total = 0;
        for (armure armor : equipement_porter) {
            System.out.println(armor.getNom() + ": " + armor.getValeurDefense());
            total += armor.getValeurDefense();
        }
        this.defense = total;


    }

    public void desequiperArmure(armure armure) {
        System.out.println("Vous vous êtes déséquipé de l'armure : " + armure.getNom());
        this.add_inventaire(armure, 1);
        switch (armure.getType()){

            case "casque":
                equipement_porter.set(0, new armure("", 0, ""));
                break;
            case "plastron":
                equipement_porter.set(1, new armure("", 0, ""));
                break;
            case "jambiere":
                equipement_porter.set(2, new armure("", 0, ""));
                break;
            case "botte":
                equipement_porter.set(3, new armure("", 0, ""));
                break;

        }

        int total = 0;
        System.out.println("Valeur de défense des armures :");
        for (armure armor : equipement_porter) {
            System.out.println(armor.getNom() + " : " + armor.getValeurDefense());
            total += armor.getValeurDefense();
        }
        this.defense = total;


    }

    public void equiperarme(arme arme, int position){ // la position représente la main droite 0 ou gauche 1
        System.out.println("Vous vous êtes équipé de l'arme : " + arme.getNom());
        this.inventaire_scanner(arme.getNom(), 1);

        switch (position){
            case 0:
                arme_porter.set(0,arme);
                break;
            case 1:
                arme_porter.set(1,arme);
                break;
        }

    }

    public void desequiperarme(arme arme, int position){ // la position représente la main droite 0 ou gauche 1
        System.out.println("Vous vous êtes déséquipé de l'arme : " + arme.getNom());
        this.add_inventaire(arme, 1);

        switch (position){
            case 0:
                arme_porter.set(0,new arme("main", offense, false, 0, 1, ""));
                break;
            case 1:
                arme_porter.set(1,new arme("", 0, false, 0, 1, ""));
                break;
        }

    }

    public ArrayList<armure> getEquipement_porter() {
        return equipement_porter;
    }

    public ArrayList<arme> getArme_porter() {
        return arme_porter;
    }

    public void afficherNiveauEtProgression(int xp) {

        int ancien_xp = this.experience;
        int new_xp = this.experience +xp;
        this.experience = new_xp;

        int niveau = new_xp / 100;  // 100 points d'expérience par niveau
        int progression = new_xp % 100;

        System.out.println("Tu es de niveau " + niveau + " avec " + progression + " de progression.");

        // Vérifier si le joueur a changé de niveau
        if (new_xp / 100 > ancien_xp / 100) {
            System.out.println("Félicitations ! Tu es passé au niveau suivant !");

            Random rand = new Random();
            int int_random = rand.nextInt(5);

            switch (int_random){

                case 1:
                    this.classe.setConstitution(this.classe.getConstitution()+1);
                    System.out.println("tu gagne 1 de constitution");
                    break;
                case 2:
                    this.classe.setDexterite(this.classe.getDexterite()+1);
                    System.out.println("tu gagne 1 de dextérité");
                    break;
                case 3:
                    this.classe.setForce(this.classe.getForce()+1);
                    System.out.println("tu gagne 1 de force");
                    break;
                case 4:
                    this.classe.setIntelligence(this.classe.getIntelligence()+1);
                    System.out.println("tu gagne 1 d'intelligence");
                    break;
            }

            System.out.println("voici tes nouvels statistique:");
            System.out.println("Force : " + this.classe.getForce());
            System.out.println("Intelligence : " + this.classe.getIntelligence());
            System.out.println("Constitution :" + this.classe.getConstitution());
            System.out.println("Dexterité : " + this.classe.getDexterite());
        }
    }

    public int getExperience(){
        return this.experience;
    }

    public int nbMunition(String typemunition){
        int nbmunition = 0;
        for (Map.Entry<objet, Integer> entry : this.getInventaire().entrySet()) {
            objet objet = entry.getKey();

            if (objet.getNom().equals(typemunition)) {
                // Si la clé correspond au nom spécifié
                nbmunition += entry.getValue();
                break;
            }
        }
        return nbmunition;
    }

    public void updateMunition(){
        for (arme arme : this.arme_porter) {
            if (arme.isBesoinmunition()){
                int nbMunition = this.nbMunition(arme.getTypeAmmo());
                arme.setAmmo(arme.getAmmo() + nbMunition);
            }
        }
    }

}
