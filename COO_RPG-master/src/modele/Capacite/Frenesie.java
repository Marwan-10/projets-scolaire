package modele.Capacite;

import modele.classe;
public class Frenesie implements ICapacite{

    @Override
    public void activerCapacite(classe joueur, int numSalle) {
        System.out.println("Vous avez activé la capacité : Frenesie");
        if (numSalle%2 == 0 && numSalle != 10){
            joueur.setForce(joueur.getForce()*2);
            joueur.setDexterite(joueur.getDexterite()/2);
        }
    }

    @Override
    public void desactiverCapacite(classe joueur) {
        System.out.println("Vous avez désactivé la capacité : Frenesie");
        joueur.setForce(joueur.getForce()/2);
        joueur.setDexterite(joueur.getDexterite()*2);
    }
}
