package modele.Invocateur;

import modele.Commande.Commande;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Invocateur {
    private Queue<Commande> lesSalleATraiter=new ArrayDeque<>();
    private Deque<Queue<Commande>> pileHistorique=new ArrayDeque<>();
    public void ajouterCommande(Commande commande){
        lesSalleATraiter.add(commande);
    }

    public void traiterLesCommandes(){
        Queue<Commande> commandesT=new ArrayDeque<>();
        while (!lesSalleATraiter.isEmpty()) {
            Commande c = lesSalleATraiter.remove();
            c.executer();
            commandesT.add(c);
        }
        pileHistorique.push(commandesT);
    }

    public void annulerDerniereSerie(){
        Queue<Commande> filet=pileHistorique.pop();
        while (!filet.isEmpty()){
            Commande c=filet.remove();
            c.annuler();
        }

    }
    public void annuler() {
        while(!pileHistorique.isEmpty()){
            annulerDerniereSerie();
        }
    }

}
