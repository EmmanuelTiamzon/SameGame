/**
 * La classe <code>Main</code> contient le point d’entrée principal du jeu SameGame.
 * Elle initialise et affiche la fenêtre de démarrage du jeu à l'aide de la classe <code>FenetreDebut</code>.
 *
 * @version 1.5
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */
public class Main {

    /**
     * Méthode principale du programme. Elle lance l'application SameGame
     * en affichant la fenêtre d'accueil du jeu.
     *
     * @param args les arguments passés en ligne de commande (non utilisés ici)
     */
    public static void main(String[] args) {
        FenetreDebut fenetredebut = new FenetreDebut();
        fenetredebut.setVisible(true);
    }
}
