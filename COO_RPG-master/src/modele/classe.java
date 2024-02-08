package modele;

import modele.Capacite.*;

import java.util.ArrayList;
import java.util.List;

public class classe {

    private int force;
    private int dexterite;
    private int constitution;
    private int intelligence;

    private List<ICapacite> capacite;

    private String nom_classe;

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getNom_classe() {
        return nom_classe;
    }

    public void setNom_classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public List<ICapacite> getCapacite() {
        return capacite;
    }

    public classe(String nom_classe, String theme) {
        this.nom_classe = nom_classe;
        this.capacite = new ArrayList<>();
        if (theme.equals("steampunk")){
            switch (nom_classe) {
                case "humain" -> {
                    this.force = 2;
                    this.dexterite = 4;
                    this.constitution = 2;
                    this.intelligence = 4;
                    this.nom_classe = "humain";
                    this.capacite.add(new ForceDesespoir());
                    this.capacite.add(new Geo());
                    this.capacite.add(new Themistocle());
                    break;
                }
                case "cyborg" -> {
                    this.force = 3;
                    this.dexterite = 3;
                    this.constitution = 3;
                    this.intelligence = 3;
                    this.nom_classe = "cyborg";
                    this.capacite.add(new Superforce());
                    this.capacite.add(new Surcharge());
                    this.capacite.add(new JourFerie());
                    break;
                }
                case "automate" -> {
                    this.force = 4;
                    this.dexterite = 2;
                    this.constitution = 4;
                    this.intelligence = 2;
                    this.nom_classe = "automate";
                    this.capacite.add(new Reparation());
                    this.capacite.add(new OptimusPrime());
                    this.capacite.add(new Cannibale());
                    break;
                }
            }
        }
        else {
            switch (nom_classe){
                case "barbare" -> {
                    this.force = 4;
                    this.dexterite = 2;
                    this.constitution = 4;
                    this.intelligence = 2;
                    this.nom_classe = "barbare";
                    this.capacite.add(new CoupDeBoule());
                    this.capacite.add(new Frenesie());
                    this.capacite.add(new CriDeGuerre());
                    break;
                }
                case "archer" -> {
                    this.force = 2;
                    this.dexterite = 4;
                    this.constitution = 3;
                    this.intelligence = 3;
                    this.nom_classe = "archer";
                    this.capacite.add(new FlecheGele());
                    this.capacite.add(new FrappeDivine());
                    this.capacite.add(new Sniper());
                    break;
                }
                case "sorcier" -> {
                    this.force = 1;
                    this.dexterite = 3;
                    this.constitution = 2;
                    this.intelligence = 5;
                    this.nom_classe = "sorcier";
                    this.capacite.add(new Lecture());
                    this.capacite.add(new Covide());
                    this.capacite.add(new AvadaKadabra());
                    break;
                }
            }
        }

    }
}
