import java.awt.Color;

import javax.swing.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;




import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel implements KeyListener  {
	
	private int posX = 49 + 28;
	private int posY = 45 + 28;
	Image img_fond;
	Image img_sol1;
	Image img_sol2;
	Image img_mur;
	Image img_etoile;
	
	public Fenetre fen; 
	
	
	//Plateau jeu;
	
	int i = 0, j = 0;

	
	public Panneau(Fenetre fen) {
		
		this.fen = fen;
		this.setSize(800, 500);

		// Ouverture des images
		try {
			img_fond = ImageIO.read(new File("src/images/tout4.jpg"));
			img_sol1 = ImageIO.read(new File("src/images/plan.jpg"));
			img_sol2 = ImageIO.read(new File("src/images/plan3.jpg"));
			img_mur = ImageIO.read(new File("src/images/brique2.jpg"));
			img_etoile = ImageIO.read(new File("src/images/etoile.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Ouverture du plateau
		jeu = new Plateau("src/file0.txt");

		// Liaison du KeyListener avec le panneau
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		
	
		// System.out.println("Debut de l'affichage du panneau !");
		Graphics2D g2 = (Graphics2D) g;
		

		// Pour une image de fond
		g2.drawImage(img_fond, 0, 0, this.getWidth(), this.getHeight(), this);

		int ecartHorizontal = 49;
		int ecartVertical = 45;
		
		

		// Dessin du sol
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 14; j++) {
				if (i % 2 == 0) {// On dessine les cases paires
					if (j % 2 == 0) {
						g2.drawImage(img_sol1, ecartHorizontal, ecartVertical,
								29, 29, this);
					} else {
						g2.drawImage(img_sol2, ecartHorizontal, ecartVertical,
								29, 29, this);
						// g2.drawRect(var1, var2, 30, 30);
					}
				} else { // On dessine les cases impaires
					if (j % 2 == 0) {
						g2.drawImage(img_sol2, ecartHorizontal, ecartVertical,
								29, 29, this);
						// g2.drawRect(var1, var2, 30, 30);
					} else {
						g2.drawImage(img_sol1, ecartHorizontal, ecartVertical,
								29, 29, this);
						// g2.drawRect(var1, var2, 30, 30);
					}
				}
				ecartHorizontal = ecartHorizontal + 29;
			}
			ecartVertical = ecartVertical + 29;
			ecartHorizontal = 49;
		}
		
		
		//dessin du petit sol 
		int ecartHorizontal2 = 570;
		int ecartVertical2 = 50;

		// Dessin du sol
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (i % 2 == 0) {// On dessine les cases paires
					if (j % 2 == 0) {
						g2.drawImage(img_sol1, ecartHorizontal2, ecartVertical2,
								29, 29, this);
					} else {
						g2.drawImage(img_sol2, ecartHorizontal2, ecartVertical2,
								29, 29, this);
						// g2.drawRect(var1, var2, 30, 30);
					}
				} else { // On dessine les cases impaires
					if (j % 2 == 0) {
						g2.drawImage(img_sol2, ecartHorizontal2, ecartVertical2,
								29, 29, this);
						// g2.drawRect(var1, var2, 30, 30);
					} else {
						g2.drawImage(img_sol1, ecartHorizontal2, ecartVertical2,
								29, 29, this);
						// g2.drawRect(var1, var2, 30, 30);
					}
				}
				ecartHorizontal2 = ecartHorizontal2 + 29;
			}
			ecartVertical2 = ecartVertical2 + 29;
			ecartHorizontal2 = 570;
		}
		// Dessin du master challenge 
		

		
				int largeur2 = 29;
				int longeur2 = 29;
				

				for (int i = 0; i < 10; i++) {
				

					for (int j = 0; j < 10; j++) {

						if (jeu.plateau[i][j].getClasse().equals("Brique")) {

							if ((i >= 1) && (j <= 9)) {
								// les element qui de deplace en couleur bleu
								if ((jeu.plateau[i - 1][j].getClasse().equals("Brique"))
										&& (jeu.plateau[i][j].getClasse()
												.equals("Brique"))) {

									g.setColor(Color.blue);
									g.fillRoundRect(posX + (i - 1) * 29, posY + j * 29,
											largeur2 + 29, longeur2, 13, 13);
								}

								if ((jeu.plateau[i][j - 1].getClasse().equals("Brique"))
										&& (jeu.plateau[i][j].getClasse()
												.equals("Brique"))) {

									g.setColor(Color.blue);
									g.fillRoundRect(posX + i * 29, posY + (j - 1) * 29,
											largeur2, longeur2 + 29, 13, 13);
								} else {

									g.setColor(Color.blue);
									g.fillRoundRect(posX + (i) * 29, posY + j * 29,
											largeur2, longeur2, 13, 13);
								}

							}
						} else if (jeu.plateau[i][j].getClasse().equals("Mur")) {
							// les element qui ne se deplace pas les murs en couleur
							if ((i >= 1) && (i <= 9)) {
								if ((jeu.plateau[i - 1][j].getClasse().equals("Mur"))
										&& (jeu.plateau[i][j].getClasse().equals("Mur"))) {

									g.setColor(new Color(100, 100, 100));
									g.fillRoundRect(posX + (i - 1) * 29, posY + j * 29,
											largeur2 + 29, longeur2, 14, 14);

								}
							}
							if ((j >= 1) && (j <= 9)) {

								if ((jeu.plateau[i][j - 1].getClasse().equals("Mur"))
										&& (jeu.plateau[i][j].getClasse().equals("Mur"))) {

									g.setColor(new Color(100, 100, 100));
									g.fillRoundRect(posX + i * 29, posY + (j - 1) * 29,
											largeur2, longeur2 + 29, 13, 13);

								}else {
									g.setColor(new Color(100, 100, 100));
									g.fillRoundRect(posX + i * 29, posY + j * 29,
											largeur2, longeur2, 13, 13);
									
							} 
							}			
						}

					}
					
					

				}
		
		// Je dessine le jeu 
		

		
		int largeur = 29;
		int longeur = 29;
		

		for (int i = 0; i < 10; i++) {
		

			for (int j = 0; j < 10; j++) {

				if (jeu.plateau[i][j].getClasse().equals("Brique")) {

					if ((i >= 1) && (j <= 9)) {
						// les element qui de deplace en couleur bleu
						if ((jeu.plateau[i - 1][j].getClasse().equals("Brique"))
								&& (jeu.plateau[i][j].getClasse()
										.equals("Brique"))) {

							g.setColor(Color.blue);
							g.fillRoundRect(posX + (i - 1) * 29, posY + j * 29,
									largeur + 29, longeur, 13, 13);
						}

						if ((jeu.plateau[i][j - 1].getClasse().equals("Brique"))
								&& (jeu.plateau[i][j].getClasse()
										.equals("Brique"))) {

							g.setColor(Color.blue);
							g.fillRoundRect(posX + i * 29, posY + (j - 1) * 29,
									largeur, longeur + 29, 13, 13);
						} else {

							g.setColor(Color.blue);
							g.fillRoundRect(posX + (i) * 29, posY + j * 29,
									largeur, longeur, 13, 13);
						}

					}
				} else if (jeu.plateau[i][j].getClasse().equals("Mur")) {
					// les element qui ne se deplace pas les murs en couleur
					if ((i >= 1) && (i <= 9)) {
						if ((jeu.plateau[i - 1][j].getClasse().equals("Mur"))
								&& (jeu.plateau[i][j].getClasse().equals("Mur"))) {

							g.setColor(new Color(100, 100, 100));
							g.fillRoundRect(posX + (i - 1) * 29, posY + j * 29,
									largeur + 29, longeur, 14, 14);

						}
					}
					if ((j >= 1) && (j <= 9)) {

						if ((jeu.plateau[i][j - 1].getClasse().equals("Mur"))
								&& (jeu.plateau[i][j].getClasse().equals("Mur"))) {

							g.setColor(new Color(100, 100, 100));
							g.fillRoundRect(posX + i * 29, posY + (j - 1) * 29,
									largeur, longeur + 29, 13, 13);

						}else {
							g.setColor(new Color(100, 100, 100));
							g.fillRoundRect(posX + i * 29, posY + j * 29,
									largeur, longeur, 13, 13);
							
					} 
					}			
				}

			}
			
			

		}
		//dire dans quel niveau on est :
				
				if(  s=="src/file1.txt"){
					g.setColor(Color.white);
					Font font = new Font("Colibri",1,60);
					g.setFont(font);
				g.drawString(" Niveau 1 !", 80, 430);
				}
				if(  s=="src/file0.txt"){
					g.setColor(Color.white);
					Font font = new Font("Colibri",1,60);
					g.setFont(font);
					g.drawString(" Niveau 0 !", 80, 430);
					
				}
				
	//	int nombreCoup=0; 
		if(jeu.partiEstFini()){
			
			g2.drawImage(img_etoile, 555
					,230 ,
					60, 50, this);
				g.setColor(Color.red);
				Font font = new Font("Colibri",1,60);
				g.setFont(font);
				g.drawString("Bien jou�  !", 53, 250);
				//g.drawString("Nombre coup".substring(i) !", 53, 300);
				
				
		}
		
		

		// Fonctions pour le chronometre

		// TODO Vous verrez cette phrase chaque fois que la m�thode sera
		// invoqu�e
		// System.out.println("Fin de l'affichage du panneau !");

	}

	// Fonctions li�es au clavier
	public void keyPressed(KeyEvent event) {
		System.out.println("Code touche press�e : " + event.getKeyCode() + " - caract�re touche press�e : " + event.getKeyChar());
		System.out.println("test");
	
		if (!jeu.partiEstFini()) {
			System.out.println("direction");

			if (event.getKeyCode() == 37) {
				jeu.deplacerEnHaut();
				//nombreCoup=nombreCoup++; 

			} else {
				if (event.getKeyCode() == 39) {
					jeu.deplacerEnBas();
				//	nombreCoup++; 

				} else {
					if (event.getKeyCode() == 40) {
						jeu.deplacerAGauche();
					//	nombreCoup++; 
					} else {
						if (event.getKeyCode() == 38) {
							jeu.deplacerADroite();
							//nombreCoup++; 
						}
					}
				}
			}
			jeu.affichePlateau();
			jeu.afficheTableauDeBloc();
			i++;
		} else {
			/*if (j == 0) {
				jeu.afficheTableauDeBloc();
				System.out.println("fin de parti . Nombre de coup " + i);
			
				j++;
			
			}*/
		     System.out.println("fin de parti. Nombre de coup "+jeu.nombreDeCoup());
             if(jeu.masterChalenger()){
                     System.out.println("Genial master chalenge reussi");
             }                                                        
             j++;
             s="src/file"+j+".txt";
             File f= new File(s);
             if(f.exists()){
                     for(int v=0;v<15;v++){
                         System.out.println();
                 }
                     System.out.println("NIVAU "+(j+1));
                     jeu= new Plateau(s);
             }else{
                     System.out.println("Tu es un bon toi, tu a droit a une fess�");
             }

		}
		this.repaint();
	}
	
	
	
	
	
	

	public void keyReleased(KeyEvent event) {
	}

	public void keyTyped(KeyEvent event) {
	}
	//static int j=0;
	   String s="src/file"+j+".txt";
	   Plateau jeu= new Plateau(s);
	
}

