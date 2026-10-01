import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Tournoi {

    private ArrayList<Combattant> participants = new ArrayList<>();
    private boolean affichage = true;

    public void setAffichage(boolean affichage) {
        this.affichage = affichage;
    }

    private void afficher(String texte) {
        if (affichage) {
            System.out.println(texte);
        }
    }

    // 5.1 inscription, max 8 et pas de doublon de nom
    public boolean inscrire(Combattant c) {
        if (participants.size() >= 8) {
            return false;
        }
        for (Combattant p : participants) {
            if (p.getNom().equalsIgnoreCase(c.getNom())) {
                return false;
            }
        }
        participants.add(c);
        return true;
    }

    // 5.2 iterator pour pas avoir de ConcurrentModificationException
    public boolean desinscrire(String nom) {
        Iterator<Combattant> it = participants.iterator();
        while (it.hasNext()) {
            Combattant c = it.next();
            if (c.getNom().equalsIgnoreCase(nom)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // 5.3 duel au tour par tour
    public Combattant duel(Combattant a, Combattant b) {
        Combattant attaquant;
        Combattant defenseur;

        if (a.getAttaque() >= b.getAttaque()) {
            attaquant = a;
            defenseur = b;
        } else {
            attaquant = b;
            defenseur = a;
        }

        afficher("\n" + a.getNom() + " VS " + b.getNom());

        int tour = 1;
        while (!a.estKO() && !b.estKO() && tour <= 50) {
            int degats = attaquant.attaquer(defenseur);
            afficher("Tour " + tour + " : " + attaquant.getNom() + " envoie " + degats + " -> " + defenseur);

            Combattant temp = attaquant;
            attaquant = defenseur;
            defenseur = temp;
            tour++;
        }

        Combattant vainqueur;
        if (a.estKO()) {
            vainqueur = b;
        } else if (b.estKO()) {
            vainqueur = a;
        } else {
            // plus de 50 tours, on compare les pv en %
            double pourcentA = (double) a.getPv() / a.getPvMax();
            double pourcentB = (double) b.getPv() / b.getPvMax();
            if (pourcentA >= pourcentB) {
                vainqueur = a;
            } else {
                vainqueur = b;
            }
        }

        vainqueur.ajouterVictoire();
        afficher("Vainqueur : " + vainqueur.getNom());
        return vainqueur;
    }

    // 5.4 elimination directe
    public Combattant lancer() {
        ArrayList<Combattant> enLice = new ArrayList<>(participants);
        Collections.shuffle(enLice);

        int manche = 1;
        while (enLice.size() > 1) {
            afficher("\n===== MANCHE " + manche + " =====");
            ArrayList<Combattant> vainqueurs = new ArrayList<>();

            for (int i = 0; i < enLice.size(); i += 2) {
                if (i + 1 < enLice.size()) {
                    Combattant v = duel(enLice.get(i), enLice.get(i + 1));
                    v.soigner(v.getPvMax());
                    vainqueurs.add(v);
                } else {
                    vainqueurs.add(enLice.get(i));   // nombre impair, il passe direct
                }
            }

            enLice = vainqueurs;
            manche++;
        }
        return enLice.get(0);
    }

    // 5.5 tri a bulles par victoires, sans Collections.sort
    public ArrayList<Combattant> classement() {
        ArrayList<Combattant> liste = new ArrayList<>(participants);
        boolean echange;

        do {
            echange = false;
            for (int j = 0; j < liste.size() - 1; j++) {
                if (liste.get(j).getVictoires() < liste.get(j + 1).getVictoires()) {
                    Combattant temp = liste.get(j);
                    liste.set(j, liste.get(j + 1));
                    liste.set(j + 1, temp);
                    echange = true;
                }
            }
        } while (echange);

        return liste;
    }

    // 5.6 victoires cumulees par classe avec getClasse()
    public void statsParClasse() {
        String[] classes = {"Guerrier", "Mage", "Voleur", "Paladin"};
        int[] total = new int[classes.length];

        for (Combattant c : participants) {
            for (int k = 0; k < classes.length; k++) {
                if (c.getClasse().equals(classes[k])) {
                    total[k] += c.getVictoires();
                }
            }
        }

        System.out.println("\nStats par classe :");
        for (int k = 0; k < classes.length; k++) {
            System.out.println(classes[k] + " : " + total[k] + " victoire(s)");
        }
    }

    // cree un tournoi avec 8 combattants (au moins 2 de chaque classe)
    private static Tournoi creerTournoi() {
        Tournoi t = new Tournoi();
        t.inscrire(new Guerrier("Kaelen", 120, 18, 6));
        t.inscrire(new Guerrier("Torvald", 140, 16, 8));
        t.inscrire(new Guerrier("Brakka", 110, 20, 5));
        t.inscrire(new Mage("Lyra", 90, 15, 3));
        t.inscrire(new Mage("Orin", 100, 13, 4));
        t.inscrire(new Mage("Selene", 85, 16, 2));
        t.inscrire(new Voleur("Shade", 100, 14, 4, 25));
        t.inscrire(new Voleur("Vex", 95, 15, 3, 30));
        return t;
    }

    // test final
    public static void main(String[] args) {
        Tournoi t = creerTournoi();

        System.out.println("Doublon accepte ? " + t.inscrire(new Mage("KAELEN", 90, 15, 3)));   // false
        System.out.println("9e inscrit accepte ? " + t.inscrire(new Mage("Intrus", 90, 15, 3)));  // false

        Combattant champion = t.lancer();
        System.out.println("\n*** CHAMPION : " + champion + " ***");

        System.out.println("\nClassement :");
        for (Combattant c : t.classement()) {
            System.out.println(c.getVictoires() + " victoire(s) - " + c);
        }

        t.statsParClasse();

        // 100 tournois sans affichage
        int titresGuerrier = 0;
        int titresMage = 0;
        int titresVoleur = 0;

        for (int i = 0; i < 100; i++) {
            Tournoi t2 = creerTournoi();
            t2.setAffichage(false);
            String classe = t2.lancer().getClasse();

            if (classe.equals("Guerrier")) {
                titresGuerrier++;
            } else if (classe.equals("Mage")) {
                titresMage++;
            } else {
                titresVoleur++;
            }
        }

        System.out.println("\nSur 100 tournois :");
        System.out.println("Guerrier : " + titresGuerrier);
        System.out.println("Mage : " + titresMage);
        System.out.println("Voleur : " + titresVoleur);
    }
}