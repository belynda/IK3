import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Fenetre extends JFrame {
 

	// ELEMLENTS DU MENU 

	private JMenuBar bareMenu = new JMenuBar();
	private JMenu menu = new JMenu("Partie");
	private JMenu newPartie = new JMenu("Nouvelle partie");
	private JMenuItem item1 = new JMenuItem("Continuer la partie");
	private JMenu options = new JMenu("Options de jeu");
	private JMenuItem item4 = new JMenuItem("Niveau 1");
	private JMenuItem item5 = new JMenuItem("Niveau 2");
	private JMenuItem item6 = new JMenuItem("Son");
	private JMenuItem item9 = new JMenuItem("Quitter");
	private JMenu aide = new JMenu("?");
	private JMenuItem item7 = new JMenuItem("Instructions");
	private JMenuItem item8 = new JMenuItem("A propos");
	
	
	 
	//static Plateau jeu = new Plateau("file.txt");
	Panneau pan = new Panneau(this);
	Panneau2 pan2 = new Panneau2(this); 
	

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
		
		//Gezstionnaire d'affichage
		this.setLayout(new BorderLayout());
		
		//public static void ChoixPanneau(Panneau pan){
			// Panneau pan = new Panneau(); 
		this.getContentPane().add(pan, BorderLayout.CENTER);
		//this.getContentPane().add(pan2, BorderLayout.LINE_END);
		
		//		pan2.setPreferredSize(new Dimension(300,300));
		
		// JPanel policePanel=new Marqee("Bienvenu sur java.mesexemples.com");
		// this.add(policePanel);
		//	}
		
		//Ajout des elements du menu 
		
		this.setJMenuBar(bareMenu);
		
		bareMenu.add(menu);
		
		menu.add(newPartie);
		
		newPartie.add(item1);
		
		menu.add(options);
		
		options.add(item4);
		
		options.add(item5);
		
		options.add(item6);
		
		newPartie.addSeparator();
		
		menu.add(item9);
		
		bareMenu.add(aide);
		
		aide.add(item7);
		
		aide.add(item8);
		 
		// ActionListener pour quitter
		
		item9.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent arg0) {
			      System.exit(0);
			    }        
			  });
		// ActionListener pour nouvelle partie
		
		newPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
			}
		});
		
		// ActionListener pour 
		
		this.setVisible(true);
		
	}
}
	
		               

	  
		        
	
