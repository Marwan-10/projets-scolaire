package modele.arme;

public class Epee extends arme{
    public Epee(int tier) {
        super("Epee", calculerDegats(tier), false, 0, tier, "");
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
