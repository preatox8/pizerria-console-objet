package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.MySQLConnection;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class Pizzajdbc implements IPizzaDao {

	public static Logger LOG = (Logger) LoggerFactory.getLogger(Pizzajdbc.class);

	ResourceBundle properties = ResourceBundle.getBundle("jdbc");
	String drivername = properties.getString("DriverName");
	String url = properties.getString("Url");
	String login = properties.getString("Login");
	String password = properties.getString("Password");

	public Pizzajdbc() {

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() throws StockageException {

		List<Pizza> pizzas = new ArrayList<>();
		Connection myconnection = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			
			/**
			 * Connexion à la base de donnée et préparation de la requete SELECT
			 * pour afficher la liste de pizza
			 */
			Class.forName(drivername);
			myconnection = DriverManager.getConnection(url, login, password);
			statement = myconnection.createStatement();
			resultat = statement.executeQuery("SELECT * FROM Pizzas");
			
			/**
			 * Récupération des données
			 */
			while (resultat.next()) {
				Integer id = resultat.getInt("id");
				String code_pizzas = resultat.getString("code_pizzas");
				String nom_pizzas = resultat.getString("nom_pizzas");
				Double prix_pizzas = resultat.getDouble("prix_pizzas");
				CategoriePizza cat_pizzas = CategoriePizza
						.valueOf(resultat.getString("categorie_pizzas").toUpperCase());

				Pizza p = new Pizza(id, code_pizzas, nom_pizzas, prix_pizzas, cat_pizzas);
				pizzas.add(p);
			}

			/**
			 * Traitement des messages d'erreurs selon leurs types
			 */
		} catch (SQLException e) {
			throw new StockageException("Une erreur d'accès s'est produite : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (resultat != null) {
				try {
					resultat.close();
				} catch (SQLException e1) {
					LOG.error(e1.getMessage());
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e2) {
					LOG.error(e2.getMessage());
				}
			}

			if (myconnection != null) {
				try {
					myconnection.close();
				} catch (SQLException e3) {
					LOG.error(e3.getMessage());
				}
			}
		}
		return pizzas;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public void saveNewPizza(Pizza pizza) throws StockageException {

		try(Connection myConnection = DriverManager.getConnection(url, login, password); 
				Statement statement = myConnection.createStatement();
				PreparedStatement resultat = myConnection.prepareStatement(
						"INSERT INTO Pizzas(code_pizzas, nom_pizzas, prix_pizzas, categorie_pizzas) VALUES (?,?,?,?);");){
			
			Class.forName(drivername);
			resultat.setString(1, pizza.getCode());
			resultat.setString(2, pizza.getNom());
			resultat.setDouble(3, pizza.getPrix());
			resultat.setString(4, String.valueOf(pizza.getCategoriepizza()));
			resultat.executeUpdate();

			LOG.info("pizza inséré");

			/**
			 * Traitement des messages d'erreurs selon leurs types
			 */
		} catch (SQLException e) {
			throw new StockageException("Une erreur d'accès s'est produite : " + e.getMessage());
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	@Override
	public void updatePizza(String modifpizza, Pizza p) throws StockageException {

		try (Connection	myConnection = DriverManager.getConnection(url, login, password);
				Statement statement = myConnection.createStatement();
				PreparedStatement resultat = myConnection.prepareStatement(
						"UPDATE Pizzas SET code_pizzas=?, nom_pizzas=?, prix_pizzas=?, categorie_pizzas=? WHERE code_pizzas=?");){
			
			Class.forName(drivername);
			resultat.setString(1, p.getCode());
			resultat.setString(2, p.getNom());
			resultat.setDouble(3, p.getPrix());
			resultat.setString(4, String.valueOf(p.getCategoriepizza()));
			resultat.setString(5, modifpizza);
			resultat.executeUpdate();

			LOG.info("pizza modifié");

			/**
			 * Traitement des messages d'erreurs selon leurs types
			 */
		} catch (SQLException e) {
			throw new StockageException("Une erreur d'accès s'est produite : " + e.getMessage());
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deletePizza(String code) throws StockageException {

		try (Connection	myConnection = DriverManager.getConnection(url, login, password);
				Statement statement = myConnection.createStatement();
				PreparedStatement resultat = myConnection.prepareStatement("DELETE FROM Pizzas WHERE code_pizzas=?;");){
			
			Class.forName(drivername);
			resultat.setString(1, code);
			resultat.executeUpdate();

			LOG.info("pizza supprimé");

			/**
			 * Traitement des messages d'erreurs selon leurs types
			 */
		} catch (SQLException e) {
			throw new StockageException("Une erreur d'accès s'est produite : " + e.getMessage());
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param codeAModif
	 * @return
	 * @throws StockageException
	 */
	public boolean pizzaExist(String codeAModif) throws StockageException {

		List<Pizza> pizzas = new ArrayList<>();
		pizzas = findAllPizzas();

		for (Pizza pizza : pizzas) {
			if (pizza != null && pizza.getCode().equals(codeAModif)) {
				return true;
			}
		}
		return false;
	}

}
