package modele.consomable;

import modele.Joueur;
import modele.arme.arme;

public class Fleche extends consomable{
    public Fleche() {
        super("Fleche", 0);
    }

    @Override
    public boolean estMangeablePar(Joueur joueur) {
        return false;
    }

    @Override
    public boolean estConsomablePar(arme arme) {
        return true;
    }

}
