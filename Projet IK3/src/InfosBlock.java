/**
 * Classe qui stoke les information d'un bloc.  structure
 * @author Alpha
 * @version 2.6
 */
import java.util.ArrayList;

public class InfosBlock {
	protected ArrayList<InfosBrique> haut;
	protected ArrayList<InfosBrique> bas;
	protected ArrayList<InfosBrique> gauche;
	protected ArrayList<InfosBrique> droite;
	protected ArrayList<InfosBrique> elementRestant;
	
	public InfosBlock(ArrayList<InfosBrique> br){
		this.haut=br;
		this.droite=br;
		this.bas=br;
		this.gauche=br;
	}
	
	public void affiche(ArrayList<InfosBrique> b){
		for(InfosBrique i:b){
			i.affiche();
		}
	}
}
