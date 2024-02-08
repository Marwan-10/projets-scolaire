package modele.arme;

import modele.Monstre;
import modele.objet;

import java.util.List;

public class arme extends objet {

    private int dgt;

    private boolean besoinmunition;
    private int tier;

    private int ammo;

    private final String typeAmmo;

    public arme(String nom, int dgt, boolean besoinmunition, int ammo, int tier, String typeAmmo) {
        super(nom);
        this.dgt = dgt;
        this.besoinmunition = besoinmunition;
        this.ammo = ammo;
        this.tier = tier;
        this.typeAmmo = typeAmmo;
    }

    public int getDgt() {
        return dgt;
    }

    public boolean isBesoinmunition() {
        return besoinmunition;
    }

    public int getAmmo() {
        return ammo;
    }

    public void abfeuern(List<Monstre> monstres) { // la fonction pour faire des dgts à une liste de monstre
        int degats = this.getDgt();

        if (besoinmunition) {
            if (ammo > 0) {
                ammo--;
            } else {
                System.out.println("Plus de munitions");
                return;
            }
        }

        for (Monstre monstre : monstres) {
            monstre.setVie(monstre.getVie()-degats);
            System.out.println("Le monstre a subi " + degats + " dégâts de l'arme " + this.getNom());
        }
    }

    public String getTypeAmmo() {
        return typeAmmo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
