package modele.Fabrication;

import modele.*;
import modele.GenerateurDonjon.GenerateurDonjon;
import modele.GenerateurDonjon.GenerateurDonjonSteampunk;

import java.util.Map;

public class FabricationSteampunk extends FabricationTheme{
    public Joueur creerJoueur(String nom, String classe, Map<objet, Integer> inventaire, int defense, String race, int experience, int vie, String theme){
        return new Joueur(nom, classe, inventaire, defense, race, experience, vie, theme);
    }


    public Monstre creerMonstre(int id, int numSalle){
        return new MonstreSteampunk(id,numSalle);
    }

    public GenerateurDonjon creerDonjon(){
        return new GenerateurDonjonSteampunk();
    }

}
