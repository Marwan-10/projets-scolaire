import modele.*;
import modele.Capacite.*;
import modele.Capacite.ICapacite;
import modele.arme.Arbalete;
import modele.armure.ArmureSuperieur;
import modele.armure.armure;
import modele.consomable.Fleche;
import modele.consomable.Fromage;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class UniTest {

    @Test
    public void testperso(){
        Map<objet, Integer> inventaire = new HashMap<>();

        Joueur joueur = new Joueur("tommy", "barbare", inventaire,  0, "boubou", 100, 5, "medieval");

        assertEquals("barbare", joueur.getClasse());
        assertEquals(4, joueur.getvclasse().getForce());
        //assertEquals(new CoupDeBoule(), joueur.getvclasse().getCapacite().get(0));

    }

    @Test
    public void testarme(){
        Map<objet, Integer> inventaire = new HashMap<>();
        Arbalete arba = new Arbalete(1, "Fleche");
        inventaire.put(arba, 1);
        inventaire.put(new Fleche(), 1);

        Joueur joueur = new Joueur("tommy", "barbare", inventaire,  0, "boubou", 100, 5, "medieval");

        joueur.equiperarme(arba, 0);
        joueur.updateMunition();

        assertEquals(2, joueur.getArme_porter().get(0).getAmmo());

        List<Monstre> monstres = new ArrayList<>();
        monstres.add(new MonstreMedievale(1, 1));

        joueur.getArme_porter().get(0).abfeuern(monstres);

        assertEquals(1, joueur.getArme_porter().get(0).getAmmo());

        joueur.getArme_porter().get(0).abfeuern(monstres);

        assertEquals(0, joueur.getArme_porter().get(0).getAmmo());

        joueur.desequiperarme(arba, 0);

        assertFalse(joueur.getArme_porter().contains(arba));
    }

    @Test
    public void testcombat(){

    }


    @Test
    public void testinventaire(){
        Map<objet, Integer> inventaire = new HashMap<>();


        Joueur joueur = new Joueur("tommy", "humain", inventaire,  0, "boubou", 100, 5, "steampunk");

        joueur.add_inventaire(new Fromage(), 1);
        assertTrue(joueur.est_daslinv("Fromage"));
        joueur.inventaire_scanner("Fromage", 1);
        assertFalse(joueur.est_daslinv("Fromage"));

    }

    @Test
    public void combatmonstre(){

        Map<objet, Integer> inventaire = new HashMap<>();

        Joueur joueur = new Joueur("tommy", "humain", inventaire,  0, "boubou", 100, 5, "steampunk");
        int ancienne_vie = joueur.getVie();

        MonstreSteampunk monster = new MonstreSteampunk(1, 1);

        monster.effectuer_attaque(joueur);

        boolean rep = joueur.getVie() < ancienne_vie;
        assertTrue(rep);

    }

    @Test
    public void Tryarmure(){
        Map<objet, Integer> inventaire = new HashMap<>();

        Joueur joueur = new Joueur("tommy", "humain", inventaire,  0, "boubou", 100, 5, "steampunk");

        armure armur = new ArmureSuperieur("casque");

        joueur.add_inventaire(armur, 1);

        assertTrue(joueur.est_daslinv(armur.getNom()));

        joueur.equiperArmure(armur);

        assertEquals(4, joueur.getEquipement_porter().size());

        assertEquals(joueur.getDefense(), 3);

        assertFalse(joueur.est_daslinv(armur.getNom()));

        joueur.desequiperArmure(armur);
        assertEquals(0, joueur.getDefense());
        assertTrue(joueur.est_daslinv(armur.getNom()));


    }

    @Test
    public void xp_curve(){
        Map<objet, Integer> inventaire = new HashMap<>();

        Joueur joueur = new Joueur("tommy", "humain", inventaire,  0, "boubou", 100, 5, "steampunk");

        joueur.afficherNiveauEtProgression(10);

        assertEquals(110, joueur.getExperience());
    }

    @Test
    public void miam_miam(){
        Map<objet, Integer> inventaire = new HashMap<>();

        Joueur joueur = new Joueur("tommy", "humain", inventaire,  0, "boubou", 100, 5, "steampunk");

        Fromage fromage = new Fromage();
        int vida = joueur.getVie();

        joueur.add_inventaire(fromage, 1);

        joueur.manger(fromage, 1);

        boolean result = vida == joueur.getVie(); // sont égal car la fonction d'ajout de pv est dans le controleur

        assertTrue(result);
        assertFalse(joueur.est_daslinv("Fromage"));

    }
}
