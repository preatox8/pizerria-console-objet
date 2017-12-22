package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu{
	
	private Scanner scanner;
	private PizzaDaolmpl dao;

	public ListerPizzasOptionMenu(Scanner scanner, PizzaDaolmpl dao) {
		this.scanner = scanner;
		this.dao = dao;
	}
	
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "1 - Lister les pizzas";
	}

	public void execute(){
		
		List<Pizza> pizzas = dao.findAllPizzas();
		
		for(Pizza pizza : pizzas) {
			System.out.println(pizza.getCode() + " -> "+ pizza.getNom() + " "+ "(" + pizza.getPrix() + ") " + pizza.getCategoriepizza());
		}
	}	
}