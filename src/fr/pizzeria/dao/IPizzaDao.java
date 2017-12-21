package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	public List<Pizza> findAllPizzas();
	public void saveNewPizza(Pizza pizzas) throws StockageException;
	public void updatePizza(String modifpizza, Pizza p) throws StockageException;
	public void deletePizza(String code) throws StockageException;
}
