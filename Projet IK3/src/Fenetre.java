import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Fenetre extends JFrame {
	
	
//TODO constructeur  de la fenetre 
	  Fenetre(){
		
		//TODO modifier le titre de la fenetre 
		setTitle("DenkiBlocks"); 
		
		//TODO  modifier la taille 
		setSize(800,500);
		
		//TODO click sur la croix entraine la fermeture de la fenetre 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//TODO centrer la fenetre par rapport à l'ecran 
		 setLocationRelativeTo(null);
		  
		 //TODO FIGER la taille de la fenetre 
		 this.setResizable(false);
		
		// TODO affichega de la fenetre 
		setVisible(true);
		
		// TODO instanciation d'un objet JPanel 
		JPanel pan = new JPanel(); 
		 
		
		// TODO definition de la couleur du fond 
       // pan.setBackground(Color.BLUE);
		
		//TODO on previent notre JFrame que notre JPanel sera son content pane 
		this.setContentPane(pan); 
		
		this.setContentPane(new Panneau());
		
		
		this.setVisible(true);
		
		
		 
	  }
		 
	      
		 
		 
		
		
		
		
		
		
		
		}
	



