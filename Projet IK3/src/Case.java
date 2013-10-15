/**
 * Classe des espaces vides
 * @author Alpha
 * @version 2.6
 */
public class Case {
	int x;
	int y;
	/**
	 * donne la classe a la qu elle apprtient l element instancier
	 * @param aucun
	 * @return le nom de la classe
	 */
	public String getClasse(){
		return "Vide";
	}
	/**
	 * Constructeur
	 * @param x absisse
	 * @param y ordonnée
	 * @return rien
	 */
	public Case(int x, int y){
		this.x=x;
		this.y=y;
	}
}
