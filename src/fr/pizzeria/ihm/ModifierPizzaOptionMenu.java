package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

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

	public void execute() throws UpdatePizzaException {

		Pizza[] pizzas = dao.findAllPizzas();

		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out
						.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + ")");
			}
		}

		
			System.out.println("");
			System.out.println("Veuillez choisir la pizza à modifier");
			String modifpizza = scanner.next();
			if(dao.pizzaExist(modifpizza) == false) {
				throw new UpdatePizzaException("code inccorrect");
			}
			for (int i = 0; i < pizzas.length; i++) {
				if (pizzas[i] != null) {
					
					
					
					if (pizzas[i].getCode().equals(modifpizza)) {
						System.out.println("Veuillez saisir le code");
						String modifcodepizza = scanner.next();
						if (modifcodepizza.length() > 3 ) {
							throw new UpdatePizzaException("Le code doit etre constituer de 3 lettres ou moins.");
						}
						System.out.println("Veuillez saisir le nom (sans espace)");
						String modifnompizza = scanner.next();
						System.out.println("Veuillez saisir le prix");
						String strmodifprixpizza = scanner.next();
						Double modifprixpizza =  Double.parseDouble(strmodifprixpizza);
						if (modifprixpizza<=0 && modifprixpizza != null && modifprixpizza instanceof Double) {
							throw new UpdatePizzaException("Le prix doit être strictement positif.");
						}
						Pizza p = new Pizza(modifcodepizza, modifnompizza, modifprixpizza);
						if(modifcodepizza instanceof String && modifnompizza instanceof String && modifprixpizza instanceof Double) {
							
							dao.updatePizza(modifpizza, p);
					}
					}
				
				}
			}

	}
}
