package fr.pizzeria.ihm;

import java.text.Format;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
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
				LOG.info((pizza.getCode() + " -> "+ pizza.getNom() + " "+ "(" + pizza.getPrix() + ") " + pizza.getCategoriepizza()));
			}
		
			LOG.info("Veuillez saisir le code");
			String codepizza = scanner.next();
			if (codepizza.length() > 3 ) {
				throw new StockageException("Le code doit etre constituer de 3 lettres ou moins.");
			}
			LOG.info("Veuillez saisir le nom (sans espace)");
			String nompizza = scanner.next();
			LOG.info("Veuillez saisir le prix");
			String strprixpizza = scanner.next();
			Double prixpizza = Double.parseDouble(strprixpizza);
			if (prixpizza<=0 && prixpizza != null && prixpizza instanceof Double) {
				throw new StockageException("Le prix doit �tre strictement positif.");
			}
			LOG.info("Veuillez saisir la cat�gorie de la pizza");
			LOG.info("1 - VIANDE");
			LOG.info("2 - POISSON");
			LOG.info("3 - SANS_VIANDE");
			Integer categoriepizza = scanner.nextInt();
			LOG.info("");
			Pizza pizza = new Pizza(codepizza, nompizza, prixpizza, CategoriePizza.getCategorie(categoriepizza));
			if(codepizza instanceof String && nompizza instanceof String && prixpizza instanceof Double) {
				dao.saveNewPizza(pizza);
			}
	
	}

}
