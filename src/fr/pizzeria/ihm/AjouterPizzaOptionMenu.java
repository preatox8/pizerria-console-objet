package fr.pizzeria.ihm;

import java.text.Format;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	private Scanner scanner;
	private PizzaDaolmpl dao;

	public AjouterPizzaOptionMenu(Scanner scanner, PizzaDaolmpl dao) {
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "2 - Ajouter les pizzas";
	}

	public void execute() throws StockageException{
		
			List<Pizza> pizzas = dao.findAllPizzas();
	
			for(Pizza pizza : pizzas) {
				System.out.println(pizza.getCode() + " -> "+ pizza.getNom() + " "+ "(" + pizza.getPrix() + ") " + pizza.getCategoriepizza());
			}
		
			System.out.println("Veuillez saisir le code");
			String codepizza = scanner.next();
			if (codepizza.length() > 3 ) {
				throw new StockageException("Le code doit etre constituer de 3 lettres ou moins.");
			}
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nompizza = scanner.next();
			System.out.println("Veuillez saisir le prix");
			String strprixpizza = scanner.next();
			Double prixpizza = Double.parseDouble(strprixpizza);
			if (prixpizza<=0 && prixpizza != null && prixpizza instanceof Double) {
				throw new StockageException("Le prix doit être strictement positif.");
			}
			System.out.println("Veuillez saisir la catégorie de la pizza");
			System.out.println("1 - VIANDE");
			System.out.println("2 - POISSON");
			System.out.println("3 - SANS_VIANDE");
			Integer categoriepizza = scanner.nextInt();
			System.out.println("");
			Pizza pizza = new Pizza(codepizza, nompizza, prixpizza, CategoriePizza.getCategorie(categoriepizza));
			if(codepizza instanceof String && nompizza instanceof String && prixpizza instanceof Double) {
				dao.saveNewPizza(pizza);
			}
	
	}

}
