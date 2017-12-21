package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	public void saveNewPizza(Pizza pizzas);
	public void updatePizza(String modifpizza, Pizza p);
	public void deletePizza(String code);
}
