/**
 * Classe du plateaux de jeu et de stockage des blocs
 * @author Alpha 
 * @version 2.6
 */
import java.io.*;
import java.util.ArrayList;

public class Plateau {
	public static Case[][] plateau = new Case[6][6];
	public static ArrayList<InfosBlock> tableauDeBloc = new ArrayList<InfosBlock>();
	/**
	 * Constructeur qui prend les indices de chaque blocks positionner dans le plateau
	 * dans un fichier texte 
	 * @param aucun
	 * @return void
	 */
	/*public Plateau(String file){
		DataInputStream dis;
			try{
				dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(file))));
				try{
					while(true){
						int x=dis.readInt();
						int y=dis.readInt();
						String classe=dis.readUTF();
						if(classe.charAt(0)=='V'){
							plateau[x][y]=new Case(x,y);
						}else{ if(classe.charAt(0)=='M'){
								plateau[x][y]=new Mur(x,y);
							}else{
								String coul=dis.readUTF();
								plateau[x][y]=new Brique(x,y,coul);
								InfosBrique br= new InfosBrique(x,y);
								ArrayList<InfosBrique> ab= new ArrayList<InfosBrique>();
								ab.add(br);
								InfosBlock bl= new InfosBlock(ab);
								tableauDeBloc.add(bl);
							}			
						}
					} 
					}catch (EOFException e) {
					// c'est fini !
						System.out.println("fichier chargée avec succes");
					}finally{
						dis.close();
				}
			}catch (FileNotFoundException e) {
				System.out.println("fichier non trouver");
			} 
			catch (IOException e) {  }
			
	}*/
	
	/**
	 * Deplace les blocs en haut
	 * @param aucun
	 * @return void
	 */
	public void deplacerEnHaut(){
		if(tableauDeBloc.isEmpty()){
			System.out.println("Eurreur de chargement du jeu! Pas de brique");
			return ;
		}else{
			for(int i=0; i<tableauDeBloc.size();i++){	
				if( bougerEnHaut(tableauDeBloc.get(i).haut) ){
					for(int j=0; j<tableauDeBloc.get(i).haut.size();j++){					
						tableauDeBloc.get(i).haut.get(j).y--;
						tableauDeBloc.get(i).haut.get(j).etat=true;
						int x=tableauDeBloc.get(i).bas.get(j).x;
						int y=tableauDeBloc.get(i).bas.get(j).y;
						plateau[x][y]=plateau[x][y-1];
						plateau[x][y+1]=new Case(x,y+1);
					}
				}
			}
		}
		
		
	}// fin Deplacer en haut
	/**
	 * Deplace les blocs en bas
	 * @param aucun
	 * @return void
	 */
	public void deplacerEnBas(){
		if(tableauDeBloc.isEmpty()){
			System.out.println("Eurreur de chargement du jeu! Pas de brique");
			return ;
		}else{
			for(int i=0; i<tableauDeBloc.size();i++){	
				if( bougerEnBas(tableauDeBloc.get(i).bas) ){
					for(int j=0; j<tableauDeBloc.get(i).bas.size();j++){					
						tableauDeBloc.get(i).bas.get(j).y++;
						tableauDeBloc.get(i).bas.get(j).etat=true;
						int x=tableauDeBloc.get(i).bas.get(j).x;
						int y=tableauDeBloc.get(i).bas.get(j).y;
						plateau[x][y]=plateau[x][y-1];
						plateau[x][y-1]=new Case(x,y-1);
					}
				}
			}
		}
		
		
	}// fin Deplacer a Bas
	/**
	 * Deplace les blocs a gauche
	 * @param aucun
	 * @return void
	 */
	public void deplacerAGauche(){
		if(tableauDeBloc.isEmpty()){
			System.out.println("Eurreur de chargement du jeu! Pas de brique");
			return ;
		}else{
			for(int i=0; i<tableauDeBloc.size();i++){	
				if( bougerAGauche(tableauDeBloc.get(i).gauche) ){
					for(int j=0; j<tableauDeBloc.get(i).gauche.size();j++){					
						tableauDeBloc.get(i).gauche.get(j).x--;
						tableauDeBloc.get(i).gauche.get(j).etat=true;
						int x=tableauDeBloc.get(i).bas.get(j).x;
						int y=tableauDeBloc.get(i).bas.get(j).y;
						plateau[x][y]=plateau[x+1][y];
						plateau[x+1][y]=new Case(x+1,y);
					}
				}
			}
		}
		
		
	}// fin Deplacer a Gauche
	/**
	 * Deplace les blocs a droite
	 * @param aucun
	 * @return void
	 */
	public void deplacerADroite(){
		if(tableauDeBloc.isEmpty()){
			System.out.println("Eurreur de chargement du jeu! Pas de brique");
			return ;
		}else{
			for(int i=0; i<tableauDeBloc.size();i++){	
				if( bougerADroite(tableauDeBloc.get(i).droite) ){
					for(int j=0; j<tableauDeBloc.get(i).droite.size();j++){					
						tableauDeBloc.get(i).droite.get(j).x++;
						tableauDeBloc.get(i).droite.get(j).etat=true;
						int x=tableauDeBloc.get(i).bas.get(j).x;
						int y=tableauDeBloc.get(i).bas.get(j).y;
						plateau[x][y]=plateau[x-1][y];
						plateau[x-1][y]=new Case(x-1,y);
					}
				}
			}
		}
		
		
	}// fin Deplacer a Droite
	
	/**
	 * Verifie si un bloc peut bouger en haut.
	 * @param Liste des element permettant le deplacement en haut 
	 * @return vrai(true) si le mouvement est posible le haut vers sinon faut
	 */
	public boolean bougerEnHaut(ArrayList<InfosBrique> tabHaut){
		if(tabHaut.isEmpty()){
			System.out.println("Eureur pas d'element en haut du bloc");
			return false;
		}else{
			for(int i=0; i<tabHaut.size();i++){
				int x=tabHaut.get(i).x;
				int y=tabHaut.get(i).y;
				tabHaut.get(i).etat=(plateau[x][y-1].getClasse().equals("Vide"));
			}
			
			for(int i=0; i<tabHaut.size();i++){
				if( ! tabHaut.get(i).etat){
					return false;
				}
			}
			return true;
		}			
		
	}// fin de Bouger en haut
	/**
	 * Verifie si un bloc peut bouger en bas.
	 * @param Liste des element permettant le deplacement en bas 
	 * @return vrai(true) si le mouvement est posible le bas vers sinon faut
	 */
	public boolean bougerEnBas(ArrayList<InfosBrique> tabBas){
		if(tabBas.isEmpty()){
			System.out.println("Eureur pas d'element en haut du bloc");
			return false;
		}else{
			for(int i=0; i<tabBas.size();i++){
				int x=tabBas.get(i).x;
				int y=tabBas.get(i).y;
				tabBas.get(i).etat=(plateau[x][y+1].getClasse().equals("Vide"));
			}
			
			for(int i=0; i<tabBas.size();i++){
				if( ! tabBas.get(i).etat){
					return false;
				}
			}
			return true;
		}
	}// fin de Bouger en bas
	/**
	 * Verifie si un bloc peut bouger a Gauche.
	 * @param Liste des element permettant le deplacement en gauche 
	 * @return vrai(true) si le mouvement est posible la gauche vers sinon faut
	 */
	public boolean bougerAGauche(ArrayList<InfosBrique> tabGauche){
		if(tabGauche.isEmpty()){
			System.out.println("Eureur pas d'element a gauche du bloc");
			return false;
		}else{
			for(int i=0; i<tabGauche.size();i++){
				int x=tabGauche.get(i).x;
				int y=tabGauche.get(i).y;
				tabGauche.get(i).etat=(plateau[x-1][y].getClasse().equals("Vide"));
			}
			
			for(int i=0; i<tabGauche.size();i++){
				if( ! tabGauche.get(i).etat){
					return false;
				}
			}
			return true;
		}			
	
	}// fin de Bouger a gauche
	/**
	 * Verifie si un bloc peut bouger a droite.
	 * @param Liste des element permettant le deplacement a droite 
	 * @return vrai(true) si le mouvement est posible la droite vers sinon faut
	 */
	public boolean bougerADroite(ArrayList<InfosBrique> tabDroite){
		if(tabDroite.isEmpty()){
			System.out.println("Eureur pas d'element en a droite du bloc");
			return false;
		}else{
			for(int i=0; i<tabDroite.size();i++){
				int x=tabDroite.get(i).x;
				int y=tabDroite.get(i).y;
				tabDroite.get(i).etat=(plateau[x+1][y].getClasse().equals("Vide"));
			}
			
			for(int i=0; i<tabDroite.size();i++){
				if( ! tabDroite.get(i).etat){
					return false;
				}
			}
			return true;
		}			
		
	}// fin de Bouger a droite
	
	/**
	 * Fusion deux bloc en metant a jour les elements de directionnements haut bas gauche et droite.
	 * @param block1 represente le premier block 
	 * @param block2 represente le deuxieme block 
	 * @return void
	 */
	public void fusionBlock(InfosBlock block1,InfosBlock block2){
		block1.haut=miseAJourElementEnHaut(block1.haut,block2.haut);
		block1.bas=miseAJourElementEnBas(block1.bas,block2.bas);
		block1.gauche=miseAJourElementAGauche(block1.gauche,block2.gauche);
		block1.droite=miseAJourElementADroite(block1.droite,block2.droite);
		
		for(int i=0;i<block1.elementRestant.size();i++){
			block1.elementRestant.add( block2.elementRestant.get(i) );
			block2.elementRestant.remove(i);
		}
	}//fin fusion
	/**
	 * actualise les elements de haut lors du fusion de deux blocks.
	 * @param block1 represente le haut du premier block 
	 * @param block2 represente le haut deuxieme block 
	 * @return les nouveaux elements du haut
	 */
	public ArrayList<InfosBrique> miseAJourElementEnHaut(ArrayList<InfosBrique> block1,ArrayList<InfosBrique> block2){
		for(int i=0;i<block1.size();i++){
			InfosBrique brique=block1.get(i);
			int x=brique.x;
			int y=brique.y--;
			brique.etat=true;
			if(plateau[x][y].getClasse().equals("Brique")){
				block1.remove(i);
			}
		}
		for(int i=0;i<block2.size();i++){
			InfosBrique brique=block2.get(i);
			int x=brique.x;
			int y=--brique.y;
			brique.etat=true;
			if(plateau[x][y].getClasse().equals("Brique")){
				block2.remove(i);
			}
		}
		for(int i=0;i<block1.size();i++){
			 block2.add( block1.get(i) );
		}
		return block2;
	}
	/**
	 * actualise les elements de bas lors du fusion de deux blocks.
	 * @param block1 represente le bas du premier block 
	 * @param block2 represente le bas deuxieme block 
	 * @return les nouveaux elements du bas
	 */
	public ArrayList<InfosBrique> miseAJourElementEnBas(ArrayList<InfosBrique> block1,ArrayList<InfosBrique> block2){
		for(int i=0;i<block1.size();i++){
			InfosBrique brique=block1.get(i);
			int x=brique.x;
			int y=++brique.y;
			brique.etat=true;
			if(plateau[x][y].getClasse().equals("Brique")){
				block1.remove(i);
			}
		}
		for(int i=0;i<block2.size();i++){
			InfosBrique brique=block2.get(i);
			int x=brique.x;
			int y=brique.y--;
			brique.etat=true;
			if(plateau[x][y].getClasse().equals("Brique")){
				block2.remove(i);
			}
		}
		for(int i=0;i<block1.size();i++){
			 block2.add( block1.get(i) );
		}
		return block2;
	}
	/**
	 * actualise les elements de Gauche lors du fusion de deux blocks.
	 * @param block1 represente la gauche du premier block 
	 * @param block2 represente la gauche deuxieme block 
	 * @return les nouveaux elements de gauche
	 */
	public ArrayList<InfosBrique> miseAJourElementAGauche(ArrayList<InfosBrique> block1,ArrayList<InfosBrique> block2){
		for(int i=0;i<block1.size();i++){
			InfosBrique brique=block1.get(i);
			int x=--brique.x;
			int y=brique.y;
			brique.etat=true;
			if(plateau[x][y].getClasse().equals("Brique")){
				block1.remove(i);
			}
		}
		for(int i=0;i<block2.size();i++){
			InfosBrique brique=block2.get(i);
			int x=brique.x;
			int y=brique.y--;
			brique.etat=true;
			if(plateau[x][y].getClasse().equals("Brique")){
				block2.remove(i);
			}
		}
		for(int i=0;i<block1.size();i++){
			 block2.add( block1.get(i) );
		}
		return block2;
	}
	/**
	 * actualise les elements de droitet lors du fusion de deux blocks.
	 * @param block1 represente la droite du premier block 
	 * @param block2 represente la droite deuxieme block 
	 * @return les nouveaux elements de droite
	 */
	public ArrayList<InfosBrique> miseAJourElementADroite(ArrayList<InfosBrique> block1,ArrayList<InfosBrique> block2){
		for(int i=0;i<block1.size();i++){
			InfosBrique brique=block1.get(i);
			int x=brique.x;
			int y=brique.y--;
			brique.etat=true;
			if(plateau[x][y].getClasse().equals("Brique")){
				block1.remove(i);
			}
		}
		for(int i=0;i<block2.size();i++){
			InfosBrique brique=block2.get(i);
			int x=++brique.x;
			int y=brique.y;
			brique.etat=true;
			if(plateau[x][y].getClasse().equals("Brique")){
				block2.remove(i);
			}
		}
		for(int i=0;i<block1.size();i++){
			 block2.add( block1.get(i) );
		}
		return block2;
	}
	/**
	 * verifie si la partie est fini
	 * @param aucun
	 * @return vrai si il reste q un seule bloc
	 */
	public boolean partiEstFini(){
		return tableauDeBloc.size()==1;
	}
	/**
	 * affiche juste le plateau de jeu
	 * @param aucun
	 * @return void
	 */
	public static void affichePlateau(){
		for(Case[] c:plateau){
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
	
	public static void afficheTableauDeBloc(){
		for(InfosBlock ib: tableauDeBloc){
			afficheBloc(ib.haut);
			afficheBloc(ib.bas);
			afficheBloc(ib.gauche);
			afficheBloc(ib.droite);
		}
	}
	public static void afficheBloc(ArrayList<InfosBrique> b){
		for(InfosBrique ib: b){
			ib.affiche();
		}
	}
}//fin classe
