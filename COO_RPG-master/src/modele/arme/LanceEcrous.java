package modele.arme;

public class LanceEcrous extends arme{
    public LanceEcrous(int tier) {
        super("Lance Ecrous", calculerDegats(tier), true, 1, tier,"Ecrous");
    }

    private static int calculerDegats(int tier) {
        return switch (tier) {
            case 1 -> 4;
            case 2 -> 5;
            case 3 -> 6;
            default -> throw new IllegalArgumentException("Tier invalide : " + tier);
        };
    }
}
