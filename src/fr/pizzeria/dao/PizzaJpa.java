package fr.pizzeria.dao;

import java.util.List;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaJpa implements IPizzaDao{

	public static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria");
	}
	
	
	@Override
	public List<Pizza> findAllPizzas() throws StockageException {
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizzas) throws StockageException {
		
	}

	@Override
	public void updatePizza(String modifpizza, Pizza p) throws StockageException {
		
	}

	@Override
	public void deletePizza(String code) throws StockageException {
		
	}

}
