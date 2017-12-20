package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizza.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{

	private Scanner scanner;
	private Pizza[] pizzas;

	public ModifierPizzaOptionMenu(Scanner scanner, Pizza[] pizzas) {
		this.scanner = scanner;
		this.pizzas = pizzas;
	}
	
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "3 - Mettre à jour une pizza";
	}

	public void execute(){
		
		for(int i = 0; i<pizzas.length; i++){
			if(pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + ")");
			}
		}
		
		System.out.println("");
		System.out.println("Veuillez choisir la pizza à modifier");
		String modifpizza = scanner.next();
							
		for(int i = 0; i<pizzas.length; i++){
				if(pizzas[i] != null) {
					if(pizzas[i].getCode().equals(modifpizza)) {
						System.out.println("Veuillez saisir le code");
						String modifcodepizza = scanner.next();
						System.out.println("Veuillez saisir le nom (sans espace)");
						String modifnompizza = scanner.next();
						System.out.println("Veuillez saisir le prix");
						Double modifprixpizza = scanner.nextDouble();
						pizzas[i] = new Pizza(modifcodepizza, modifnompizza, modifprixpizza);
					}
				}
		}
	}

}
