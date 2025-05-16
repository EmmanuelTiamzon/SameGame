import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * La classe <code>ControleurSouris</code> gère les clics de souris dans le jeu SameGame.
 * Elle permet de supprimer un groupe de blocs lorsqu’un clic est effectué,
 * de mettre à jour le score et de rafraîchir la vue.
 *
 * @version 1.9
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */
public class ControleurSouris extends MouseAdapter {

    /** La grille logique du jeu. */
    private Grille grille;

    /** La vue graphique du jeu. */
    private JeuBlocs vue;

    /** Le label affichant le score du joueur. */
    private JLabel labelScore;

    /** Le score du joueur */
    private Score score;

    /** La fenêtre principale. */
    private Fenetre fenetre;

    /**
     * Constructeur du contrôleur souris.
     *
     * @param grille la grille du jeu
     * @param vue la vue graphique contenant les blocs
     * @param labelScore le label affichant le score
     * @param fenetre la fenêtre principale du jeu
     */
    public ControleurSouris(Grille grille, JeuBlocs vue, JLabel labelScore, Fenetre fenetre) {
        this.score = new Score();
        this.grille = grille;
        this.vue = vue;
        this.labelScore = labelScore;
        this.fenetre = fenetre;
    }

    /**
     * Méthode appelée lorsqu’un clic est détecté.
     * Elle supprime le groupe de blocs cliqué (s’il est valide),
     * met à jour le score et rafraîchit l’affichage.
     *
     * @param e l’événement souris
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int tailleBloc = vue.getTailleBloc();
        int ligne = e.getY() / tailleBloc;
        int colonne = e.getX() / tailleBloc;
        
        if (ligne >= 0 && ligne < grille.getLignes() && colonne >= 0 && colonne < grille.getColonnes()) {
            if (grille.estGroupe(ligne, colonne)) {
                grille.supprimerGroupe(ligne, colonne);
                labelScore.setText("Score actuel : " + score.getScore() + "  Meilleur score : " + score.getHighestScore());
                vue.mettreAJourCouleurs();
                
                if (grille.jeuFini()) {
                    fenetre.dispose();
                    FenetreFin fenetreFin = new FenetreFin(score.getScore());
                    if (score.getScore() > score.getHighestScore() || score.getHighestScore() == 0) {
                        score.setHighestScore(score.getScore());
                    }

                    fenetreFin.setVisible(true);
                }
            }
        }
    }
}

