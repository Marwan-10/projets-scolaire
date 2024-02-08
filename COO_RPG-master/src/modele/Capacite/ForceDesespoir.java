package modele.Capacite;

import modele.classe;

public class ForceDesespoir implements ICapacite{

        @Override
        public void activerCapacite(classe joueur, int numSalle) {
            int random_int = (int) (Math.random() * numSalle);
            if (random_int%2 == 0) {
                System.out.println("Vos pleures ont été entendu");;
            }
            else {
                System.out.println("Vos pleures n'ont pas été entendu");
            }
        }

        @Override
        public void desactiverCapacite(classe joueur) {
            System.out.println("Vous avez désactivé la capacité Force du désespoir");
        }
}
