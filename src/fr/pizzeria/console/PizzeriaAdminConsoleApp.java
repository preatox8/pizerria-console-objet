package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizza.model.Pizza;

public class PizzeriaAdminConsoleApp {
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Pizza[] pizza = new Pizza[100];
		pizza[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizza[1] = new Pizza("MAR", "Margherita", 14.00);
		pizza[2] = new Pizza("REIN", "La reine", 11.50);
		pizza[3] = new Pizza("FRO", "la 4 fromage", 12.00);
		pizza[4] = new Pizza("CAN", "la cannibale", 12.50);
		pizza[5] = new Pizza("SAV", "la savoyarde", 13.00);
		pizza[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizza[7] = new Pizza("IND", "L'indienne", 14.00);
		System.out.println("");

		
		int choixmenu = 0;
		int temp = 0;
		
		
		while(choixmenu !=99) {
			
			System.out.println("");
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("");
			System.out.println(" 1. Lister les pizzas ");
			System.out.println(" 2. Ajouter une nouvelle pizza ");
			System.out.println(" 3. Mettre à jour une pizza ");
			System.out.println(" 4. Supprimer une pizza ");
			System.out.println(" 99. Sortir ");
			System.out.println("");
		
			
			choixmenu = scanner.nextInt() ;
			
			
			
			switch (choixmenu) {
			
				case 1: 
					for(int i = 0; i<pizza.length; i++){
						if(pizza[i] != null) {
							System.out.println(pizza[i].getCode() + " -> " + pizza[i].getNom() + " (" + pizza[i].getPrix() + ")");
						}
					}
					
					// Une fois une pizza ajouter faire molette haut pour voir la liste 		
					break;
					
				case 2:
					System.out.println("Veuillez saisir le code");
					String codepizza = scanner.next();
					System.out.println("Veuillez saisir le nom (sans espace)");
					String nompizza = scanner.next();
					System.out.println("Veuillez saisir le prix");
					Double prixpizza = scanner.nextDouble();
					System.out.println("");

					for(int i = 0; i<pizza.length; i++){
						if(pizza[i] == null) {
							pizza[i] = new Pizza(codepizza, nompizza, prixpizza);
							break;
						}
					}
					break;
					
				case 3:
					for(int i = 0; i<pizza.length; i++){
						if(pizza[i] != null) {
							System.out.println(pizza[i].getCode() + " -> " + pizza[i].getNom() + " (" + pizza[i].getPrix() + ")");
						}
					}
					
					System.out.println("");
					System.out.println("Veuillez choisir la pizza à modifier");
					String modifpizza = scanner.next();
										
					for(int i = 0; i<pizza.length; i++){
							if(pizza[i] != null) {
								if(pizza[i].getCode().equals(modifpizza)) {
									System.out.println("Veuillez saisir le code");
									String modifcodepizza = scanner.next();
									System.out.println("Veuillez saisir le nom (sans espace)");
									String modifnompizza = scanner.next();
									System.out.println("Veuillez saisir le prix");
									Double modifprixpizza = scanner.nextDouble();
									pizza[i] = new Pizza(modifcodepizza, modifnompizza, modifprixpizza);
								}
							}
					}
					
					break;
					
				case 4:
					for(int i = 0; i<pizza.length; i++){
						if(pizza[i] != null) {
							System.out.println(pizza[i].getCode() + " -> " + pizza[i].getNom() + " (" + pizza[i].getPrix() + ")");
						}
					}
					
					System.out.println("");
					System.out.println("Veuillez choisir la pizza à supprimer");
					String supprpizza = scanner.next();
					
					for(int i = 0; i<pizza.length; i++){
						if(pizza[i] != null) {
							if(pizza[i].getCode().equals(supprpizza)) {
								pizza[i]=null;
							}
						}
					}	
					
					break;
					
				case 99:
					System.out.println("Au revoir");
					break;
					
				default:
					System.out.println("Veuillez choisir un élément du menu");
					break;
			}
		}
		
		
		
		scanner.close();
		
	}

}
