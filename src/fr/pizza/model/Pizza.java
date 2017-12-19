package fr.pizza.model;

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
	
	
	/** Constructeur: l'id est généré avec un compteur
	 * @param code code
	 * @param nom nom
	 * @param prix prix
	 */
	public Pizza(String code, String nom, double prix) {
		this.id = 0;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
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
	
	
}
