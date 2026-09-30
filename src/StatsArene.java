
public class StatsArene {
	
    public static void main(String[] args) {  
    	
    	int[] scores = {42, 87, 15, 99, 63, 87, 5, 71, 99, 34, 50, 28};
    	System.out.println("Moyenne : " + StatsArene.moyenne(scores));
    	System.out.println("meilleure note : " + StatsArene.max(scores));
    	System.out.println("moins bonne note : " + StatsArene.min(scores));


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

	


}
