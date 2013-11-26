import java.awt.Color; 
import java.awt.event.*; 

import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;





public class Fenetre extends JFrame {
	//private JTextField jtf; 
	
//TODO constructeur  de la fenetre 
	public   Fenetre(){
		
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
				
		//this.setContentPane( new Panneau2());
		

		    // this.setContentPane(pan);
		this.setContentPane(new Panneau());
		this.setVisible(true);
		
		
		pan.addKeyListener(new testclavier());
		 
	  }
	
	
	
	
	
	class testclavier implements KeyListener{
		    public void keyPressed(KeyEvent event) {
		      
		      if(!jeu.partiEstFini()){
		          System.out.println("direction");
		          
		        if(event.getKeyCode()==38){
		          jeu.deplacerEnHaut();
		          
		        }else{
		          if(event.getKeyCode()==40){
		            jeu.deplacerEnBas();
		            
		          }else{
		           if(event.getKeyCode()==39){
		             jeu.deplacerAGauche();
		           }else{
		             if(event.getKeyCode()==37){
		             jeu.deplacerADroite();
		            }
		         }
		         }
		       }
		         jeu.affichePlateau();
		         i++;
		       }else{
		         if(j==0){
		           jeu.afficheTableauDeBloc();
		           System.out.println("fin de parti . Nombre de coup "+i);
		           j++;
		         }
		       }
		      
		     }
		 
		     public void keyReleased(KeyEvent event) {}
		 
		     public void keyTyped(KeyEvent event) {}     
		     
		    
		   }   
		   static Plateau jeu= new Plateau("fichier/file.txt");
		   int i=0,j=0;
		
		
		
		
}
	



