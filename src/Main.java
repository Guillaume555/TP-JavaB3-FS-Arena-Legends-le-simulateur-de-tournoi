
import java.util.Random;
import java.util.Scanner;


public class Main {
	//public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in); 
		Random rand = new Random();
				
		
		public void menu(int choix) {
		do {
			
			System.out.println("=== ARENA LEGENDS ==="); 
			System.out.println("1. Lancer un dé");     
			System.out.println("2. Calculer un rang");     
			System.out.println("3. Test de coup critique");     
			System.out.println("0. Quitter");  
			
			System.out.print("Votre proposition : ");
			choix = sc.nextInt();
			
			switch(choix) {
			
				case 0 :
					System.out.println("Fin de partie");
					break;
					
				case 1:
					System.out.println("option 1");
					//int x = rand.nextInt(0, 4);
					break;
					
				case 2:
					System.out.println("option 2");
					break;
				
				case 3:
					System.out.println("option 3");
					break;
					
				default :
					System.out.println("donnez incorrect veuillez tapez un nombre entre 0 et 3");  
			}
				
		} while (choix != 0);
	}	
		public static void main(String[] arg) {

	        Main m = new Main();

	        m.menu(0);
	    }
}

