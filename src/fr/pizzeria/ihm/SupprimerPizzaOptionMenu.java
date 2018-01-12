package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.dao.Pizzajdbc;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY2
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {

	private Scanner scanner;
	private Pizzajdbc dao;

	/**
	 * @param scanner
	 * @param dao
	 */
	public SupprimerPizzaOptionMenu(Scanner scanner, Pizzajdbc dao) {
		this.scanner = scanner;
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.pizzeria.ihm.OptionMenu#getLibelle()
	 */
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "4 - Supprimer une pizza";
	}

	public void execute() throws StockageException {

		List<Pizza> pizzas = dao.findAllPizzas();

		for (Pizza pizza : pizzas) {
			LOG.info(pizza.getCode() + " -> " + pizza.getNom() + " " + "(" + pizza.getPrix() + ") "
					+ pizza.getCategoriepizza());
		}

		LOG.info("");
		LOG.info("Veuillez choisir la pizza à supprimer");
		String code = scanner.next();
		if (!dao.pizzaExist(code)) {
			throw new StockageException("le code n'existe pas");
		} else {
			dao.deletePizza(code);
		}

	}

}
