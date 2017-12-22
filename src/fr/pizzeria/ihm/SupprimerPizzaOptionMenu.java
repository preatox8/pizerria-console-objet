package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu{

	private Scanner scanner;
	private PizzaDaolmpl dao;


	public SupprimerPizzaOptionMenu(Scanner scanner, PizzaDaolmpl dao) {
		this.scanner = scanner;
		this.dao = dao;
	}
	
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "4 - Supprimer une pizza";
	}

	public void execute() throws StockageException{
		
		List<Pizza> pizzas = dao.findAllPizzas();
		
		for(Pizza pizza : pizzas) {
			System.out.println(pizza.getCode() + " -> "+ pizza.getNom() + " "+ "(" + pizza.getPrix() + ") " + pizza.getCategoriepizza());
		}
		
		System.out.println("");
		System.out.println("Veuillez choisir la pizza à supprimer");
		String code = scanner.next();
		if(!dao.pizzaExist(code)) {
			throw new StockageException("le code n'existe pas");
		}else {
			dao.deletePizza(code);
		}
		
	}

}
