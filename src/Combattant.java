public class Combattant {

    private final String nom;
    private final int pvMax;
    private int pv;
    private int attaque;
    private int defense;

    private static int nbCombattants = 0;

    public Combattant(String nom, int pvMax, int attaque, int defense) {

        // verif des valeurs
        if (nom == null || nom.length() < 3 || nom.length() > 15) {
            throw new IllegalArgumentException("nom doit faire entre 3 et 15 caractères, reçu : " + nom);
        }
        if (pvMax < 50 || pvMax > 300) {
            throw new IllegalArgumentException("pvMax doit être entre 50 et 300, reçu : " + pvMax);
        }
        if (attaque < 5 || attaque > 50) {
            throw new IllegalArgumentException("attaque doit être entre 5 et 50, reçu : " + attaque);
        }
        if (defense < 0 || defense > 30) {
            throw new IllegalArgumentException("defense doit être entre 0 et 30, reçu : " + defense);
        }

        this.nom = nom;
        this.pvMax = pvMax;
        this.attaque = attaque;
        this.defense = defense;
        this.pv = pvMax;

        nbCombattants++;
    }

    // tests
    public static void main(String[] args) {
        Combattant k = new Combattant("Kaelen", 120, 18, 6);
        System.out.println("Kaelen créé !");

        try {
            Combattant faux = new Combattant("Bob", 120, 70, 6);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur attendue : " + e.getMessage());
        }
    }
}