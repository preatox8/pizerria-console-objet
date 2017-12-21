package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu{

	private Scanner scanner;
	private PizzaDaolmpl dao;


	public AjouterPizzaOptionMenu(Scanner scanner, PizzaDaolmpl dao) {
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "2 - Ajouter les pizzas";
	}

	public void execute(){
		
		Pizza[] pizzas = dao.findAllPizzas();
		
		for(int i = 0; i<pizzas.length; i++){
			if(pizzas[i] != null) {
				System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getNom() + " (" + pizzas[i].getPrix() + ")");
			}
		}
		
		System.out.println("Veuillez saisir le code");
		String codepizza = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nompizza = scanner.next();
		System.out.println("Veuillez saisir le prix");
		Double prixpizza = scanner.nextDouble();
		System.out.println("");
		Pizza pizza = new Pizza(codepizza, nompizza, prixpizza);
		dao.saveNewPizza(pizza);
		
	}

	
}
