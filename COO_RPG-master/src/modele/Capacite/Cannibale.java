package modele.Capacite;

import modele.classe;

public class Cannibale implements ICapacite{

        @Override
        public void activerCapacite(classe joueur, int numSalle) {
            System.out.println("Vous avez activé la capacité de cannibale");
        }

        @Override
        public void desactiverCapacite(classe joueur) {
            System.out.println("Vous avez désactivé la capacité de cannibale");
        }
}
