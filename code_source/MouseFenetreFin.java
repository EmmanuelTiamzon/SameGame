import javax.swing.*;
import java.awt.event.*;

/**
 * La classe <code>MouseFenetreFin</code> gère les événements de souris pour la fenêtre de fin de jeu.
 * Elle permet de lancer une nouvelle partie ou de quitter le jeu en fonction des clics de souris.
 *
 * @version 1.6
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */
public class MouseFenetreFin extends MouseAdapter {

    /** La fenêtre associée à la fin du jeu. */
    private JFrame fenetre;

    /**
     * Constructeur de la classe <code>MouseFenetreFin</code>.
     * Initialise la fenêtre de fin du jeu.
     *
     * @param fenetre la fenêtre de fin du jeu
     */
    public MouseFenetreFin(JFrame fenetre) {
        this.fenetre = fenetre;
    }

    /**
     * Vérifie si un clic de souris se trouve dans une zone définie par les coordonnées 
     * et les dimensions données.
     *
     * @param clickX la coordonnée X du clic
     * @param clickY la coordonnée Y du clic
     * @param x la coordonnée X de la zone
     * @param y la coordonnée Y de la zone
     * @param w la largeur de la zone
     * @param h la hauteur de la zone
     * @return true si le clic est dans la zone, false sinon
     */
    private boolean isInArea(int clickX, int clickY, int x, int y, int w, int h) {
        return clickX >= x && clickX <= x + w && clickY >= y && clickY <= y + h;
    }

    /**
     * Méthode appelée lorsqu'un clic est effectué dans la fenêtre de fin du jeu.
     * Cette méthode gère les actions à effectuer selon l'endroit où l'utilisateur clique.
     *
     * @param e l'événement de clic de souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (isInArea(x, y, 290, 270, 200, 75)) {
        fenetre.dispose();
        FenetreDebut fenetredebut = new FenetreDebut();
        fenetredebut.setVisible(true);
        } else if (isInArea(x, y, 300, 355, 200, 75)) {
            System.exit(0);
        }
    }
}
