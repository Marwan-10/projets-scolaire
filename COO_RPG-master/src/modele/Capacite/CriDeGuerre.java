package modele.Capacite;

import modele.classe;

public class CriDeGuerre implements ICapacite{

        @Override
        public void activerCapacite(classe joueur, int numSalle) {
            System.out.println("Vous avez activé la capacité : Cri de guerre");
            if (numSalle%2 == 0 && numSalle != 10){
                joueur.setForce(joueur.getForce()*2);
                System.out.println("Votre force a augmenté de 2");
            }
        }

        @Override
        public void desactiverCapacite(classe joueur) {
            System.out.println("Vous avez désactivé la capacité : Cri de guerre");
            joueur.setForce(joueur.getForce()/2);
        }
}
