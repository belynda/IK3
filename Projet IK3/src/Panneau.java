import java.awt.Graphics;

import javax.swing.JPanel; 
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Color;




public class Panneau  extends JPanel{
	
	
	 public void paintComponent(Graphics g){
		  
		   
		    
		 try {
			 
			 //TODO importer l'image de fond 
		      Image img = ImageIO.read(new File("src/images/foret.jpg"));
		      g.drawImage(img, 0, 0, this);
		      //Pour une image de fond
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      
		// JPanel[][] plateau ; 
		// plateau= new JPanel [10][10]; 
		      
		      
		    
		 
		 
		 
		     
		      
		      
		      
		      
		      
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }             
		        
		        // TODO Vous verrez cette phrase chaque fois que la méthode sera invoquée
			    System.out.println("Je suis exécutée !"); 
			    
		  
			
	 }
			  
			 
		
	 }
   
