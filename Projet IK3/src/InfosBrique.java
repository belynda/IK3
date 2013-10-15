
/**
 * Classe qui stoke les infos d'un block. structure
 * @author Alpha
 * @version 2.6
 */
public class InfosBrique {
	protected int x;
	protected int y;
	protected boolean etat;
	
	public InfosBrique(int x, int y){
		this.x=x;
		this.y=y;
		this.etat=true;
	}
	
	public void affiche(){
		System.out.println("x:"+x+"y:"+y);
	}
}
