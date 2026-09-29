import java.util.Random;
import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in); 
    Random rand = new Random();
    int x;
    int resultat;
    int points;
    int totalCritiques;
    double pourcentage;
    int serieActuelle;   
    int plusLongueSerie;


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
                	totalCritiques = 0;
                	serieActuelle = 0;
                	plusLongueSerie = 0;

                    System.out.println("Option 3 : Test de coup critique");
                    for (int i = 0; i < 10000; i++) {
                        if (rand.nextInt(100) < 15) {
                            totalCritiques++;
                            serieActuelle++;
                            
                            // On vérifie le record seulement si c est un critique
                            if (serieActuelle > plusLongueSerie) {
                                plusLongueSerie = serieActuelle;
                            }
                        } else {
                            // si ce n'est pas un critique, on arrete
                            serieActuelle = 0;
                        }
                    }
                    //pourcentage réel
                    pourcentage = (totalCritiques / 10000.0) * 100;
                    		
                    //affichage
                    System.out.println("Nombre de coup critique : " + totalCritiques + " / 10 000");
                    System.out.println("pourcentage réel obtenu : " + pourcentage + "%");
                    System.out.println("la plus longue serie est  : " + plusLongueSerie);

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