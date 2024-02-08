package modele;

import java.util.Random;

public abstract class Monstre {


    private int force;
    private int vie;

    private String nom;
    private int id;


    public Monstre(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }
}
