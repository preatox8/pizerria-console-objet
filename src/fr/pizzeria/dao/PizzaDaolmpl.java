package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PizzaDaolmpl implements IPizzaDao {

	private List<Pizza> listpizza;

	public PizzaDaolmpl() {

		listpizza = new ArrayList();
		listpizza.add(new Pizza("PEP", "Pépéroni", 12.50));
		listpizza.add(new Pizza("MAR", "Margherita", 14.00));
		listpizza.add(new Pizza("REIN", "La reine", 11.50));
		listpizza.add(new Pizza("FRO", "la 4 fromage", 12.00));
		listpizza.add(new Pizza("CAN", "la cannibale", 12.50));
		listpizza.add(new Pizza("SAV", "la savoyarde", 13.00));
		listpizza.add(new Pizza("ORI", "L'orientale", 13.50));
		listpizza.add(new Pizza("IND", "L'indienne", 14.00));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listpizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws StockageException {
		listpizza.add(pizza);
	}

	@Override
	public void updatePizza(String modifpizza, Pizza p) throws StockageException {
		
		for (Pizza pizza : listpizza) {
			if (pizza.getCode().equals(modifpizza)) {
				pizza.setCode(p.getCode());
				pizza.setNom(p.getNom()); 
				pizza.setPrix(p.getPrix());
			}
		}
		
	}

	@Override
	public void deletePizza(String code) throws StockageException {

		Pizza echangepizza = null;

		for (Pizza pizza : listpizza) {
			if (pizza.getCode().equals(code)) {
				echangepizza = pizza;
			}
		}
		listpizza.remove(echangepizza);
	}

	public boolean pizzaExist(String codeAModif) {

		for (Pizza pizza : listpizza) {
			if (pizza != null && pizza.getCode().equals(codeAModif)) {
				return true;
			}
		}
		return false;
	}
}
