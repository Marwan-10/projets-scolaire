package modele.Capacite;

import modele.classe;

public class JourFerie implements ICapacite{

    @Override
    public void activerCapacite(classe joueur, int numSalle) {
        System.out.println("JourFerie activée");
    }

    @Override
    public void desactiverCapacite(classe joueur) {
        System.out.println("JourFerie désactivée");
    }
}
