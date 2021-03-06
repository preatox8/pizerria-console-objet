package fr.pizzeria.dao;

import java.util.List;


import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	public List<Pizza> findAllPizzas() throws StockageException;

	public void saveNewPizza(Pizza pizzas) throws StockageException;

	public void updatePizza(String modifpizza, Pizza p) throws StockageException;

	public void deletePizza(String code) throws StockageException;
}
