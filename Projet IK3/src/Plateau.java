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
	
	/** 
	 * contient la figure a faire a la fin dans un tableau
	 * @see Case
	 */
	
	public Case[][] chalenge= new Case [5][6];
	/** 
	 * contient la figure a faire a la fin
	 * @see InfosBlock
	 */
	public InfosBlock masterChalenge = new InfosBlock();
	/** 
	 * tableau contenant les cases
	 * @see InfosBlock
	 */
	public Case[][] plateau = new Case[10][10];
	/** 
	 * contient la figure a faire a la fin
	 * @see InfosBlock
	 */
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
					
					for(int i=0;i<chalenge.length;i++){
						for(int j=0;j<chalenge[i].length;j++){
							chalenge[i][j]= new Case(i,j);
						}
					}
					this.chalenge[0][1]= new Brique(0,1);
					this.chalenge[1][1]= new Brique(1,1);
					this.chalenge[2][0]= new Brique(2,0);
					this.chalenge[2][1]= new Brique(2,1);
					this.chalenge[2][2]= new Brique(2,2);
					
					}catch (EOFException e) {
					// c'est fini !
						System.out.println("fichier chargée avec succes");
					}finally{
						dis.close();
				}
			}catch (FileNotFoundException e) {
				System.out.println("fichier non trouver");
			} 
			catch (IOException e) {
				System.out.println("fichier chargée avec succes");
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
	/**
	 * Verifie si un bloc peut bouger en Bas.
	 * @param Liste des element permettant le deplacement en haut 
	 * @return vrai(true) si le mouvement est posible le haut vers sinon faut
	 */
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
	/**
	 * Verifie si un bloc peut bouger en Gauche.
	 * @param Liste des element permettant le deplacement en haut 
	 * @return vrai(true) si le mouvement est posible le haut vers sinon faut
	 */
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
	/**
	 * Verifie si un bloc peut bouger en Droite.
	 * @param Liste des element permettant le deplacement en haut 
	 * @return vrai(true) si le mouvement est posible le haut vers sinon faut
	 */
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

	/** Fusion le bloc de nemero i et j..
	 * @param i represente le premier block 
	 * @param j represente le deuxieme block 
	 * @return void
	 */
	public void fusionBlock(int i,int j){
		 tableauDeBlock.get(i).ajouter(tableauDeBlock.get(j));;
		 tableauDeBlock.remove(j);

	}//fin fusion
	/**
	 * Reherche l indice du bloc de  l element de cordonnée x,y
	 * @param x c est l abcisse
	 * @param y c est ordonnée
	 * @return l indice du bloc sinon -1( en realité ne retourn jamais -1)
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
	 * affiche juste le plateau de jeu en mode connsole
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
	/**
	 * affiche juste Le master chalenge a realiser en mode connsole
	 * @param aucun
	 * @return void
	 */
	public  void afficheMaster(){
		for(Case[] c:this.chalenge){
			for(Case v: c){
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
	/**
	 * affiche le tableau de bloc en mode console
	 * @param aucun
	 * @return void
	 */
	public  void afficheTableauDeBloc(){
		for(InfosBlock ib: tableauDeBlock){
			ib.affiche(); 
		}
	}
	/**
	 * reupere les bloks de façon individuelle et les met dans le tableau de bloc
	 * @param aucun
	 * @return void
	 */
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
	/**
	 * fusion les block cote  cote apres avoir charger
	 * @param aucun
	 * @return void
	 */
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
	/**
	 * Sauvegarde les emplacements de chaque block
	 * @param aucun
	 * @return void
	 */
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
		  
		        	
		      //On récupère maintenant les données !
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
	/**
	 * Nombre de coup a un moment donnée 
	 * @param aucun
	 * @return nombre coup
	 */
	public int nombreDeCoup(){
		return nbreDeCoup;
	}
	/**
	 *verifie si la configuration de le fin est la meme que le master chalange 
	 * @param aucun
	 * @return nombre coup
	 */
	public boolean masterChalenger(){
		InfosBlock aux= tableauDeBlock.get(0).cloneB();
		InfosBlock t=aux.transition();
		t.trie();
		
		return (t.egale(this.masterChalenge));
	}
}//fin classe








