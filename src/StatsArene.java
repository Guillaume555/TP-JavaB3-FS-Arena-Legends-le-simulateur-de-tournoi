
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
	
}
