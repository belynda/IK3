/**
 * Classe du plateaux de jeu et de stockage des blocs
 * @author Alpha 
 * @version 2.6
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {
	protected int nbreDeCoup=0;
	public Case[][] chalenge= new Case [5][6];
	public InfosBlock masterChalenge = new InfosBlock();
	public  Case[][] plateau = new Case[10][10];
	public  ArrayList<InfosBlock> tableauDeBlock = new ArrayList<InfosBlock>();
	/**
	 * Constructeur qui prend les indices de chaque blocks positionner dans le plateau
	 * dans un fichier texte 
	 * @param aucun
	 * @return void
	 */
	public Plateau(String file){
		DataInputStream dis;
			try{
				dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(file))));
				try{
					for(int i=0;i<(10*10);i++){
						int x=dis.readInt();
						int y=dis.readInt();
						char c=dis.readChar();
						if(c=='V'){
							plateau[x][y]=new Case(x,y);
						}else{ 
								if(c=='M'){
									plateau[x][y]=new Mur(x,y);
								}else{
									plateau[x][y]=new Brique(x,y);
									}			
							}
					} 
					miseAJourTableauDeBlock();
					this.masterChalenge.ajouter(0,1);
					this.masterChalenge.ajouter(1,1);
					this.masterChalenge.ajouter(2,0);
					this.masterChalenge.ajouter(2,1);
					this.masterChalenge.ajouter(2,2);
					this.chalenge[0][1]= new Case(0,1);
					this.chalenge[1][1]= new Case(1,1);
					this.chalenge[2][0]= new Case(2,0);
					this.chalenge[2][1]= new Case(2,1);
					this.chalenge[2][2]= new Case(2,2);
					
					}catch (EOFException e) {
					// c'est fini !
						System.out.println("fichier charg�e avec succes");
					}finally{
						dis.close();
				}
			}catch (FileNotFoundException e) {
				System.out.println("fichier non trouver");
			} 
			catch (IOException e) {
				System.out.println("fichier charg�e avec succes");
			}
			
	}
	
	/**
	 * Deplace les blocs en haut
	 * @param aucun
	 * @return void
	 */
	public void deplacerEnHaut(){
		if(tableauDeBlock.isEmpty()){
			System.out.println("Eurreur de chargement du jeu! Pas de brique");
			return ;
		}else{
			for(int i=0; i<tableauDeBlock.size();i++){	
				if( peuBougerEnHaut(tableauDeBlock.get(i)) ){
					
					for(int j=0;j<tableauDeBlock.get(i).taille();j++){
						int x=tableauDeBlock.get(i).get(j).x;
						int y=tableauDeBlock.get(i).get(j).y;
						plateau[x][y]=new Case(x,y);
					 }
					tableauDeBlock.get(i).decreX();
					for(int j=0;j<tableauDeBlock.get(i).taille();j++){
						int x=tableauDeBlock.get(i).get(j).x;
						int y=tableauDeBlock.get(i).get(j).y;						
						plateau[x][y]=new Brique(x,y);
					 }
				}
			}
			nbreDeCoup++;
			this.miseAJourBlock();
		}
	
				
	}// fin Deplacer en haut
	/**
	 * Deplace les blocs en bas
	 * @param aucun
	 * @return void
	 */
	public void deplacerEnBas(){
		if(tableauDeBlock.isEmpty()){
			System.out.println("Eurreur de chargement du jeu! Pas de brique");
			return ;
		}else{
			for(int i=0; i<tableauDeBlock.size();i++){	
				if( peuBougerEnBas(tableauDeBlock.get(i)) ){
					for(int j=0;j<tableauDeBlock.get(i).taille();j++){
						int x=tableauDeBlock.get(i).get(j).x;
						int y=tableauDeBlock.get(i).get(j).y;
						plateau[x][y]=new Case(x,y);
					 }
					tableauDeBlock.get(i).increX();
					for(int j=0;j<tableauDeBlock.get(i).taille();j++){
						int x=tableauDeBlock.get(i).get(j).x;
						int y=tableauDeBlock.get(i).get(j).y;						
						plateau[x][y]=new Brique(x,y);
					 }
				}
			}
			nbreDeCoup++;
			this.miseAJourBlock();
		}
	
				
	}// fin Deplacer a Bas
	/**
	 * Deplace les blocs a gauche
	 * @param aucun
	 * @return void
	 */
	public void deplacerAGauche(){
		if(tableauDeBlock.isEmpty()){
			System.out.println("Eurreur de chargement du jeu! Pas de brique");
			return ;
		}else{
			for(int i=0; i<tableauDeBlock.size();i++){	
				if( peuBougerAGauche(tableauDeBlock.get(i)) ){
					for(int j=0;j<tableauDeBlock.get(i).taille();j++){
						int x=tableauDeBlock.get(i).get(j).x;
						int y=tableauDeBlock.get(i).get(j).y;
						plateau[x][y]=new Case(x,y);
					 }
					tableauDeBlock.get(i).increY();
					for(int j=0;j<tableauDeBlock.get(i).taille();j++){
						int x=tableauDeBlock.get(i).get(j).x;
						int y=tableauDeBlock.get(i).get(j).y;						
						plateau[x][y]=new Brique(x,y);
					 }
					
				}
			}
			nbreDeCoup++;
			this.miseAJourBlock();
		}
	
				
	}// fin Deplacer a Gauche
	/**
	 * Deplace les blocs a droite
	 * @param aucun
	 * @return void
	 */
	public void deplacerADroite(){
		if(tableauDeBlock.isEmpty()){
			System.out.println("Eurreur de chargement du jeu! Pas de brique");
			return ;
		}else{
			for(int i=0; i<tableauDeBlock.size();i++){	
				if( peuBougerADroite(tableauDeBlock.get(i)) ){
					
					for(int j=0;j<tableauDeBlock.get(i).taille();j++){
						int x=tableauDeBlock.get(i).get(j).x;
						int y=tableauDeBlock.get(i).get(j).y;
						plateau[x][y]=new Case(x,y);
					 }
					tableauDeBlock.get(i).decreY();
					for(int j=0;j<tableauDeBlock.get(i).taille();j++){
						int x=tableauDeBlock.get(i).get(j).x;
						int y=tableauDeBlock.get(i).get(j).y;						
						plateau[x][y]=new Brique(x,y);
					 }
				}
			}
			nbreDeCoup++;
			miseAJourBlock();
		}
	
				
	}// fin Deplacer a Droite
	
	/**
	 * Verifie si un bloc peut bouger en haut.
	 * @param Liste des element permettant le deplacement en haut 
	 * @return vrai(true) si le mouvement est posible le haut vers sinon faut
	 */
	public boolean peuBougerEnHaut(InfosBlock block){
		if(block.estVide()){
			System.out.println("Eureur pas d'element en haut du bloc");
			return false;
		}else{
				for(int i=0;i<block.taille();i++){
					int x=block.get(i).x;
					int y=block.get(i).y;
					block.get(i).etat=(plateau[x-1][y].getClasse().equals("Vide")|| plateau[x-1][y].getClasse().equals("Brique"));
				}
				for(int i=0;i<block.taille();i++){
					if(!block.get(i).etat){
						return false;
					  }
				}
				return true;
		}		
	}//fin bouger en haut
	
	public boolean peuBougerEnBas(InfosBlock block){
		if(block.estVide()){
			System.out.println("Eureur pas d'element en haut du bloc");
			return false;
		}else{
				for(int i=0;i<block.taille();i++){
					int x=block.get(i).x;
					int y=block.get(i).y;
					block.get(i).etat=(plateau[x+1][y].getClasse().equals("Vide")|| plateau[x+1][y].getClasse().equals("Brique"));			
				}
				for(int i=0;i<block.taille();i++){
					if(!block.get(i).etat){
						return false;
					  }				
				}
				return true;
		}		
	}//fin bouger en bas
	
	public boolean peuBougerAGauche(InfosBlock block){
		if(block.estVide()){
			System.out.println("Eureur pas d'element en haut du bloc");
			return false;
		}else{
				for(int i=0;i<block.taille();i++){
					int x=block.get(i).x;
					int y=block.get(i).y;
					block.get(i).etat=(plateau[x][y+1].getClasse().equals("Vide")|| plateau[x][y+1].getClasse().equals("Brique"));
			
				}
				for(int i=0;i<block.taille();i++){
					if(!block.get(i).etat){
						return false;
					}
				}
				return true;
		}		
	}//fin bouger A gauche
	
	public boolean peuBougerADroite(InfosBlock block){
		if(block.estVide()){
			System.out.println("Eureur pas d'element en haut du bloc");
			return false;
		}else{
				for(int i=0;i<block.taille();i++){
					int x=block.get(i).x;
					int y=block.get(i).y;
					block.get(i).etat=(plateau[x][y-1].getClasse().equals("Vide")|| plateau[x][y-1].getClasse().equals("Brique"));					
				}
				for(int i=0;i<block.taille();i++){
						if(!block.get(i).etat){
							return false;
						}
				}
				return true;
		}		
	}//fin bouger A Droite

	/** Fusion deux bloc en metant a jour les elements de directionnements haut bas gauche et droite.
	 * @param block1 represente le premier block 
	 * @param block2 represente le deuxieme block 
	 * @return void
	 */
	public void fusionBlock(int i,int j){
		 tableauDeBlock.get(i).ajouter(tableauDeBlock.get(j));;
		 tableauDeBlock.remove(j);

	}//fin fusion
	/**
	 * actualise les elements de haut lors du fusion de deux blocks.
	 * @param block1 represente le haut du premier block 
	 * @param block2 represente le haut deuxieme block 
	 * @return les nouveaux elements du haut
	 */
	
	public int indiceDuBloc(int x,int y){
		for(int i=0;i<tableauDeBlock.size();i++){
			if(tableauDeBlock.get(i).contient(x, y)){
				return i;
			}
		}
		return -1;
	}
	/**
	 * verifie si la partie est fini
	 * @param aucun
	 * @return vrai si il reste q un seule bloc
	 */
	public boolean partiEstFini(){
		return tableauDeBlock.size()==1;
	}
	/**
	 * affiche juste le plateau de jeu
	 * @param aucun
	 * @return void
	 */
	public  void affichePlateau(){
		for(Case[] l:plateau){
			for(Case v: l){
				if(v.getClasse().equalsIgnoreCase("vide")){
					System.out.print("  ");
				}else{
					if(v.getClasse().equalsIgnoreCase("mur")){
						System.out.print("X ");
					}else{
						System.out.print("B ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public  void afficheTableauDeBloc(){
		for(InfosBlock ib: tableauDeBlock){
			ib.affiche(); 
		}
	}

	public  void miseAJourTableauDeBlock(){
		for(int i=0;i<plateau.length;i++){
			for(int j=0;j<plateau[i].length;j++){
				if(plateau[i][j].getClasse().equals("Brique")){
					tableauDeBlock.add(new InfosBlock(i,j));
				}
			}
		}
		miseAJourBlock();
	}

	public void miseAJourBlock(){
		for(int i=0; i<tableauDeBlock.size()-1;i++){
			for(int j=i+1; j<tableauDeBlock.size();j++){					
				if( tableauDeBlock.get(i).adjacent(tableauDeBlock.get(j).block) ){
					fusionBlock(i,j);
					i=0;
				}
			}
		}
	}// miseAjour A Block
	
	public void sauvegardePartie(){
		 DataInputStream dis;
		    DataOutputStream dos;
		    try {
		      dos = new DataOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File("fichier/file1.txt"))));
		    
		      for(int i=0;i<11;i++){
					for(int j=0;j<13;j++){
						dos.writeInt(i);
					    dos.writeInt(j);
						if(i==0 || j==0 ||i==11 || j==13){						      
						      dos.writeChar('M');					     					      
						}else{
							char c;
							 c=plateau[i][j].getClasse().toUpperCase().charAt(0);
							dos.writeChar(c);
							
						}
					}
		      }
		      dos.close();
		  
		        	
		      //On r�cup�re maintenant les donn�es !
		      dis = new DataInputStream(
		              new BufferedInputStream(
		                new FileInputStream(
		                  new File("fichier/file.txt"))));
		     for(int i=0;i<100;i++){      
			      System.out.println(dis.readInt());
			      System.out.println(dis.readInt());
			      System.out.println(dis.readChar());
		     }
		        	
		    } catch (FileNotFoundException e) {
		    	e.printStackTrace();
		    } catch (IOException e) {
		    	System.out.print("Fin de fichier ");
		    }     	
		
	}// fin sauvegarde
	
	public int nombreDeCoup(){
		return nbreDeCoup;
	}
	
	public boolean masterChalenger(){
		InfosBlock aux= tableauDeBlock.get(0).cloneB();
		InfosBlock t=aux.transition();
		t.trie();
		
		return (t.egale(this.masterChalenge));
	}
}//fin classe








