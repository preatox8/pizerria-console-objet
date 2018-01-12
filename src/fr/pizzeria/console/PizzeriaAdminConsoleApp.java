package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.PizzaDaolmpl;
import fr.pizzeria.dao.Pizzajdbc;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {

	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Pizzajdbc dao = new Pizzajdbc();
		ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(scanner, dao);
		AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(scanner, dao);
		ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(scanner, dao);
		SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(scanner, dao);

		int choixmenu = 0;
		while (choixmenu != 99) {

			LOG.info("***** Pizzerria Administration *****");
			LOG.info(lister.getLibelle());
			LOG.info(ajouter.getLibelle());
			LOG.info(modifier.getLibelle());
			LOG.info(supprimer.getLibelle());
			LOG.info("99 - Sortir");

			choixmenu = scanner.nextInt();

			try {
				if (choixmenu == 1 || choixmenu == 2 || choixmenu == 3 || choixmenu == 4 || choixmenu == 99) {
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
						LOG.info("Au revoir");
						break;
					}
				} else {
					throw new StockageException("veuillez choisir une des options proposés");
				}

			} catch (StockageException e) {
				LOG.info((e.getMessage()));
			} catch (NumberFormatException e) {
				LOG.info("Veuillez saisir que des chiffres");
			}
		}

		scanner.close();
	}

}
