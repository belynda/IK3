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
	private int posX = 54 + 28;
	private int posY = 51 + 28;
	
	Image img_sol1;
	Image img_sol2;
	
	
	
	public Fenetre fen;
	
	public Panneau2(Fenetre fen){
		
		this.fen = fen;	
		this.setSize(800, 500);
	}
	 
	
	
	//Plateau jeu;

	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  Graphics2D g3 = (Graphics2D)g;
		    
		  try {
				//img_fond = ImageIO.read(new File("src/images/tou4.jpg"));
				img_sol1 = ImageIO.read(new File("src/images/plan.jpg"));
				img_sol2 = ImageIO.read(new File("src/images/plan3.jpg"));
				//img_mur = ImageIO.read(new File("src/images/brique2.jpg"));
				//img_etoile = ImageIO.read(new File("src/images/etoile.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		  int ecartHorizontal = 250;
			int ecartVertical = 250;

			// Dessin du sol
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 13; j++) {
					if (i % 2 == 0) {// On dessine les cases paires
						if (j % 2 == 0) {
							g3.drawImage(img_sol1, ecartHorizontal, ecartVertical,
									10, 10, this);
						} else {
							g3.drawImage(img_sol2, ecartHorizontal, ecartVertical,
									10, 10, this);
							// g2.drawRect(var1, var2, 30, 30);
						}
					} else { // On dessine les cases impaires
						if (j % 2 == 0) {
							g3.drawImage(img_sol2, ecartHorizontal, ecartVertical,
									10, 10, this);
							// g2.drawRect(var1, var2, 30, 30);
						} else {
							g3.drawImage(img_sol1, ecartHorizontal, ecartVertical,
									10, 10, this);
							// g2.drawRect(var1, var2, 30, 30);
						}
					}
					ecartHorizontal = ecartHorizontal + 10;
				}
				ecartVertical = ecartVertical + 10;
				ecartHorizontal = 250;
			}
		 
		 
		 
	}
}