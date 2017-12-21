package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		PizzaDaolmpl dao = new PizzaDaolmpl();
		ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(scanner, dao);
		AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(scanner, dao);
		ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(scanner, dao);
		SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(scanner, dao);

		int choixmenu = 0;
		while (choixmenu != 99) {

			System.out.println("***** Pizzerria Administration *****");
			System.out.println(lister.getLibelle());
			System.out.println(ajouter.getLibelle());
			System.out.println(modifier.getLibelle());
			System.out.println(supprimer.getLibelle());
			System.out.println("99 - Sortir");

			choixmenu = scanner.nextInt();

			try {
				if(choixmenu == 1 || choixmenu == 2 || choixmenu == 3 || choixmenu == 4 || choixmenu == 99) {
					switch (choixmenu) {
					case 1:
						lister.execute();
						break;
					case 2:
						ajouter.execute();
						break;
					case 3:
						modifier.execute();
						break;
					case 4:
						supprimer.execute();
						break;
					case 99:
						System.out.println("Au revoir");
						break;
					}
				}else {
					throw new SavePizzaException("veuillez choisir une des options proposés");
				}
				
			} catch (SavePizzaException | UpdatePizzaException | DeletePizzaException e) {
				System.out.println(e.getMessage());
			}
			catch (NumberFormatException e) {
				System.out.println("Veuillez saisir que des chiffres");
			}

			

		}
		
		scanner.close();
	}

}
