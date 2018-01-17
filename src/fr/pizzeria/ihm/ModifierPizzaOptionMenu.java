package fr.pizzeria.ihm;


import java.util.List;
import java.util.Scanner;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;
import fr.pizzeria.dao.Pizzajdbc;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	private Scanner scanner;
	private Pizzajdbc dao;

	public ModifierPizzaOptionMenu(Scanner scanner, Pizzajdbc dao) {
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

		for (Pizza pizza : pizzas) {
			LOG.info(pizza.getCode() + " -> " + pizza.getNom() + " " + "(" + pizza.getPrix() + ") "
					+ pizza.getCategoriepizza());
		}

		LOG.info("");
		LOG.info("Veuillez choisir la pizza à modifier");
		String modifpizza = scanner.next();
		if (dao.pizzaExist(modifpizza) == false) {
			throw new StockageException("code inccorrect");
		}
		for (Pizza pizza : pizzas) {

			if (pizza.getCode().equals(modifpizza)) {
				LOG.info("Veuillez saisir le code");
				String modifcodepizza = scanner.next();
				if (modifcodepizza.length() > 3) {
					throw new StockageException("Le code doit etre constituer de 3 lettres ou moins.");
				}
				LOG.info("Veuillez saisir le nom (sans espace)");
				String modifnompizza = scanner.next();
				LOG.info("Veuillez saisir le prix");
				String strmodifprixpizza = scanner.next();
				Double modifprixpizza = Double.parseDouble(strmodifprixpizza);
				if (modifprixpizza <= 0 && modifprixpizza != null && modifprixpizza instanceof Double) {
					throw new StockageException("Le prix doit être strictement positif.");
				}
				LOG.info("Veuillez saisir le chiffre correspondant à la catégorie");
				LOG.info("1 - VIANDE");
				LOG.info("2 - POISSON");
				LOG.info("3 - SANS_VIANDE");
				String categoriepizza = scanner.next();
				Pizza p = new Pizza(modifcodepizza, modifnompizza, modifprixpizza,
						CategoriePizza.getCategorie(categoriepizza));
				if (modifcodepizza instanceof String && modifnompizza instanceof String
						&& modifprixpizza instanceof Double) {

					dao.updatePizza(modifpizza, p);
				}
			}

		}

	}
}
