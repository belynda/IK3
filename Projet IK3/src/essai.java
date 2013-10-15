import java.io.*;
import java.util.*;


public class essai {
public static void main(String[] args) {
	//Nous déclarons nos objets en dehors du bloc try/catch
	BufferedInputStream bis;
	BufferedOutputStream bos;
	Scanner sc=new Scanner(System.in);
	try {
			bos = new BufferedOutputStream(new FileOutputStream(new File("fichier.txt")));
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

