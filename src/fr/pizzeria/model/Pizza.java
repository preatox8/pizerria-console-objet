package fr.pizzeria.model;

/**
 * @author ETY2
 *
 */
/**
 * @author ETY2
 *
 */
public class Pizza {
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categoriepizza;
	
	public static int compteur = 0;
	
	public Pizza() {
		
	}
	
	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
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
	
	public String toString(CategoriePizza categoriePizza) {
		String cat =  categoriePizza.getCategorie();
		return cat;
	}

	public CategoriePizza getCategoriepizza() {
		return categoriepizza;
	}

	public void setCategoriepizza(CategoriePizza categoriepizza) {
		this.categoriepizza = categoriepizza;
	}
	
	
}
