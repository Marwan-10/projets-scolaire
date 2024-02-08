package modele.arme;

public class BaguetteMagique extends arme{
    public BaguetteMagique(int tier) {
        super("Baguette Magique", calculerDegats(tier), true, 1, tier, "Mana");
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
