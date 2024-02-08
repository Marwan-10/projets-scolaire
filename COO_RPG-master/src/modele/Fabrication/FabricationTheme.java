package modele.Fabrication;

import modele.GenerateurDonjon.GenerateurDonjon;
import modele.Joueur;
import modele.Monstre;
import modele.objet;

import java.util.Map;

public abstract class FabricationTheme {
    public abstract Joueur creerJoueur(String nom, String classe, Map<objet, Integer> inventaire, int defense, String race, int experience, int vie,String theme);
    public abstract Monstre creerMonstre(int id,int numSalle);

    public abstract GenerateurDonjon creerDonjon();
}
