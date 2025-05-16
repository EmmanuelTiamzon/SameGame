import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * La classe <code>MouseFenetreDebut</code> gère les événements de souris pour les différentes fenêtres 
 * au début du jeu. Elle permet de changer d'état de fenêtre en fonction des clics de souris et de gérer
 * les actions associées (lancement du jeu, ouverture de fichiers, etc.).
 *
 * @version 1.6
 * @author Emmanuel Srivastava-Tiamzon & Wael Atik
 */
public class MouseFenetreDebut extends MouseAdapter {

    /** L'attribut qui instancie l'état actuel de la fenêtre. */
    private int fenetreActuelle;

    /** L'attribut qui gère le dessin de la fenêtre de début. */
    private PaintFenetreDebut paintComponent;

    /** L'attribut représentant la grille du jeu. */
    private Grille grille;

    /** L'attribut qui instancie un objet de type Fenetre*/
    private FenetreDebut fenetre;

    /**
     * Constructeur de la classe <code>MouseFenetreDebut</code>.
     * Initialise l'état de la fenêtre et les composants nécessaires.
     *
     * @param paintComponent l'objet qui gère le dessin de la fenêtre de début
     * @param grille l'objet représentant la grille du jeu
     */
    public MouseFenetreDebut(PaintFenetreDebut paintComponent, Grille grille, FenetreDebut fenetre) {
        this.fenetreActuelle = 1;
        this.paintComponent = paintComponent;
        this.grille = grille;
        this.fenetre = fenetre;
    }

    /**
     * Retourne l'état actuel de la fenêtre.
     *
     * @return l'état actuel de la fenêtre
     */
    public int getEtatFenetre() {
        return this.fenetreActuelle;
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
     * Méthode appelée lorsqu'un clic est effectué dans la fenêtre.
     * Cette méthode gère les actions à effectuer en fonction de l'état de la fenêtre actuelle.
     *
     * @param e l'événement de clic de souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        switch (fenetreActuelle) {
            case 1:
                if (isInArea(x, y, 290, 285, 182, 78)) {
                    fenetreActuelle = 2;
                    paintComponent.repaint();
                } else if (isInArea(x, y, 300, 400, 200, 75)) {
                    System.exit(0); 
                }
                break;

            case 2:
                if (isInArea(x, y, 180, 340, 180, 60)) {
                    fenetre.dispose();
                    new Fenetre(); 
                } else if (isInArea(x, y, 400, 340, 180, 75)) {
                    File fichier = choisirFichierGrille();
                    if(fichier != null) {
                        char[][] tableau = getGrilleFromFile(fichier);
                        Grille grilleChoisi = new Grille(tableau);
                        fenetre.dispose();
                        new Fenetre(grilleChoisi);


                    }
                } else if (isInArea(x, y, 300, 400, 200, 75)) {
                    System.exit(0); 
                }
                break;

            default:
                break;
        }
    }

    /**
     * Ouvre un sélecteur de fichiers pour choisir un fichier à partir du système de fichiers.
     */
    public File choisirFichierGrille() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir une grille texte");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Fichiers texte", "txt"));

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            System.out.println("Aucun fichier sélectionné");
            return null;
        }
    }

    /**
     * Lit un fichier voulu pour crée et renvoyer une grille de char[][]
     * @param fileGrille est utilisé en tant que fichier choisi par JFilechooser
     * @return Une grille adéquat pour le constructeur de la classe <code>Grille</code> 
     */    
    public char[][] getGrilleFromFile(File fileGrille) {
		char[][] newGrille = new char[10][15];

		try {
			FileReader grilleReader = new FileReader(fileGrille);
			BufferedReader bufferedreader = new BufferedReader(grilleReader);
			String line = bufferedreader.readLine();

			for(int i = 0; line != null && i < 10; i++) {
				if(line.length() >= 15) {
                	for(int j = 0; j < 15; j++) {
                    	newGrille[i][j] = line.charAt(j);
                	}
            	} else {
                	System.err.println("Ligne " + i + " trop courte : " + line);
            	}
				line = bufferedreader.readLine();
			}

			try {
				bufferedreader.close();
			} catch(IOException e) {
				System.err.println("Erreur de fermeture de fichier : "+e);
			}
		} catch(IOException e) {
			System.err.println("Erreur d'ouverture de fichier : "+e);
		} catch(NumberFormatException e) {
			System.err.println("Le contenu du fichier n'est pas valide : "+e);
		}

		return newGrille;
	}

}
