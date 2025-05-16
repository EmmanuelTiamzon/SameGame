/**
 * La classe <code>FenetreFin</code> représente la fenêtre affichée à la fin d'une partie de SameGame.
 * Elle affiche le score final du joueur et propose deux options : rejouer ou quitter le jeu.
 *
 * @version 1.7
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */

 import javax.swing.*;

 public class FenetreFin extends JFrame {
 
     /**
      * Constructeur de la fenêtre de fin de jeu.
      * Affiche l’écran final avec le score et les boutons "Rejouer" et "Quitter".
      *
      * @param score le score final obtenu par le joueur
      */
     public FenetreFin(int score) {
         super("Fin du Jeu");
 
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.setSize(765, 510);
         this.setLocationRelativeTo(null);
 
         PaintFenetreFin paintfenetrefin = new PaintFenetreFin(score);
         this.add(paintfenetrefin);
 
         MouseFenetreFin mouseListener = new MouseFenetreFin(this);
         paintfenetrefin.addMouseListener(mouseListener);
 
         this.setVisible(true);
     }
 }
 