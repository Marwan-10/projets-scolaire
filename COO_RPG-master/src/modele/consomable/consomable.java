package modele.consomable;

import modele.Joueur;
import modele.arme.arme;
import modele.objet;


public abstract class consomable extends objet {
    private int nombre;

    public consomable(String nom, int valeurNutritive) {
        super(nom);
        this.nombre = valeurNutritive;
    }

    public int getValeurNutritive() {
        return nombre;
    }

    // Méthode abstraite pour déterminer si l'objet est mangeable par un certain type de joueur
    public abstract boolean estMangeablePar(Joueur joueur);

    // Méthode abstraite pour déterminer si l'objet est consommable par une certaine arme
    public abstract boolean estConsomablePar(arme arme);
}

