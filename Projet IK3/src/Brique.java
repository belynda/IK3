/**
 * Classe Objet qui bouge qui herite de Mure 
 * @author Alpha
 * @version 2.6
 */
public class Brique extends Case{
	boolean etat;
	String couleur;
	/**
	 * Constructeur
	 * @param x absisse
	 * @param y ordonnée
	 * @param couleur de l element
	 * @return rien
	 */
	public Brique(int x,int y,String coul){
		super(x,y);
		this.etat=true;
		this.couleur=coul;
	}
	public Brique(int x,int y){
		super(x,y);
		this.etat=true;
	}
	/**
	 * donne la classe a la qu elle apprtient l element instancier
	 * @param aucun
	 * @return le nom de la classe
	 */
	public String getClasse(){
		return "Brique";
	}
}
