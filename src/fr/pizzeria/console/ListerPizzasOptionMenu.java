package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizza.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu{
	
	private Scanner scanner;
	private Pizza[] pizzas;

	public ListerPizzasOptionMenu(Scanner scanner, Pizza[] pizzas) {
		this.scanner = scanner;
		this.pizzas = pizzas;
	}
	
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "1 - Lister les pizzas";
	}

	public void execute(){
		
		for(int i = 0; i<pizzas.length; i++){
			if(pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + ")");
			}
		}
	}	
}