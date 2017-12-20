package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizza.model.Pizza;
import fr.pizzeria.console.OptionMenu;

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
		
		
		ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(scanner, pizza);
		AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(scanner, pizza);
	    ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(scanner, pizza);
		SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(scanner, pizza);
		
		int choixmenu = 0;
		while(choixmenu !=99) {
			
			System.out.println("***** Pizzerria Administration *****");
			System.out.println(lister.getLibelle());
			System.out.println(ajouter.getLibelle());
			System.out.println(modifier.getLibelle());
			System.out.println(supprimer.getLibelle());
			System.out.println("99 - Sortir");

			choixmenu = scanner.nextInt() ;
			
			switch (choixmenu) {
				case 1: 
					lister.execute();
					break;
				case 2:
					ajouter.execute();
					break;
				case 3:
					modifier.execute();
					break;
				case 4:
					supprimer.execute();
					break;
				case 99:
					System.out.println("Au revoir");
					break;
			}
		}
		
		
		scanner.close();	
		
	}
	
	public void afficher(){
		
	}

}
