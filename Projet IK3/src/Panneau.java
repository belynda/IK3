import java.awt.Color;
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

public class Panneau extends JPanel implements KeyListener {
	private int posX = 54 + 28;
	private int posY = 51 + 28;
	Image img_fond;
	Image img_sol1;
	Image img_sol2;
	Image img_mur;
	Plateau jeu;
	
	int i = 0, j = 0;

	public Panneau() {
		this.setSize(800, 500);

		// Ouverture des images
		try {
			img_fond = ImageIO.read(new File("src/images/tou4.jpg"));
			img_sol1 = ImageIO.read(new File("src/images/plan.jpg"));
			img_sol2 = ImageIO.read(new File("src/images/plan3.jpg"));
			img_mur = ImageIO.read(new File("src/images/brique2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Ouverture du plateau
		jeu = new Plateau("src/file.txt");

		// Liaison du KeyListener avec le panneau
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		// System.out.println("Debut de l'affichage du panneau !");
		Graphics2D g2 = (Graphics2D) g;

		// Pour une image de fond
		g2.drawImage(img_fond, 0, 0, this.getWidth(), this.getHeight(), this);

		int ecartHorizontal = 54;
		int ecartVertical = 51;

		// Dessin du sol
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 13; j++) {
				if (i % 2 == 0) {// On dessine les cases paires
					if (j % 2 == 0) {
						g2.drawImage(img_sol1, ecartHorizontal, ecartVertical,
								30, 30, this);
					} else {
						g2.drawImage(img_sol2, ecartHorizontal, ecartVertical,
								30, 30, this);
						// g2.drawRect(var1, var2, 30, 30);
					}
				} else { // On dessine les cases impaires
					if (j % 2 == 0) {
						g2.drawImage(img_sol2, ecartHorizontal, ecartVertical,
								30, 30, this);
						// g2.drawRect(var1, var2, 30, 30);
					} else {
						g2.drawImage(img_sol1, ecartHorizontal, ecartVertical,
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

		int largeur = 32;
		int longeur = 32;

		for (int i = 0; i < 10; i++) {
			int k = i + i;

			for (int j = 0; j < 10; j++) {

				if (jeu.plateau[i][j].getClasse().equals("Brique")) {

					if ((i >= 1) && (j <= 9)) {
						// les element qui de deplace en couleur bleu
						if ((jeu.plateau[i - 1][j].getClasse().equals("Brique"))
								&& (jeu.plateau[i][j].getClasse()
										.equals("Brique"))) {

							g.setColor(Color.blue);
							g.fillRoundRect(posX + (i - 1) * 30, posY + j * 30,
									largeur + 30, longeur, 13, 13);
						}

						if ((jeu.plateau[i][j - 1].getClasse().equals("Brique"))
								&& (jeu.plateau[i][j].getClasse()
										.equals("Brique"))) {

							g.setColor(Color.blue);
							g.fillRoundRect(posX + i * 30, posY + (j - 1) * 30,
									largeur, longeur + 30, 13, 13);
						} else {

							g.setColor(Color.blue);
							g.fillRoundRect(posX + (i) * 30, posY + j * 30,
									largeur, longeur, 13, 13);
						}

					}
				} else if (jeu.plateau[i][j].getClasse().equals("Mur")) {
					// les element qui ne se deplace pas les murs en couleur
					if ((i >= 1) && (i <= 9)) {
						if ((jeu.plateau[i - 1][j].getClasse().equals("Mur"))
								&& (jeu.plateau[i][j].getClasse().equals("Mur"))) {

							g.setColor(new Color(100, 100, 100));
							g.fillRoundRect(posX + (i - 1) * 30, posY + j * 30,
									largeur + 30, longeur, 14, 14);

						}
					}
					if ((j >= 1) && (j <= 9)) {

						if ((jeu.plateau[i][j - 1].getClasse().equals("Mur"))
								&& (jeu.plateau[i][j].getClasse().equals("Mur"))) {

							g.setColor(new Color(100, 100, 100));
							g.fillRoundRect(posX + i * 30, posY + (j - 1) * 30,
									largeur, longeur + 30, 13, 13);

						}
					} else {
						g.setColor(new Color(100, 100, 100));
						g.fillRoundRect(posX + i * 30, posY + (j) * 30,
								largeur, longeur, 13, 13);

					}
				}

			}

		}

		// Fonctions pour le chronometre

		// TODO Vous verrez cette phrase chaque fois que la méthode sera
		// invoquée
		// System.out.println("Fin de l'affichage du panneau !");

	}

	// Fonctions liées au clavier
	public void keyPressed(KeyEvent event) {
		System.out.println("Code touche pressée : " + event.getKeyCode() + " - caractère touche pressée : " + event.getKeyChar());
		System.out.println("test");
		if (!jeu.partiEstFini()) {
			System.out.println("direction");

			if (event.getKeyCode() == 38) {
				jeu.deplacerEnHaut();

			} else {
				if (event.getKeyCode() == 40) {
					jeu.deplacerEnBas();

				} else {
					if (event.getKeyCode() == 37) {
						jeu.deplacerAGauche();
					} else {
						if (event.getKeyCode() == 39) {
							jeu.deplacerADroite();
						}
					}
				}
			}
			jeu.affichePlateau();
			i++;
		} else {
			if (j == 0) {
				jeu.afficheTableauDeBloc();
				System.out.println("fin de parti . Nombre de coup " + i);
				j++;
			}
		}
		this.repaint();
	}

	public void keyReleased(KeyEvent event) {
	}

	public void keyTyped(KeyEvent event) {
	}
}
