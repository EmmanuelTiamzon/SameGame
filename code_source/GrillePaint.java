/**
 * La classe <code>GrillePaint</code> représente une grille graphique initialisée aléatoirement
 * pour l’affichage de blocs colorés dans le jeu SameGame.
 * Elle utilise des images pour représenter les blocs rouges, verts et bleus.
 *
 * @version 1.5
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */

 import javax.swing.*;
 import java.awt.*;
 import java.util.Random;
 
 public class GrillePaint extends JComponent {
 
     /** Nombre de colonnes dans la grille. */
     public static final int COLONNES = 15;
 
     /** Nombre de lignes dans la grille. */
     public static final int LIGNES = 10;
 
     /** Tableau représentant la grille de blocs. */
     private char[][] grille;
 
     /**
      * Constructeur de la grille graphique.
      * Initialise chaque case avec une couleur aléatoire parmi 'R', 'V' et 'B'.
      */
     public GrillePaint() {
         super();
         this.grille = new char[this.LIGNES][this.COLONNES];
         char[] couleurs = {'R', 'V', 'B'};
         Random random = new Random();
 
         for (int i = 0; i < this.LIGNES; i++) {
             for (int j = 0; j < this.COLONNES; j++) {
                 grille[i][j] = couleurs[random.nextInt(3)];
             }
         }
     }
 
     /**
      * Méthode de dessin de la grille. Affiche les images correspondant à chaque bloc.
      *
      * @param pinceau l'objet <code>Graphics</code> utilisé pour dessiner
      */
     @Override
     public void paintComponent(Graphics pinceau) {
         Graphics secondPinceau = pinceau.create();
         if (this.isOpaque()) {
             secondPinceau.setColor(this.getBackground());
             secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
         }
 
         Image imgR = Toolkit.getDefaultToolkit().getImage("../image/Coeur.png");
         Image imgV = Toolkit.getDefaultToolkit().getImage("../image/Croix.png");
         Image imgB = Toolkit.getDefaultToolkit().getImage("../image/Carre.png");
 
         int tailleBloc = Math.min(getWidth() / COLONNES, getHeight() / LIGNES);
 
         for (int i = 0; i < this.LIGNES; i++) {
             for (int j = 0; j < this.COLONNES; j++) {
                 int x = j * tailleBloc;
                 int y = i * tailleBloc;
 
                 switch (this.grille[i][j]) {
                     case 'R':
                         secondPinceau.drawImage(imgR, x, y, tailleBloc, tailleBloc, this);
                         break;
                     case 'V':
                         secondPinceau.drawImage(imgV, x, y, tailleBloc, tailleBloc, this);
                         break;
                     case 'B':
                         secondPinceau.drawImage(imgB, x, y, tailleBloc, tailleBloc, this);
                         break;
                 }
             }
         }
     }
 }
 