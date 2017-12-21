package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.exception.DeletePizzaException;
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

	public void execute() throws DeletePizzaException{
		
		Pizza[] pizzas = dao.findAllPizzas();
		
		for(int i = 0; i<pizzas.length; i++){
			if(pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + ")");
			}
		}
		
		System.out.println("");
		System.out.println("Veuillez choisir la pizza à supprimer");
		String code = scanner.next();
		if(!dao.pizzaExist(code)) {
			throw new DeletePizzaException("le code n'existe pas");
		}else {
			dao.deletePizza(code);
		}
		
	}

}
