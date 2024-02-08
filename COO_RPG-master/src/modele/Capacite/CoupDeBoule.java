package modele.Capacite;

import modele.classe;
public class CoupDeBoule implements ICapacite{

    @Override
    public void activerCapacite(classe joueur, int numSalle) {
        if (joueur.getIntelligence() > 0) {
            System.out.println("Vous avez activé la capacité : Coup de boule");
            if (numSalle%2 == 0 && numSalle != 10){
                joueur.setIntelligence(joueur.getIntelligence()-1);
            }
        }
        else {
            System.out.println("Vous n'avez pas assez d'intelligence pour activer cette capacité");
        }
    }

    @Override
    public void desactiverCapacite(classe joueur) {
        System.out.println("Vous avez désactivé la capacité : Coup de boule");
    }
}
