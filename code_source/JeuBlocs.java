import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * La classe <code>JeuBlocs</code> est responsable de l'affichage graphique du jeu SameGame.
 * Elle affiche la grille avec ses blocs et gère la surbrillance des groupes de blocs lorsqu'ils sont survolés par la souris.
 *
 * @version 1.11
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */
public class JeuBlocs extends JComponent {

    /** La grille logique du jeu. */
    private Grille grille;

    /** Images représentant les blocs rouges, verts, bleus et vides. */
    private Image imageRouge;
    private Image imageVert;
    private Image imageBleu;
    private Image imageVide;

    /** La taille d'un bloc (en pixels). */
    private int tailleBloc;

    /** Tableau de booleans pour gérer la surbrillance des blocs. */
    private boolean[][] surbrillance;

    /**
     * Constructeur de la vue graphique du jeu SameGame.
     * Initialise les images des blocs, la taille des blocs et configure la gestion de la souris.
     *
     * @param grille la grille logique du jeu
     * @param largeur la largeur totale de la fenêtre (en pixels)
     * @param hauteur la hauteur totale de la fenêtre (en pixels)
     */
    public JeuBlocs(Grille grille, int largeur, int hauteur) {
        this.grille = grille;
        this.tailleBloc = Math.min(largeur / grille.getColonnes(), hauteur / grille.getLignes());
        this.setPreferredSize(new Dimension(largeur, hauteur));

        this.imageRouge = Toolkit.getDefaultToolkit().getImage("../image/Coeur.jpg");
        this.imageVert = Toolkit.getDefaultToolkit().getImage("../image/Croix.jpg");
        this.imageBleu = Toolkit.getDefaultToolkit().getImage("../image/Carre.jpg");
        this.imageVide = Toolkit.getDefaultToolkit().getImage("../image/Vide.jpg");
        this.surbrillance = new boolean[grille.getLignes()][grille.getColonnes()];

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int ligne = e.getY() / tailleBloc;
                int colonne = e.getX() / tailleBloc;

                if (ligne >= 0 && ligne < grille.getLignes() && colonne >= 0 && colonne < grille.getColonnes()) {
                    if (grille.estGroupe(ligne, colonne)) {
                        surbrillance = new boolean[grille.getLignes()][grille.getColonnes()];
                        grille.marquerGroupe(grille.getCase(ligne, colonne), ligne, colonne, surbrillance);
                    } else {
                        surbrillance = new boolean[grille.getLignes()][grille.getColonnes()];
                    }
                    repaint();
                }
            }
        });
    }

    /**
     * Méthode de dessin de la grille et des blocs.
     * Affiche les blocs et leur surbrillance si nécessaire.
     *
     * @param g l'objet graphique utilisé pour dessiner
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

		if (this.isOpaque()) {
			secondPinceau.setColor(this.getBackground());
			secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}

        char[][] gLogique = grille.getGrille();


        for (int i = 0; i < grille.getLignes(); i++) {
            for (int j = 0; j < grille.getColonnes(); j++) {
                char c = gLogique[i][j];
                Image image = switch (c) {
                    case 'R' -> imageRouge;
                    case 'V' -> imageVert;
                    case 'B' -> imageBleu;
                    default -> imageVide;
                };

                secondPinceau.drawImage(image, j * tailleBloc, i * tailleBloc, tailleBloc, tailleBloc, this);

                if (surbrillance[i][j]) {
                    secondPinceau.setColor(new Color(255, 255, 0, 80));
                    secondPinceau.fillRect(j * tailleBloc, i * tailleBloc, tailleBloc, tailleBloc);
                }

                secondPinceau.setColor(Color.BLACK);
                secondPinceau.drawRect(j * tailleBloc, i * tailleBloc, tailleBloc, tailleBloc);
            }
        }
    }

    /**
     * Méthode pour mettre à jour l'affichage graphique après une modification de la grille.
     * Elle appelle le repaint pour rafraîchir la vue.
     */
    public void mettreAJourCouleurs() {
        repaint();
    }

    /**
     * Retourne la taille d'un bloc (en pixels).
     *
     * @return la taille d'un bloc
     */
    public int getTailleBloc() {
        return tailleBloc;
    }
}
