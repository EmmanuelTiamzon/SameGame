/**
 * La classe <code>Fenetre</code> représente la fenêtre principale du jeu SameGame.
 * Elle contient l’affichage graphique de la grille, le score, et le contrôleur de la souris.
 *
 * @version 1.7
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */

 import javax.swing.*;
 import java.awt.*;
 
 public class Fenetre extends JFrame {
 
     /** Label affichant le score du joueur. */
     private JLabel labelScore;
 
     /**
      * Constructeur de la fenêtre principale.
      * Initialise les composants graphiques du jeu : la grille, la vue, le score et le contrôleur souris.
      */
     public Fenetre() {
         super("SameGame");
 
         Grille grille = new Grille();
 
         int tailleBloc = 50;
         int largeur = grille.getColonnes() * tailleBloc;
         int hauteur = grille.getLignes() * tailleBloc;
 
         JeuBlocs vue = new JeuBlocs(grille, largeur, hauteur);
         this.labelScore = new JLabel("Score : 0");
         this.labelScore.setHorizontalAlignment(SwingConstants.CENTER);
         this.labelScore.setFont(new Font("Arial", Font.BOLD, 18));
 
         ControleurSouris controleur = new ControleurSouris(grille, vue, this.labelScore,this);
         vue.addMouseListener(controleur);
 
         this.setLayout(new BorderLayout());
         this.add(this.labelScore, BorderLayout.NORTH);
         this.add(vue, BorderLayout.CENTER);
 
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(largeur + 11, hauteur + 61);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
     }
     /**
      * Par polymorphisme on crée un nouveau constructeur pour qu'il s'adapte à une grille predefini 
      */
     public Fenetre(Grille grille) {
         super("SameGame");
 
         int tailleBloc = 50;
         int largeur = grille.getColonnes() * tailleBloc;
         int hauteur = grille.getLignes() * tailleBloc;
 
         JeuBlocs vue = new JeuBlocs(grille, largeur, hauteur);
         this.labelScore = new JLabel("Score : 0");
         this.labelScore.setHorizontalAlignment(SwingConstants.CENTER);
         this.labelScore.setFont(new Font("Arial", Font.BOLD, 18));
 
         ControleurSouris controleur = new ControleurSouris(grille, vue, this.labelScore,this);
         vue.addMouseListener(controleur);
 
         this.setLayout(new BorderLayout());
         this.add(this.labelScore, BorderLayout.NORTH);
         this.add(vue, BorderLayout.CENTER);
 
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(largeur + 11, hauteur + 61);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
     }
 }
 
 
 
 