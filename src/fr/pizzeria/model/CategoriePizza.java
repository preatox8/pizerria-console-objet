package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans_Viande");

	/**
	 * @param categorie
	 */
	private CategoriePizza(String categorie) {
		this.categorie = categorie;
	}

	private String categorie;

	/**
	 * @param categoriepizza
	 * @return
	 */
	public static CategoriePizza getCategorie(String categoriepizza) {

		if (categoriepizza.equals("1")) {
			return CategoriePizza.VIANDE;
		} else if (categoriepizza.equals("2")) {
			return CategoriePizza.POISSON;
		} else {
			return CategoriePizza.SANS_VIANDE;
		}
	}

	/**
	 * @return
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}
