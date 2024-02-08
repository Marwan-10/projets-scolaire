package modele.Capacite;

import modele.classe;
public class AvadaKadabra implements ICapacite{

        @Override
        public void activerCapacite(classe joueur, int numSalle) {
            System.out.println("Vous avez activé la capacité AvadaKadabra");
        }

        @Override
        public void desactiverCapacite(classe joueur) {
            System.out.println("Vous avez désactivé la capacité AvadaKadabra");
        }
}
