package modele.consomable;

import modele.Joueur;
import modele.arme.arme;

public class Huile extends consomable {
    public Huile() {
        super("Huile", 4); // L'huile a une valeur nutritive de 5
    }

    @Override
    public boolean estMangeablePar(Joueur joueur) {
        // L'huile est mangeable uniquement par un cyborg ou un automate
        return "cyborg".equals(joueur.getClasse()) || "automate".equals(joueur.getClasse());
    }

    @Override
    public boolean estConsomablePar(arme arme) {
        return false;
    }
}