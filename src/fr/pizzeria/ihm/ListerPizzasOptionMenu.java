package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import fr.pizzeria.dao.Pizzajdbc;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {

	private Scanner scanner;
	private Pizzajdbc dao;

	public ListerPizzasOptionMenu(Scanner scanner, Pizzajdbc dao) {
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "1 - Lister les pizzas";
	}

	public void execute() throws StockageException {

		List<Pizza> pizzas = dao.findAllPizzas();

		for (Pizza pizza : pizzas) {
			LOG.info((pizza.getCode() + " -> " + pizza.getNom() + " " + "(" + pizza.getPrix() + ") "
					+ pizza.getCategoriepizza()));
		}
	}
}