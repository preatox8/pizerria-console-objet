package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaolmpl implements IPizzaDao {

	private Pizza[] pizzas;

	public PizzaDaolmpl() {
		pizzas = new Pizza[9];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REIN", "La reine", 11.50);
		pizzas[3] = new Pizza("FRO", "la 4 fromage", 12.00);
		pizzas[4] = new Pizza("CAN", "la cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "la savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00);
	};

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		boolean compare = false;

		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] == null) {
				pizzas[i] = pizza;
				compare = true;
				break;
			}
		}

		if (!compare) {
			throw new SavePizzaException("le tableau est plein");
		}

	}

	@Override
	public void updatePizza(String modifpizza, Pizza p) throws UpdatePizzaException {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				if (pizzas[i].getCode().equals(modifpizza)) {
					pizzas[i] = p;
				}

			}
		}
	}

	@Override
	public void deletePizza(String code) throws DeletePizzaException {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				if (pizzas[i].getCode().equals(code)) {
					pizzas[i] = null;
				}
			}
		}
	}

	public boolean pizzaExist(String codeAModif) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equals(codeAModif)) {
				return true;
			}
		}
		return false;
	}

}
