import java.util.*;
import java.io.*;
public class Jeu {
	static Plateau jeu= new Plateau("src/file.txt");
	

	
	
	
	public static  void main(String[] args){
		Scanner sc = new Scanner(System.in);
		jeu.affichePlateau();
		System.out.println("taile:"+jeu.tableauDeBlock.size());
		jeu.afficheTableauDeBloc();
		int i=0;
		while(!jeu.partiEstFini()){
			System.out.println("direction");
				char c=sc.nextLine().charAt(0);
			if(c=='z'){
				jeu.deplacerEnHaut();
			}else{
				if(c=='s'){
					jeu.deplacerEnBas();
				}else{
					if(c=='q'){
						jeu.deplacerAGauche();
					}else{
						jeu.deplacerADroite();
					}
				}
			}
			i++;
			jeu.affichePlateau();
			System.out.println("taile:"+jeu.tableauDeBlock.size());
			jeu.afficheTableauDeBloc();
		}	
		System.out.println("NOMBRE de coup  "+i);
	}
}
