package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans_Viande");

	private CategoriePizza(String categorie) {
		this.categorie = categorie;
	}

	private String categorie;

	public static CategoriePizza getCategorie(int cat) {
		if (cat == 1) {
			return CategoriePizza.VIANDE;
		}
		else if(cat == 2) {
			return CategoriePizza.POISSON;
		}
		else  {
			return CategoriePizza.SANS_VIANDE;
		}
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}
