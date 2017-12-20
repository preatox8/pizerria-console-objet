package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizza.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu{

	private Scanner scanner;
	private Pizza[] pizzas;

	public SupprimerPizzaOptionMenu(Scanner scanner, Pizza[] pizzas) {
		this.scanner = scanner;
		this.pizzas = pizzas;
	}
	
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "4 - Supprimer une pizza";
	}

	public void execute(){
		
		for(int i = 0; i<pizzas.length; i++){
			if(pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + ")");
			}
		}
		
		System.out.println("");
		System.out.println("Veuillez choisir la pizza à supprimer");
		String supprpizza = scanner.next();
		
		for(int i = 0; i<pizzas.length; i++){
			if(pizzas[i] != null) {
				if(pizzas[i].getCode().equals(supprpizza)) {
					pizzas[i]=null;
				}
			}
		}	
	}

}
