package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ETY2
 *
 */

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="CODEPIZZA")
	private String code;
	
	@Column(name="NOMPIZZA")
	private String nom;
	
	@Column(name="PRIXPIZZA")
	private double prix;
	
	@Column(name="CATEGORIEPIZZA")
	private CategoriePizza categoriepizza;

	public static int compteur = 0;

	public Pizza() {

	}

	public Pizza(Integer id2, String code_pizzas, String nom_pizzas, Double prix_pizzas, CategoriePizza cat_pizzas) {

		this.id = compteur++;
		this.code = code_pizzas;
		this.nom = nom_pizzas;
		this.prix = prix_pizzas;
		this.categoriepizza = cat_pizzas;
	}

	/**
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		super();
		this.id = compteur++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriepizza = categorie;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @param categoriePizza
	 * @return
	 */
	public String toString(CategoriePizza categoriePizza) {
		String cat = categoriePizza.getCategorie();
		return cat;
	}

	/**
	 * @return
	 */
	public CategoriePizza getCategoriepizza() {
		return categoriepizza;
	}

	/**
	 * @param categoriepizza
	 */
	public void setCategoriepizza(CategoriePizza categoriepizza) {
		this.categoriepizza = categoriepizza;
	}

}
