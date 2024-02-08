package modele.arme;

import modele.Capacite.ICapacite;
import modele.Monstre;

import java.util.List;

public class BobineTesla extends arme {
    public BobineTesla(int tier) {
        super("Bobine Tesla", calculerDegats(tier), false, 0, tier, "");
    }

    private static int calculerDegats(int tier) {
        return switch (tier) {
            case 1 -> 3;
            case 2 -> 4;
            case 3 -> 5;
            default -> throw new IllegalArgumentException("Tier invalide : " + tier);
        };
    }

}