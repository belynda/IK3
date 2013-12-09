/**
 * Classe qui stoke les information d'un bloc.  structure
 * @author Alpha
 * @version 2.6
 */
import java.util.ArrayList;

public class InfosBlock {
	public ArrayList<InfosBrique> block=new ArrayList<InfosBrique>();
	
	public InfosBlock(ArrayList<InfosBrique> br){
		this.block=br;
	}
	public InfosBlock(){
		this.block=new  ArrayList<InfosBrique>();
	}
	public InfosBlock(int x, int y){
		this.block.add(new InfosBrique(x,y));
	}
	
	public void ajouter(int x, int y){
		this.block.add(new InfosBrique(x,y));
	}
	
	public void affiche(){
		for(InfosBrique i:this.block){
			i.affiche();
		}
		System.out.println();
	}
	//pour la fusion
	public boolean contient(int x,int y){
		for(int i=0;i<this.block.size();i++){
			if(this.block.get(i).x==x && this.block.get(i).y==y){
				return true;
			}
		}
		return false;
	}
	
	public boolean contient(InfosBrique b){
		for(int i=0;i<this.block.size();i++){
			if(this.block.get(i).x==b.x && this.block.get(i).y==b.y){
				return true;
			}
		}
		return false;
	}
	
	public boolean coler(ArrayList<InfosBrique> b){
		for(InfosBrique ib:b){
			if(this.contient(ib)){
				return true;
			}
		}
		return false;
	}
	
	public boolean adjacent(ArrayList<InfosBrique> b){
		ArrayList<InfosBrique> aux=clone(b) ;
		
		for(int i=0;i<aux.size();i++){
			aux.get(i).x++;
		}
		if(this.coler(aux)){
				return true;	
		}else{ 
			for(int i=0;i<aux.size();i++){
				aux.get(i).x=aux.get(i).x-2;
			}
			if(this.coler(aux)){
				return true;
				}else{
					for(int i=0;i<aux.size();i++){
						aux.get(i).x++;
						aux.get(i).y++;
					}
					if(this.coler(aux)){
						return true;
					}else{
						for(int i=0;i<aux.size();i++){
							aux.get(i).y=aux.get(i).y-2;
						}
						if(this.coler(aux)){
							return true;
						}
					}
							
				}				
		}
		
		return false;
	}
	
	public void ajouter(InfosBlock ib){		
		for(InfosBrique i:ib.block){			
			this.block.add(i);
		}
	}
	
	// fin fusion ne sois pas supris si il ya de fonction qui ne sont user
	public boolean estVide(){
		return this.block.isEmpty();
	}
	
	public int taille(){
		return this.block.size();
	}
	
	
	public InfosBrique get(int i){
		return this.block.get(i);
	}
	
	
	public void increX(){
		for(InfosBrique i:block){
			i.x++;
		}
	}
	
	public void increY(){
		for(InfosBrique i:block){
			i.y++;
		}		
	}

	public void decreX(){
		for(InfosBrique i:block){
			i.x--;
		}
	}

	public void decreY(){
		for(InfosBrique i:block){
			i.y--;
		}
	}
	
	public ArrayList<InfosBrique> clone(ArrayList<InfosBrique> b){
		ArrayList<InfosBrique> aib = new ArrayList<InfosBrique>();
		for(int i=0;i<b.size();i++ ){
			aib.add(new InfosBrique(b.get(i).x,b.get(i).y));
		}
		return aib;
	}
	public ArrayList<InfosBrique> clone(){
		ArrayList<InfosBrique> aib = new ArrayList<InfosBrique>();
		for(int i=0;i<this.block.size();i++ ){
			aib.add(new InfosBrique(this.block.get(i).x,this.block.get(i).y));
		}
		return aib;
	}
	
	public InfosBlock cloneB(){
		InfosBlock aib = new InfosBlock();
		for(int i=0;i<this.block.size();i++ ){
			aib.ajouter(this.block.get(i).x, this.block.get(i).y);
		}
		return aib;
	}
	
	public  InfosBlock cloneB(InfosBlock b){
		InfosBlock aib = new InfosBlock();
		for(int i=0;i<b.taille();i++ ){
			aib.block.add(new InfosBrique(b.block.get(i).x ,b.block.get(i).y));
		}
		return aib;
	}
	
	public boolean egale (InfosBlock b){
		if(b.block.size()!=this.block.size()){
			return false;
		}else{
			for(int i=0;i<b.block.size();i++){
				if(!this.contient(b.block.get(i))){
					return false;
				}
			}
			return true;
		}
	}
	
	public  int  minX(){
		int min=this.block.get(0).x; 	
		for(int i=1;i<this.block.size();i++ ){
			if(this.block.get(i).x < min){
				min=this.block.get(i).x;
			}
		}
		return min;
	}
	
	public  int  minY(){
		int min=this.block.get(0).y; 	
		for(int i=1;i<this.block.size();i++ ){
			if(this.block.get(i).y < min){
				min=this.block.get(i).y;
			}
		}
		return min;
	}
	
	public InfosBlock transition(){
		InfosBlock ib = new InfosBlock();
		for(int i=0;i<this.block.size();i++ ){
			ib.ajouter(this.block.get(i).x-this.minX(), this.block.get(i).y-this.minY()); 
			}
		return ib;
	}
	
	public void echange(int i,int j){
		InfosBrique b= new InfosBrique(this.block.get(i));
		this.block.get(i).x=this.block.get(j).x;
		this.block.get(i).y=this.block.get(j).y;
		this.block.get(i).etat=this.block.get(j).etat;
		
		this.block.get(j).x=b.x;
		this.block.get(j).y=b.y;
		this.block.get(j).etat=b.etat;
		
	}
	
	public void trie(){
		for(int i=0;i<this.block.size()-1;i++ ){
			for(int j=i+1;j<this.block.size();j++ ){
				if(this.block.get(i).x > this.block.get(j).x){
						this.echange(i, j);				
					
				}else{
					if(this.block.get(i).x == this.block.get(j).x){
						if(this.block.get(i).y > this.block.get(j).y){
							this.echange(i, j);										
							}

					}
				}
			}
		}
	}//fin trie
	
	
	

}
