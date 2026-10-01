public class Combattant {

    private final String nom;
    private final int pvMax;
    private int pv;
    private int attaque;
    private int defense;

    private static int nbCombattants = 0;

    // 3.1 constructeur
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

    // 3.2 getters
    public String getNom() {
        return nom;
    }

    public int getPvMax() {
        return pvMax;
    }

    public int getPv() {
        return pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getDefense() {
        return defense;
    }

    public static int getNbCombattants() {
        return nbCombattants;
    }

    // 3.3 subir degats
    public void subirDegats(int d) {
        int degatsReels = d - defense;
        if (degatsReels < 1) {
            degatsReels = 1;
        }

        pv = pv - degatsReels;
        if (pv < 0) {
            pv = 0;
        }
    }

    // 3.4 soigner
    public void soigner(int s) {
        if (estKO()) {
            return;
        }

        pv = pv + s;
        if (pv > pvMax) {
            pv = pvMax;
        }
    }

    // 3.5 KO + affichage
    public boolean estKO() {
        return pv == 0;
    }

    @Override
    public String toString() {
        return nom + " [" + pv + "/" + pvMax + " PV] ATK " + attaque + " DEF " + defense;
    }

    // tests
    public static void main(String[] args) {
        Combattant k = new Combattant("Kaelen", 120, 18, 6);
        System.out.println(k);

        try {
            Combattant faux = new Combattant("Bob", 120, 70, 6);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur attendue : " + e.getMessage());
        }
        System.out.println("Nb combattants : " + Combattant.getNbCombattants());

        k.subirDegats(20);
        System.out.println("Apres 20 degats : " + k);   // 106
        k.subirDegats(3);
        System.out.println("Apres 3 degats : " + k);    // 105 (min 1)

        k.soigner(50);
        System.out.println("Apres soin de 50 : " + k);  // 120 (pas plus que pvMax)

        k.subirDegats(500);
        System.out.println("Apres 500 degats : " + k + " KO ? " + k.estKO());  // 0, true

        k.soigner(50);
        System.out.println("Soin sur un KO : " + k);    // reste a 0
    }
}