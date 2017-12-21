package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
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

	public void execute() throws StockageException {

			List<Pizza> pizzas = dao.findAllPizzas();
			
			for(Pizza pizza : pizzas) {
				System.out.println(pizza.getCode() + " -> "+ pizza.getNom() + " "+ "(" + pizza.getPrix() + ")");
			}

		
			System.out.println("");
			System.out.println("Veuillez choisir la pizza à modifier");
			String modifpizza = scanner.next();
			if(dao.pizzaExist(modifpizza) == false) {
				throw new StockageException("code inccorrect");
			}
			for(Pizza pizza : pizzas) {
				
					
					if (pizza.getCode().equals(modifpizza)) {
						System.out.println("Veuillez saisir le code");
						String modifcodepizza = scanner.next();
						if (modifcodepizza.length() > 3 ) {
							throw new StockageException("Le code doit etre constituer de 3 lettres ou moins.");
						}
						System.out.println("Veuillez saisir le nom (sans espace)");
						String modifnompizza = scanner.next();
						System.out.println("Veuillez saisir le prix");
						String strmodifprixpizza = scanner.next();
						Double modifprixpizza =  Double.parseDouble(strmodifprixpizza);
						if (modifprixpizza<=0 && modifprixpizza != null && modifprixpizza instanceof Double) {
							throw new StockageException("Le prix doit être strictement positif.");
						}
						Pizza p = new Pizza(modifcodepizza, modifnompizza, modifprixpizza);
						if(modifcodepizza instanceof String && modifnompizza instanceof String && modifprixpizza instanceof Double) {
							
							dao.updatePizza(modifpizza, p);
					}
					}
				
				
			}

	}
}
