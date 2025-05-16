/**
 * La classe <code>FenetreDebut</code> représente la fenêtre de démarrage du jeu SameGame.
 * Elle affiche le menu principal permettant de démarrer une nouvelle partie, charger une partie ou quitter le jeu.
 *
 * @version 1.6
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */

 import javax.swing.*;
 import java.awt.*;
 
 public class FenetreDebut extends JFrame {
 
     /**
      * Constructeur de la fenêtre de démarrage.
      * Initialise les composants graphiques du menu d’accueil avec une grille vide et un fond personnalisé.
      */
     public FenetreDebut() {
         super("SameGame");
 
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.setSize(765, 510);
         this.setLocationRelativeTo(null);
 
         JPanel imagePanel = new JPanel();
         imagePanel.setLayout(new GridLayout(1, 1));
 
         Grille grille = new Grille();
         PaintFenetreDebut paint = new PaintFenetreDebut(grille, this);
         imagePanel.add(paint);
         this.add(imagePanel);
     }
 }
 