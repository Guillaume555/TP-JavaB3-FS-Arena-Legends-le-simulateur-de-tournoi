public class Mage extends Combattant {

    private int mana;

    public Mage(String nom, int pvMax, int attaque, int defense) {
        super(nom, pvMax, attaque, defense);
        this.mana = 100;
    }

    public int getMana() {
        return mana;
    }

    // sort si assez de mana (ignore la def), sinon petite attaque + recup mana
    @Override
    public int attaquer(Combattant cible) {
        int degats;

        if (mana >= 30) {
            mana = mana - 30;
            degats = getAttaque() * 2;
            cible.subirDegatsBruts(degats);
        } else {
            degats = getAttaque() / 2;
            mana = mana + 15;
            cible.subirDegats(degats);
        }

        return degats;
    }
}