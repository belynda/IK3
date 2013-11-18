import java.util.*;
import java.io.*;
public class Jeu {
	static Plateau jeu= new Plateau();
	
	public static  void remplissage(){
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				if(i==0 || j==0 ||i==5 || j==5){
					jeu.plateau[i][j]= new Mur(i,j);
				}else{
					jeu.plateau[i][j]= new Case(i,j);
				}
			}
		}
		jeu.plateau[2][2]=new Mur(2,2);
		jeu.plateau[1][1]= new Brique(1,1,"red");
		InfosBrique br1= new InfosBrique(1,1);
		ArrayList<InfosBrique> ibr1= new ArrayList<InfosBrique>();
		ibr1.add(br1);
		InfosBlock ibl1= new InfosBlock(ibr1);
		jeu.tableauDeBlock.add(ibl1);
		
		jeu.plateau[1][4]= new Brique(1,4,"red");
		InfosBrique br2= new InfosBrique(1,4);
		ArrayList<InfosBrique> ibr2= new ArrayList<InfosBrique>();
		ibr2.add(br2);
		InfosBlock ibl2= new InfosBlock(ibr2);
		jeu.tableauDeBlock.add(ibl2);
		
		jeu.plateau[3][2]= new Brique(3,2,"red");
		InfosBrique br3= new InfosBrique(3,2);
		ArrayList<InfosBrique> ibr3= new ArrayList<InfosBrique>();
		ibr3.add(br3);
		InfosBlock ibl3= new InfosBlock(ibr3);
		jeu.tableauDeBlock.add(ibl3);
		
		jeu.plateau[3][4]= new Brique(3,4,"red");	
		InfosBrique br4= new InfosBrique(3,4);
		ArrayList<InfosBrique> ibr4= new ArrayList<InfosBrique>();
		ibr4.add(br4);
		InfosBlock ibl4= new InfosBlock(ibr4);
		jeu.tableauDeBlock.add(ibl4);
		jeu.affichePlateau();
	}
	
	public static  void main(String[] args){
		Scanner sc = new Scanner(System.in);
		remplissage();
		System.out.println("taile:"+jeu.tableauDeBlock.size());
		jeu.afficheTableauDeBloc();
		
		for(int i=0;i<10;i++){
			System.out.println("direction");
				char c=sc.nextLine().charAt(0);
			if(c=='h'){
				jeu.deplacerEnHaut();
			}else{
				if(c=='b'){
					jeu.deplacerEnBas();
				}else{
					if(c=='g'){
						jeu.deplacerAGauche();
					}else{
						jeu.deplacerADroite();
					}
				}
			}
			jeu.affichePlateau();
			System.out.println("taile:"+jeu.tableauDeBlock.size());
			jeu.afficheTableauDeBloc();
		}		
	}
}
