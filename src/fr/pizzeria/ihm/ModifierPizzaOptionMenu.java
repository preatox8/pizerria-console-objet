package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{

	private Scanner scanner;
	private PizzaDaolmpl dao;
	

	public ModifierPizzaOptionMenu(Scanner scanner, PizzaDaolmpl dao) {
		this.scanner = scanner;
		this.dao = dao;
	}
	
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "3 - Mettre à jour une pizza";
	}

	public void execute(){
		
		Pizza[] pizzas = dao.findAllPizzas();
		
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
					Pizza p = new Pizza(modifcodepizza, modifnompizza, modifprixpizza);			
					dao.updatePizza(modifpizza, p);
				}
			}
		}
							
		
	}

}
