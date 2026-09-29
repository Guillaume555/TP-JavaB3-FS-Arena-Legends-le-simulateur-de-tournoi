import java.util.Random;
import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in); 
    Random rand = new Random();
    int x;
    int resultat;
    int points;

    public void menu() {
        int choix;
        do {
            System.out.println("\n=== ARENA LEGENDS ==="); 
            System.out.println("1. Lancer un dé");     
            System.out.println("2. Calculer un rang");     
            System.out.println("3. Test de coup critique");     
            System.out.println("0. Quitter");  
            
            System.out.print("Votre proposition : ");
            choix = sc.nextInt();
            
            switch(choix) {
                case 0:
                    System.out.println("Fin de partie");
                    break;
                    
                case 1:
                    do {
                        System.out.println("Choisissez un dé allant de 4 à 20 faces : ");
                        System.out.print("Votre Dé : ");
                        x = sc.nextInt();
                    } while (x < 4 || x > 20);                     
                    // Lancer du dé 
                    resultat = rand.nextInt(x) + 1;
                    System.out.println("Résultat du lancer : " + resultat); 
                    break;
                    
                case 2:
                    System.out.println("Entrez votre nombre de points : ");
                    points = sc.nextInt();
                    
                    if (points < 0) {
                    	System.out.println("Erreur : Le nombre de points ne peut pas être négatif.");
                    } 
                    else if (points < 100) {
                    	System.out.println("Rang : Bronze");
                    } 
                    else if (points <= 499) {
                    	System.out.println("Rang : Argent");                    	
                    }
                    else if (points <= 1499) {
                    	System.out.println("Rang : Or");
                    }
                    else {
                        System.out.println("Rang : Légende");
                    }                  
                    break;
                
                case 3:
                    System.out.println("Option 3 : Test de coup critique");
                    break;
                    
                default:
                    System.out.println("Donnée incorrecte, veuillez taper un nombre entre 0 et 3");  
            }
                
        } while (choix != 0);
    }   

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }
}