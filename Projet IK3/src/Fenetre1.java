import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre1 extends JFrame {

  private JTextField jtf;   
  public Fenetre1(){      
    jtf = new JTextField();
    JPanel top = new JPanel();      
    jtf.addKeyListener(new ClavierListener());
    top.add(jtf);

    this.setContentPane(top);
    this.setVisible(true);        
  }      

  class ClavierListener implements KeyListener{
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
  public static  void main(String[] args){
		System.out.println("taile:"+jeu.tableauDeBlock.size());
		jeu.affichePlateau();
	  new Fenetre1();
	  
  }
}