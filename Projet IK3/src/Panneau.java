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
		      Image img3 = ImageIO.read(new File("src/images/brique2.jpg"));
		      Image img4 = ImageIO.read(new File("src/images/cadre5.jpg"));
		      Image img5 = ImageIO.read(new File("src/images/mur.jpg"));
		      
		      g2.drawImage(img4,24, 30, 29*14, 30*14, this);

		    //  g2.setColor(Color.white);
		     // g2.drawRect(34, 84, 30*11, 30*11);
		      
		      //TODO PLACER L'imagE 
		      int var1=46 ; 
		      int var2=61; 
		     
		      
	       for(int i=0 ;i < 12 ; i++){
	    	   
	    	     
	    	   for(int j=0 ; j<12 ; j++){
	    
	    		  if(i%2==0){ 
	    			  if(j%2==0){
	    				  if((j==2)&&(i==2)){
	    					  g2.drawImage(img5, var1, var2, 30, 30, this);
	    					  
	    				  }else {
	    				  
	    				  g2.drawImage(img2, var1, var2, 30, 30, this);
	    				  }
	    		       
	    			  }else {
	    				  g2.drawImage(img3, var1, var2, 30, 30, this);
		    		   
		    		    // g2.drawRect(var1, var2, 30, 30);
	    			  } 
	    	   
	    		  }else { 
	    			  	if(j%2==0){
	    				  
	    			  		g2.drawImage(img3, var1, var2, 30, 30, this);
	    		   
	    			  		//  g2.drawRect(var1, var2, 30, 30);
	    			  	}else {
	    			  		g2.drawImage(img2, var1, var2, 30, 30, this);
	    				  
	    			  		// g2.drawRect(var1, var2, 30, 30);
	    			  
	    			  	}
	    			  
	    			  
	    		  }
	    		  
	    		   var1=var1+30 ; 
	    	   }
	    	   var2=var2+30;
	    	  var1=46 ; 
	    	    
	    	   
	    	   
	    	   
	       } 
		      
		      
		      
		     

		      
		      
		      
		      
		      


		      
		    
		 
		 
		 
		     
		      
		      
		      
		      
		      
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }             
		        
		        // TODO Vous verrez cette phrase chaque fois que la méthode sera invoquée
			    System.out.println("Je suis exécutée !"); 
			    
		  
			
	 }
			  
			 
		
	 }
   
