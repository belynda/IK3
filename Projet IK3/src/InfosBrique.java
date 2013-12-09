
/**
 * Classe qui stoke les infos d'un block. structure
 * @author Alpha
 * @version 2.6
 */
public class InfosBrique {
	public int x;
	public int y;
	public boolean etat;
	
	public InfosBrique(int x, int y){
		this.x=x;
		this.y=y;
		this.etat=false;
	}
	
	public InfosBrique(InfosBrique b){
		this.x=b.x;
		this.y=b.y;
		this.etat=b.etat;
	}
	
	public void affiche(){
		System.out.print("x:"+x+"y:"+y+"\n");
	}
}
