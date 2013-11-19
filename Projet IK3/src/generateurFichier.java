import java.io.BufferedInputStream;
		import java.io.BufferedOutputStream;
		import java.io.DataInputStream;
		import java.io.DataOutputStream;
		import java.io.File;
		import java.io.FileInputStream;
		import java.io.FileNotFoundException;
		import java.io.FileOutputStream;
		import java.io.IOException;
		import java.util.*;
public class generateurFichier {

	public static void main(String[] args) {
		//Packages à importer afin d'utiliser l'objet File
		
		    //Nous déclarons nos objets en dehors du bloc try/catch
		    DataInputStream dis;
		    DataOutputStream dos;
		    Scanner sc = new Scanner(System.in);
		    try {
		     /* dos = new DataOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File("fichier/file1.txt"))));
		      for(int i=0;i<10;i++){
					for(int j=0;j<10;j++){
						dos.writeInt(i);
					    dos.writeInt(j);
						if(i==0 || j==0 ||i==9 || j==9){
						      //Nous allons écrire chaque type primitif
						      
						      dos.writeChar('M');					     
						      
						}else{
							char c;
							do{
							System.out.println("Donner le type de la case "+i+" "+j+"");
							 c=sc.nextLine().toUpperCase().charAt(0);
							}while((c!='M')&&(c!='B')&&(c!='V'));
							
							dos.writeChar(c);
							
						}
					}
		      }
		      dos.close();*/
		  
		        	
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
		  }
		
	}

