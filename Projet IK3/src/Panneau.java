import java.awt.Graphics;
import javax.swing.JPanel; 
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;



public class Panneau  extends JPanel{
	
	 public void paintComponent(Graphics g){
		    // TODO Vous verrez cette phrase chaque fois que la méthode sera invoquée
		    System.out.println("Je suis exécutée !"); 
		  //  int x1 = this.getWidth()/4;
		  //  int y1 = this.getHeight()/4;                      
		  //  g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);	
		    
		    try {
		        Image img = ImageIO.read(new File("src/images/image.png")); 
		        g.drawImage(img, 0, 0, this);
		        //Pour une image de fond
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      } catch (IOException e) {
		        e.printStackTrace();
		      }                
		                                   }  
   
}
