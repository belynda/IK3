import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import java.io.IOException;
  
public class Panneau2 extends JPanel {

	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  Graphics2D g2 = (Graphics2D)g;
		    
		 try {
			 
			 //TODO importer l'image de fond 
		      Image img = ImageIO.read(new File("src/images/foret.jpg"));
		     // g.drawImage(img, 0, 0, this);
		      //Pour une image de fond
		      g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		 } catch (IOException e) {
		      e.printStackTrace();
		    } 
	}
}