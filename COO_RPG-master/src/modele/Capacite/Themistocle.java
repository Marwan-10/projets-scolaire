package modele.Capacite;

import modele.classe;

public class Themistocle implements ICapacite{

            @Override
            public void activerCapacite(classe joueur, int numSalle) {
                System.out.println("Vous avez activé la capacité Themistocle");
                if (numSalle%2 == 1) {
                    joueur.setDexterite(joueur.getDexterite() * 2);
                }
            }

            @Override
            public void desactiverCapacite(classe joueur) {
                System.out.println("Vous avez désactivé la capacité Themistocle");
                joueur.setDexterite(joueur.getDexterite() / 2);
            }
}
