package modele.Capacite;

import modele.classe;

public class Surcharge implements ICapacite{

            @Override
            public void activerCapacite(classe joueur, int numSalle) {
                    System.out.println("Surcharge activée");
            }

            @Override
            public void desactiverCapacite(classe joueur) {
                    System.out.println("Surcharge désactivée");
            }
}
