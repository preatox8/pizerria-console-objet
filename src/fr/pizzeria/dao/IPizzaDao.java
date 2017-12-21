package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	public void saveNewPizza(Pizza pizzas) throws SavePizzaException;
	public void updatePizza(String modifpizza, Pizza p) throws UpdatePizzaException;
	public void deletePizza(String code) throws DeletePizzaException;
}
