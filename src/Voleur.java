import java.util.Random;

public class Voleur extends Combattant {

    private final int esquive;
    private static Random rand = new Random();

    public Voleur(String nom, int pvMax, int attaque, int defense, int esquive) {
        super(nom, pvMax, attaque, defense);

        if (esquive < 10 || esquive > 40) {
            throw new IllegalArgumentException("esquive doit être entre 10 et 40, reçu : " + esquive);
        }
        this.esquive = esquive;
    }

    public int getEsquive() {
        return esquive;
    }

    // 25% de chance de frapper 2 fois
    @Override
    public int attaquer(Combattant cible) {
        int total = getAttaque();
        cible.subirDegats(getAttaque());

        if (rand.nextInt(100) < 25) {
            cible.subirDegats(getAttaque());
            total = total + getAttaque();
        }

        return total;
    }
}