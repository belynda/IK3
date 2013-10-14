import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;




public class Panneau  extends JPanel{
	
	
	 public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  Graphics2D g2 = (Graphics2D)g;
		    
		 try {
			 
			 //TODO importer l'image de fond 
		      Image img = ImageIO.read(new File("src/images/foret.jpg"));
		     // g.drawImage(img, 0, 0, this);
		      //Pour une image de fond
		      g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      
		// JPanel[][] plateau ; 
		// plateau= new JPanel [10][10]; 
		      
		      //TODO Importer l'image d'une brique 
		      
		      Image img2 = ImageIO.read(new File("src/images/brique.jpg"));
		      //TODO PLACER L'imagE 
		      int var1=50 ; 
		      int var2=100; 
		      
	       for(int i=0 ;i < 10 ; i++){
	    	   for(int j=0 ; j<10 ; j++){
	    		   g2.setColor(Color.white);
	    		   
	    		   g2.drawImage(img2, var1, var2, 30, 30, this);
	    		   
	    		   g2.drawRect(var1, var2, 30, 30);
	    		   var1=var1+30; 
	    		   var2=var2+30;
	    	   }
	    	   
	    	   
	    	   
	       }
		      
		      
		      
		     

		      
		      
		      
		      
		      


		      
		    
		 
		 
		 
		     
		      
		      
		      
		      
		      
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }             
		        
		        // TODO Vous verrez cette phrase chaque fois que la méthode sera invoquée
			    System.out.println("Je suis exécutée !"); 
			    
		  
			
	 }
			  
			 
		
	 }
   
