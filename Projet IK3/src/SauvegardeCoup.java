import java.io.*;
public class SauvegardeCoup {
	DataOutputStream dos;
	int n;
	public SauvegardeCoup(int n) {
		 this.n = n; //le mieux serai d'initialiser n à 0 pour ensuite incrémenter à chaque fois qu'un déplacement est réussie.
	}
	//Incrémente le nombre de coup. Faire appelle à cette classe à chaque déplacement réussie.
	public void incrementerNbCoup(){
		this.n = this.n + 1;
	}
	//Enregistre dans un fichier le nombre de coup. Faire appelle à cette classe une fois le niveau terminer,
	//il faudra différencier les joueur par des pseudo et écrire un fichier du genre "benjaminNiveau1.txt" pour montrer le score au joueur ayant pour nom "benjamin".
	public void enregistrerNbCoup(String s){
		 try {
			 this.dos = new DataOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File(s))));
			 this.dos.writeInt(this.n);
			 this.dos.close();
			 }
		 catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    } 
	}
}
