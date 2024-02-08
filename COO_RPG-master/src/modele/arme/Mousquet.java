package modele.arme;

public class Mousquet extends arme{
    public Mousquet(int tier) {
        super("Mousquet", calculerDegats(tier), true, 1, tier, "Balle");
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
