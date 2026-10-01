public class Guerrier extends Combattant {

    private int rage;

    public Guerrier(String nom, int pvMax, int attaque, int defense) {
        super(nom, pvMax, attaque, defense);
        this.rage = 0;
    }

    public int getRage() {
        return rage;
    }

    // +20 de rage a chaque attaque, a 100 degats x2 et on remet a 0
    @Override
    public int attaquer(Combattant cible) {
        int degats = getAttaque();
        rage = rage + 20;

        if (rage >= 100) {
            degats = degats * 2;
            rage = 0;
        }

        cible.subirDegats(degats);
        return degats;
    }

    @Override
    public String getClasse() {
        return "Guerrier";
    }
}