import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;
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
                                jeu.afficheTableauDeBloc();
            }else{
   
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
                                    System.out.println("Tu es un bon toi, tu a droit a une fessé");
                            }
            }
     
    }

    public void keyReleased(KeyEvent event) {}

    public void keyTyped(KeyEvent event) {}           
  }   
  
  static int j=0;
  static String s="src/file"+j+".txt";
  static Plateau jeu= new Plateau(s);
 
  public static  void main(String[] args){
          System.out.println("NIVAU "+(j+1));
                System.out.println("taille:"+jeu.tableauDeBlock.size());
                jeu.affichePlateau();
                //jeu.masterChalenge.affiche();
                jeu.afficheTableauDeBloc();
          new Fenetre1();
          
  }
}