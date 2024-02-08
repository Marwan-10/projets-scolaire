package modele.Fabrication;

import modele.*;
import modele.GenerateurDonjon.GenerateurDonjon;
import modele.GenerateurDonjon.GenerateurDonjonMedievale;

import java.util.Map;

public class FabricationMedieval extends FabricationTheme{
    public Joueur creerJoueur(String nom, String classe, Map<objet, Integer> inventaire, int defense, String race, int experience, int vie,String theme){
        return new Joueur(nom, classe, inventaire, defense, race, experience, vie, theme);
    }


    public Monstre creerMonstre(int id,int numSalle){
        return new MonstreMedievale(id,numSalle);
    }

    public GenerateurDonjon creerDonjon( ){
        return new GenerateurDonjonMedievale();
    }
}
