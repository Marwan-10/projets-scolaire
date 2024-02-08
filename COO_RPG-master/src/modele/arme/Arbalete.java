package modele.arme;

public class Arbalete extends arme{

    public Arbalete(int tier, String typeAmmo) {
        super("Arbalete", calculerDegats(tier), true, 1, tier, typeAmmo);
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
