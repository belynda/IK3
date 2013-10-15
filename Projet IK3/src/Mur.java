/**
 * Classe des block qui ne bouge et herite de la clas Case
 * @author Alpha
 * @version 2.6
 */
public class Mur extends Case {
	/**
	 * donne la classe a la qu elle apprtient l element instancier
	 * @param aucun
	 * @return le nom de la classe
	 */
	public String getClasse(){
		return "Mur";
	}
	/**
	 * Constructeur
	 * @param x absisse
	 * @param y ordonnée
	 * @return rien
	 */
	public Mur(int x,int y){
		super(x,y);
	}
}
