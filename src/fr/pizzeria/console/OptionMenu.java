package fr.pizzeria.console;

/**
 * @author ETY2
 *
 */
abstract public class OptionMenu{
	
	protected String libelle;


	/**
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public abstract void execute();

}
