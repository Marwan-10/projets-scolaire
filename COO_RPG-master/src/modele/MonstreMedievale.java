package modele;

import java.util.Random;

public class MonstreMedievale extends Monstre{

    private int force;
    private int vie;

    private int niveau;

    private String nom;

    public MonstreMedievale(int id, int num_salle) {

        super(id);

        double hell_fame = 1 + (num_salle / 10.0);

        switch (id){

            case 1:
                this.vie = (int) (10*hell_fame);
                this.force = (int) (6*hell_fame);
                this.nom = "Dragon";
                break;

            case 2:
                this.vie = (int) (5*hell_fame);
                this.force = (int) (2*hell_fame);
                this.nom = "Mercenaire";
                break;

            case 3:
                this.vie = (int) (3*hell_fame);
                this.force = (int) (7*hell_fame);
                this.nom = "Rat d'ain";
                break;

            default:
                System.out.println("erreur lors de la génération du monstre steampunk");
        }

    }

    public void effectuer_attaque(Monstre monster, Joueur joueur){

        int max = 100;
        Random rand = new Random();
        int random_int = rand.nextInt(max+1);

        switch (monster.getId()){

            case 1:
                if (random_int > joueur.getvclasse().getDexterite()*4){
                    joueur.setVie(joueur.getVie()-monster.getForce());
                    System.out.println("le dragon attaque avec "+monster.getForce() + "de force, il vous reste"+joueur.getVie()+"pv");
                }
                break;


            case 2:
                if (random_int > joueur.getvclasse().getDexterite()*4){
                    joueur.setVie(joueur.getVie()-monster.getForce());
                    System.out.println("le mercenaire attaque avec "+monster.getForce() + "de force, il vous reste"+joueur.getVie()+"pv");
                }
                break;

            case 3:
                if (random_int < 33 && joueur.est_daslinv("poulet")){

                    joueur.inventaire_scanner("poulet", 1);
                    monster.setVie(monster.getVie()+2);
                    System.out.println("le rat-din vous vole un poulet et récupère de la vie");

                    break;
                }
                if (random_int > joueur.getvclasse().getDexterite()*4){
                    joueur.setVie(joueur.getVie()-monster.getForce());
                    System.out.println("le rat-din attaque avec "+monster.getForce() + "de force, il vous reste"+joueur.getVie()+"pv");
                }
                break;

            default:
                System.out.println("erreur lors de l'attaque du monstre steampunk");
        }

    }



    public int getForce() {
        return force;
    }

    public int getVie() {
        return vie;
    }

    public int getNiveau() {
        return niveau;
    }

    public String getNom() {
        return nom;
    }
}
