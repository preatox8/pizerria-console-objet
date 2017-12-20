package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizza.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu{

	private Scanner scanner;
	private Pizza[] pizzas;

	public AjouterPizzaOptionMenu(Scanner scanner, Pizza[] pizzas) {
		this.scanner = scanner;
		this.pizzas = pizzas;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "2 - Ajouter les pizzas";
	}

	public void execute(){
		
		System.out.println("Veuillez saisir le code");
		String codepizza = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nompizza = scanner.next();
		System.out.println("Veuillez saisir le prix");
		Double prixpizza = scanner.nextDouble();
		System.out.println("");

		for(int i = 0; i<pizzas.length; i++){
			if(pizzas[i] == null) {
				pizzas[i] = new Pizza(codepizza, nompizza, prixpizza);
				break;
			}
		}
	}

	
}
