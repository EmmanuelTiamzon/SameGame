import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>PaintFenetreFin</code> gère l'affichage graphique de la fenêtre de fin du jeu.
 * Elle affiche l'image de fond ainsi que le score final du joueur.
 *
 * @version 1.8
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */
public class PaintFenetreFin extends JComponent {

    /** L'image de fond du menu de fin. */
    private Image MenuFin;

    /** Le score final du joueur. */
    private int score;

    /**
     * Constructeur de la classe <code>PaintFenetreFin</code>.
     * Initialise l'image de fond et le score final du joueur.
     *
     * @param score le score final du joueur
     */
    public PaintFenetreFin(int score) {
        this.MenuFin = Toolkit.getDefaultToolkit().getImage("../image/MenuFin.jpg");
        this.score = score;
    }

    /**
     * Méthode de dessin du composant. Cette méthode est appelée pour afficher
     * l'image de fond ainsi que le score du joueur sur la fenêtre de fin.
     *
     * @param pinceau l'objet graphique utilisé pour dessiner
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();

        if (this.isOpaque()) {
            secondPinceau.setColor(this.getBackground());
            secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        secondPinceau.drawImage(this.MenuFin, 0, 0, this.getWidth(), this.getHeight(), this);

        // Création du label pour afficher le score
        JLabel scoreLabel = new JLabel("Score: " + this.score, JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 36));
        scoreLabel.setForeground(Color.WHITE);

        // Calcul des dimensions et position du label
        int labelWidth = scoreLabel.getPreferredSize().width;
        int labelHeight = scoreLabel.getPreferredSize().height;
        int x = (this.getWidth() - labelWidth) / 2;
        int y = (this.getHeight() - labelHeight) / 2 - 40;

        scoreLabel.setBounds(x, y, labelWidth, labelHeight);
        this.add(scoreLabel);
    }
}
