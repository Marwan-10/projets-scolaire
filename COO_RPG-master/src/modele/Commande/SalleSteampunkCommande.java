package modele.Commande;

import modele.Salle.SalleMedievale;
import modele.Salle.SalleSteampunk;

public class SalleSteampunkCommande implements Commande{
    private SalleSteampunk salleSteampunk;
    private int ancienneValeur;
    private int salle;
    public SalleSteampunkCommande(SalleSteampunk salleSteampunk,int salle){
        this.salleSteampunk=salleSteampunk;
        this.salle=salle;
    }

    @Override
    public void executer(){
        ancienneValeur= salleSteampunk.getSalle();
        salleSteampunk.setSalle(salle);
    }
    @Override
    public void annuler(){
        salleSteampunk.setSalle(ancienneValeur);
    }
}
