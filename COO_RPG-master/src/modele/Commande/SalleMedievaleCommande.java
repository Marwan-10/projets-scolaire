package modele.Commande;

import modele.Salle.SalleMedievale;

public class SalleMedievaleCommande implements Commande{
    private SalleMedievale salleMedievale;
    private int ancienneValeur;
    private int salle;
    public SalleMedievaleCommande(SalleMedievale salleMedievale,int salle){
        this.salleMedievale=salleMedievale;
        this.salle=salle;
    }

    @Override
    public void executer(){
        ancienneValeur=salleMedievale.getSalle();
        salleMedievale.setSalle(salle);
    }
    @Override
    public void annuler(){
        salleMedievale.setSalle(ancienneValeur);
    }
}
