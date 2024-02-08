package modele.Capacite;

import modele.classe;

public class Reparation implements ICapacite{

        @Override
        public void activerCapacite(classe joueur, int numSalle) {
            System.out.println("Vous avez activé la capacité de réparation");
        }

        @Override
        public void desactiverCapacite(classe joueur) {

        }
}
