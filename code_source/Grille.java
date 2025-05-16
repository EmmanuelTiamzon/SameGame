import java.util.Random;

/**
 * La classe <code>Grille</code> représente la logique du jeu SameGame.
 * Elle gère la création aléatoire des blocs, la détection et suppression de groupes,
 * l’application de la gravité et le décalage des colonnes.
 *
 * @author Emmanuel Srivastava-Tiamzon & Wael ATIK
 * @version 1.8
 */
public class Grille {

    private static final int LIGNES = 10;
    private static final int COLONNES = 15;
    private final char[][] grille;
    private Score score;

    /**
    * Constructeur : initialise la grille avec des blocs aléatoires.
    */
    public Grille() {
        this.grille = new char[LIGNES][COLONNES];
        this.score = new Score();
        this.score.setScore(0);
        char[] couleurs = {'R', 'V', 'B'};
        Random rand = new Random();

        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                grille[i][j] = couleurs[rand.nextInt(couleurs.length)];
            }
        }
    }

    /** 
	 * Par polymorphisme on adapte le constructeur pour que l'on puisse jouer avec une grille préféfini.
	 */
	public Grille(char[][] grille) {
		this.grille = grille;
		this.score = new Score();
        this.score.setScore(0);
	}

    /**
    * Vérifie si un groupe de blocs de même couleur existe à une position donnée.
    *
    * @param ligne   ligne de la case
    * @param colonne colonne de la case
    * @return true si un groupe valide (taille > 1) existe
    */
    public boolean estGroupe(int ligne, int colonne) {
        char couleur = grille[ligne][colonne];
        if (couleur == ' ') return false;

        boolean[][] visite = new boolean[LIGNES][COLONNES];
        return tailleGroupe(ligne, colonne, couleur, visite) > 1;
    }

    /**
    * Supprime un groupe de blocs si sa taille est supérieure à 1 et applique la gravité et le décalage.
    *
    * @param ligne   ligne de départ
    * @param colonne colonne de départ
    */
    public void supprimerGroupe(int ligne, int colonne) {
        char couleur = grille[ligne][colonne];
        if (couleur == ' ') return;

        boolean[][] visite = new boolean[LIGNES][COLONNES];
        int taille = tailleGroupe(ligne, colonne, couleur, visite);

        if (taille > 1) {
            this.score.addToScore((taille - 2) * (taille - 2));
            supprimerRec(ligne, colonne, couleur, new boolean[LIGNES][COLONNES]);
            appliquerGravite();
            appliquerDecalageGauche();
        }
    }

    /**
    * Calcule la taille d’un groupe avec un parcours en largeur.
    */
    private int tailleGroupe(int i, int j, char couleur, boolean[][] visite) {
        if (i < 0 || i >= this.LIGNES || j < 0 || j >= this.COLONNES) return 0;
        if (visite[i][j] || this.grille[i][j] != couleur) return 0;

        visite[i][j] = true;
        return 1
        + tailleGroupe(i + 1, j, couleur, visite)
        + tailleGroupe(i - 1, j, couleur, visite)
        + tailleGroupe(i, j + 1, couleur, visite)
        + tailleGroupe(i, j - 1, couleur, visite);
    }

    /**
    * Supprime récursivement un groupe avec un parcours en largeur.
    */
    private void supprimerRec(int i, int j, char couleur, boolean[][] visite) {
        if (i < 0 || i >= this.LIGNES || j < 0 || j >= this.COLONNES) return;
        if (visite[i][j] || this.grille[i][j] != couleur) return;

        visite[i][j] = true;
        this.grille[i][j] = ' ';

        supprimerRec(i + 1, j, couleur, visite);
        supprimerRec(i - 1, j, couleur, visite);
        supprimerRec(i, j + 1, couleur, visite);
        supprimerRec(i, j - 1, couleur, visite);
    }

    /**
    * Applique la gravité : fait tomber les blocs vers le bas.
    */
    private void appliquerGravite() {
        for (int col = 0; col < this.COLONNES; col++) {
            int ligneVide = this.LIGNES - 1;
            for (int i = this.LIGNES - 1; i >= 0; i--) {
                if (this.grille[i][col] != ' ') {
                    this.grille[ligneVide][col] = this.grille[i][col];
                    if (ligneVide != i) this.grille[i][col] = ' ';
                    ligneVide--;
                }
            }
        }
    }

    /**
    * Décale les colonnes vers la gauche si elles sont vides.
    */
    private void appliquerDecalageGauche() {
        int colDestination = 0;

        for (int colSource = 0; colSource < this.COLONNES; colSource++) {
            boolean colonneVide = true;

            for (int i = 0; i < this.LIGNES; i++) {
                if (this.grille[i][colSource] != ' ') {
                    colonneVide = false;
                    break;
                }
            }

            if (!colonneVide) {
                if (colDestination != colSource) {
                    for (int i = 0; i < this.LIGNES; i++) {
                        this.grille[i][colDestination] = this.grille[i][colSource];
                        this.grille[i][colSource] = ' ';
                    }
                }
                colDestination++;
            }
        }
    }

/**
 * Marque toutes les cases d’un groupe à partir d’une position donnée.
 *
 * @param couleur couleur du bloc de départ
 * @param i ligne de départ
 * @param j colonne de départ
 * @param surbrillance tableau où marquer les blocs du groupe
 */
    public void marquerGroupe(char couleur, int i, int j, boolean[][] surbrillance) {
        if (i < 0 || i >= this.LIGNES || j < 0 || j >= this.COLONNES) return;
        if (surbrillance[i][j] || this.grille[i][j] != couleur) return;

        surbrillance[i][j] = true;

        marquerGroupe(couleur, i + 1, j, surbrillance);
        marquerGroupe(couleur, i - 1, j, surbrillance);
        marquerGroupe(couleur, i, j + 1, surbrillance);
        marquerGroupe(couleur, i, j - 1, surbrillance);
    }

    /**
     
    Vérifie s’il reste des groupes de blocs valides
    @return true si le jeu est terminé, false sinon*/
    public boolean jeuFini() {
        for (int i = 0; i < this.LIGNES; i++) {
            for (int j = 0; j < this.COLONNES; j++) {
                char bloc = this.grille[i][j];
                if (bloc != ' ' && estGroupe(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCase(int i, int j) {
        return this.grille[i][j];
    }

    public char[][] getGrille() {
        return this.grille;
    }

    public int getLignes() {
        return this.LIGNES;
    }

    public int getColonnes() {
        return this.COLONNES;
    }

}