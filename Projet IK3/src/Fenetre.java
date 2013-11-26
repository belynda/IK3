import java.awt.Color;
import java.awt.event.*;

import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	//static Plateau jeu = new Plateau("file.txt");
	Panneau pan = new Panneau();

	// TODO constructeur de la fenetre
	public Fenetre() {
		// TODO modifier le titre de la fenetre
		setTitle("DenkiBlocks");

		// TODO modifier la taille
		setSize(800, 500);

		// TODO click sur la croix entraine la fermeture de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TODO centrer la fenetre par rapport à l'ecran
		setLocationRelativeTo(null);

		// TODO FIGER la taille de la fenetre
		this.setResizable(false);

		//On ajoute le panneau dans le contenu de la fenetre
		this.getContentPane().add(pan);
		this.setVisible(true);
	}
}
