package modele.consomable;

import modele.Joueur;
import modele.arme.arme;

public class Fromage extends consomable {
    public Fromage() {
        super("Fromage", 4); // Le fromage a une valeur nutritive de 10
    }

    @Override
    public boolean estMangeablePar(Joueur joueur) {
        // Le fromage est mangeable par un humain ou un cyborg
        return "humain".equals(joueur.getClasse()) || "cyborg".equals(joueur.getClasse());
    }

    @Override
    public boolean estConsomablePar(arme arme) {
        return false;
    }

}
