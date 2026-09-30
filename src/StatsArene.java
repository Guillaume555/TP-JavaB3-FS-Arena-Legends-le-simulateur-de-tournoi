import java.util.Random;

public class StatsArene {
	
    public static void main(String[] args) {  
    	
    	int[] scores = {42, 87, 15, 99, 63, 87, 5, 71, 99, 34, 50, 28};
    	
    	System.out.println("Moyenne : " + StatsArene.moyenne(scores));
    	System.out.println("meilleure note : " + StatsArene.max(scores));
    	System.out.println("moins bonne note : " + StatsArene.min(scores));
    	
    	//partie 2
    	int nbEchanges = StatsArene.trierDecroissant(scores);
    	System.out.println("Nombre d'échanges : " + nbEchanges);
    	
    	//testes 
    	for (int s : scores) {
    	    System.out.print(s + " ");
    	}
    	System.out.println();
    	
    	//partie 3
    	int[] uniques = StatsArene.sansDoublons(scores);
    	System.out.println("Taille sans doublons : " + uniques.length);
    	//tests
    	for (int u : uniques) {
    	    System.out.print(u + " ");
    	}
    	System.out.println();
	    
    	//partie 4 
    	char[][] grille = StatsArene.creerGrille();
    	StatsArene.afficherGrille(grille);

    }

	
	
	public static double moyenne(int[] t) {	
		
		double sommes = 0;
		double total = 0.0;
		
		for (int i = 0; i < t.length ; i++) {
			sommes += t[i];
		}
		
		total = sommes / t.length ;
		return total;
	}
		
	public static int max(int[] t) {
		int m = t[0];
		for (int i = 0; i < t.length ; i++) {
			
			if (m < t[i]) {
				m = t[i];
			} 
		}
		return m;
	}
	
	public static int min(int[] t) {
		int m = t[0];
		for (int i = 0; i < t.length ; i++) {
			
			if (m > t[i]) {
				m = t[i];
			} 
		}
		return m;
	}
	
	//Partie 2
	public static int trierDecroissant(int[] t) {
		
		int nbEchanges = 0;
	    boolean echange;

	    do {
	        echange = false;

	        for (int j = 0; j < t.length - 1; j++) {
	            if (t[j]< t[j+1]) {
	                int temp = t[j];
	                t[j] = t[j + 1];
	                t[j + 1] = temp;
	                
	                nbEchanges++;            
	                echange = true;
	            }
	        }

	    } while (echange);

	    return nbEchanges;
	}
	
	//parti 3
	public static int[] sansDoublons(int[] t) {
	    int[] temp = new int[t.length];
	    int nb = 0;

	    for (int i = 0; i < t.length; i++) {
	        boolean dejaPresent = false;

	        for (int k = 0; k < nb; k++) {
	            if (temp[k] == t[i]) {
	                dejaPresent = true;
	            }
	        }

	        if (!dejaPresent) {
	            temp[nb] = t[i];
	            nb++;
	        }
	    }

	    int[] resultat = new int[nb];
	    for (int i = 0; i < nb; i++) {
	        resultat[i] = temp[i];
	    }
	    return resultat;
	}
	
	
	//partie 4

    public static char[][] creerGrille() {
        char[][] grille = new char[8][8];

        for (int ligne = 0; ligne < 8; ligne++) {
            for (int col = 0; col < 8; col++) {
                grille[ligne][col] = '.';
            }
        }

        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            placer(grille, '#', rand);
        }
        placer(grille, 'A', rand);
        placer(grille, 'B', rand);

        return grille;
    }

    public static void placer(char[][] grille, char c, Random rand) {
        int ligne;
        int col;

        do {
            ligne = rand.nextInt(8);
            col = rand.nextInt(8);
        } while (grille[ligne][col] != '.'); //

        grille[ligne][col] = c;
    }

    public static void afficherGrille(char[][] g) {
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(g[ligne][col] + " ");
            }
            System.out.println();
        }
    }
}
