package modele;

import java.util.Random;

public class MonstreSteampunk extends Monstre{


    private int force;
    private int vie;

    private int niveau;

    private String nom;



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

    public MonstreSteampunk(int id, int num_salle) {
        super(id);

        double hell_fame = 1 + (num_salle / 10.0);

        switch (id){

            case 1:
                this.vie = (int) (10*hell_fame);
                this.force = (int) (6*hell_fame);
                this.nom = "Automate";
                break;

            case 2:
                this.vie = (int) (5*hell_fame);
                this.force = (int) (2*hell_fame);
                this.nom = "Desosseur";
                break;

            case 3:
                this.vie = (int) (3*hell_fame);
                this.force = (int) (7*hell_fame);
                this.nom = "Wraith";
                break;

            default:
                System.out.println("erreur lors de la génération du monstre steampunk");
        }

    }

    public void effectuer_attaque(Joueur joueur){

        int max = 100;
        Random rand = new Random();
        int random_int = rand.nextInt(max+1);

        switch (this.getId()){

            case 1:
                if (random_int > joueur.getvclasse().getDexterite()*4){
                    joueur.setVie(joueur.getVie()-this.getForce());
                    System.out.println("l'automate attaque avec "+this.getForce() + " de force, il vous reste "+joueur.getVie()+"pv");
                }
                break;


            case 2:
                if (random_int > joueur.getvclasse().getDexterite()*4){
                    joueur.setVie(joueur.getVie()-this.getForce());
                    System.out.println("le desosseur attaque avec "+this.getForce() + " de force, il vous reste "+joueur.getVie()+"pv");
                }
                break;

            case 3:
                if (random_int < 33){
                    int vol = joueur.getVie()/4;
                    joueur.setVie(joueur.getVie()- vol);
                    this.setVie(this.getVie()+vol);
                    System.out.println("le wraith aspire votre énergie vitale");
                    break;
                }
                if (random_int > joueur.getvclasse().getDexterite()*4){
                    joueur.setVie(joueur.getVie()-this.getForce());
                    System.out.println("le wraith attaque avec "+this.getForce() + " de force, il vous reste "+joueur.getVie()+"pv");
                }
                break;


            default:
                System.out.println("erreur lors de l'attaque du monstre steampunk");
        }

    }



}
