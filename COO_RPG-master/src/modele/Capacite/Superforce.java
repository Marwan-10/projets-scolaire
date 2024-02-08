package modele.Capacite;

import modele.classe;

public class Superforce implements ICapacite{

        @Override
        public void activerCapacite(classe joueur, int numSalle) {
                System.out.println("Superforce activée");
                if (numSalle%2 == 0 && numSalle != 10){
                        joueur.setForce(joueur.getForce() * 2);
                }
        }

        @Override
        public void desactiverCapacite(classe joueur) {
                System.out.println("Superforce désactivée");
                joueur.setForce(joueur.getForce() / 2);
        }
}
