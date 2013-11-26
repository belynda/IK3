import java.awt.Color;

import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	private int posX = 54 + 28;

	private int posY = 51 + 28;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		try {

			// TODO importer l'image de fond
			Image img = ImageIO.read(new File("src/images/tou4.jpg"));
			// g.drawImage(img, 0, 0, this);
			// Pour une image de fond
			g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

			// JPanel[][] plateau ;
			// plateau= new JPanel [10][10];

			// TODO Importer l'image d'une brique

			Image img2 = ImageIO.read(new File("src/images/plan.jpg"));
			Image img3 = ImageIO.read(new File("src/images/plan3.jpg"));
			Image img4 = ImageIO.read(new File("src/images/cadreDroite4.jpg"));
			Image img5 = ImageIO.read(new File("src/images/brique2.jpg"));
			Image img6 = ImageIO.read(new File("src/images/cadreDroite4.jpg"));

			// g2.drawImage(img4,24, 30, 29*14, 30*14, this);

			// g2.setColor(Color.white);
			// g2.drawRect(34, 84, 30*11, 30*11);

			// TODO PLACER L'imagE
			int ecartHorizontal = 54;
			int ecartVertical = 51;

			// Dessin du sol
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 13; j++) {
					if (i % 2 == 0) {// On dessine les cases paires
						if (j % 2 == 0) {
							g2.drawImage(img2, ecartHorizontal, ecartVertical,
									30, 30, this);
						} else {
							g2.drawImage(img3, ecartHorizontal, ecartVertical,
									30, 30, this);
							// g2.drawRect(var1, var2, 30, 30);
						}
					} else { // On dessine les cases impaires
						if (j % 2 == 0) {
							g2.drawImage(img3, ecartHorizontal, ecartVertical,
									30, 30, this);
							// g2.drawRect(var1, var2, 30, 30);
						} else {
							g2.drawImage(img2, ecartHorizontal, ecartVertical,
									30, 30, this);
							// g2.drawRect(var1, var2, 30, 30);
						}
					}
					ecartHorizontal = ecartHorizontal + 30;
				}
				ecartVertical = ecartVertical + 30;
				ecartHorizontal = 54;

			}
			// la je vais recuperer la tableau d'alpha et afficher avec une
			// boucle

			// Case[][] tab = new Case[11][13] ;
			// tab = Jeu.jeu.plateau[11][13];
			// Plateau tab = new Plateau();
			// tab = Jeu.jeu ;

			Plateau jeu = new Plateau("src/file.txt");

			int largeur = 32;
			int longeur = 32;

			for (int i = 0; i < 10; i++) {
				int k = i + i;

				for (int j = 0; j < 10; j++) {

					if (jeu.plateau[i][j].getClasse().equals("Brique")) {

						if ((i >= 1) && (j <= 9)) {
							// les element qui de deplace en couleur bleu
							if ((jeu.plateau[i - 1][j].getClasse()
									.equals("Brique"))
									&& (jeu.plateau[i][j].getClasse()
											.equals("Brique"))) {

								g.setColor(Color.blue);
								g.fillRoundRect(posX + (i - 1) * 30, posY + j
										* 30, largeur + 30, longeur, 13, 13);
							}

							if ((jeu.plateau[i][j - 1].getClasse()
									.equals("Brique"))
									&& (jeu.plateau[i][j].getClasse()
											.equals("Brique"))) {

								g.setColor(Color.blue);
								g.fillRoundRect(posX + i * 30, posY + (j - 1)
										* 30, largeur, longeur + 30, 13, 13);
							} else {

								g.setColor(Color.blue);
								g.fillRoundRect(posX + (i) * 30, posY + j * 30,
										largeur, longeur, 13, 13);
							}

						}
					} else if (jeu.plateau[i][j].getClasse().equals("Mur")) {
						// les element qui ne se deplace pas les murs en couleur
						if ((i >= 1) && (i <= 9)) {
							if ((jeu.plateau[i - 1][j].getClasse()
									.equals("Mur"))
									&& (jeu.plateau[i][j].getClasse()
											.equals("Mur"))) {

								g.setColor(new Color(100, 100, 100));
								g.fillRoundRect(posX + (i - 1) * 30, posY + j
										* 30, largeur + 30, longeur, 14, 14);

							}
						}
						if ((j >= 1) && (j <= 9)) {

							if ((jeu.plateau[i][j - 1].getClasse()
									.equals("Mur"))
									&& (jeu.plateau[i][j].getClasse()
											.equals("Mur"))) {

								g.setColor(new Color(100, 100, 100));
								g.fillRoundRect(posX + i * 30, posY + (j - 1)
										* 30, largeur, longeur + 30, 13, 13);

							}
						} else {
							g.setColor(new Color(100, 100, 100));
							g.fillRoundRect(posX + i * 30, posY + (j) * 30,
									largeur, longeur, 13, 13);

						}

						// epaint();

					}

				}

			}

			// g2.drawImage(img6,470, 30, 280, 280, this);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Fonctions pour le chronometre

		// TODO Vous verrez cette phrase chaque fois que la méthode sera
		// invoquée
		System.out.println("Je suis exécutée !");

	}

}
