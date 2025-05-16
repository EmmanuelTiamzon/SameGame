import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>PaintFenetreDebut</code> est un composant graphique personnalisé
 * qui gère l'affichage du menu de démarrage du jeu SameGame. Elle permet d'afficher
 * différentes images en fonction de l'état du menu et de gérer les interactions via la souris.
 *
 * @version 1.6
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */
public class PaintFenetreDebut extends JComponent {

    /** Image du menu principal */
    private Image MenuDebutI;

    /** Image du menu de sélection */
    private Image MenuDebutII;

    /** Le gestionnaire des événements de souris associé à cette fenêtre. */
    private MouseFenetreDebut mouseFenetre;

    /**
     * Constructeur de la classe <code>PaintFenetreDebut</code>.
     * Charge les images du menu et initialise le gestionnaire d'événements de souris.
     *
     * @param grille la grille du jeu à passer au gestionnaire de souris
     * @param fenetre la fenêtre principale de démarrage (FenetreDebut)
     */
    public PaintFenetreDebut(Grille grille, FenetreDebut fenetre) {
        this.MenuDebutI = Toolkit.getDefaultToolkit().getImage("../image/MenuDebut.jpg");
        this.MenuDebutII = Toolkit.getDefaultToolkit().getImage("../image/MenuDebutSelection.jpg");
        this.mouseFenetre = new MouseFenetreDebut(this, grille, fenetre);
        this.addMouseListener(this.mouseFenetre);
    }

    /**
     * Redéfinit la méthode <code>paintComponent</code> pour dessiner les éléments du menu.
     * Affiche l'image correspondant à l'état actuel du menu.
     *
     * @param pinceau le contexte graphique utilisé pour dessiner
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

        if (this.isOpaque()) {
            secondPinceau.setColor(this.getBackground());
            secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        switch (this.mouseFenetre.getEtatFenetre()) {
            case 1:
                secondPinceau.drawImage(this.MenuDebutI, 0, 0, 765, 510, this);
                break;
            case 2:
                secondPinceau.drawImage(this.MenuDebutII, 0, 0, 765, 510, this);
                break;
            default:
                secondPinceau.drawImage(this.MenuDebutI, 0, 0, 765, 510, this);
        }
    }
}
