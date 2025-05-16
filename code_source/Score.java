/**
 * La classe <code>Score</code> est utilisée pour donner le score inscrit dans un fichier
 * ou pour changer la valeur du score.
 *  
 * @version 1.6
 * @author Emmanuel SRIVASTAVA-TIAMZON & Wael Atik
 */

/**
 * Bibliothèque indispensable pour l'usage d'un fichier.
 */ 
import java.io.*;

public class Score {

/**
 * Attribut qui instancie le score pour pouvoir modifier sa valeur plus tard.
 */
	private int score;

/**
 * Attribut qui instancie le fichier à utiliser pour pouvoir faciliter les méthodes.
 */
	private File scoreFile;

/**
 * Attribut qui instancie le plus haut score.
 */
	private int highestScore;

/**
 * Constructeur servant à mettre le score à 0 pour le réutiliser plus tard
 * et à choisir quel fichier utiliser.
 */
	public Score() {
		this.score = 0;
		this.scoreFile = new File("score.txt");
	}

/**
 * Remplace l'ancien score soit la valeur indiquée dans le fichier score.txt
 * @param score modifie le score stocké dans le fichier texte.
 */ 	
	public void setScore(int score) {
		this.score = score;

		try {
			FileWriter scoreWriter = new FileWriter(this.scoreFile);
			BufferedWriter bufferedWriter = new BufferedWriter(scoreWriter);

			bufferedWriter.write(String.valueOf(score));

			try {
				bufferedWriter.close();
			} catch(IOException e) {
				System.err.println("Erreur de fermeture de fichier : "+e);
			}
		} catch(IOException e) {
			System.err.println("Erreur d'ouverture de fichier : "+e);
		}
	}

/**
 * Renvoie le score soit la valeur indiqué dans le fichier score.txt
 * @return le score actuel dans le fichier crée
 */
	public int getScore() {
		try {
			FileReader scoreReader = new FileReader(this.scoreFile);
			BufferedReader bufferedreader = new BufferedReader(scoreReader);

			String line = bufferedreader.readLine();
			if(line != null) {
				this.score = Integer.parseInt(line); 
			}

			try {
				bufferedreader.close();
			} catch(IOException e) {
				System.err.println("Erreur de fermeture de fichier : "+e);
			}
		} catch(IOException e) {
			System.err.println("Erreur d'ouverture de fichier : "+e);
		} catch(NumberFormatException e) {
			System.err.println("Le contenu du fichier n'est pas un entier valide : "+e);
		}

		return this.score;

	}

/**
 * Lis le score soit la valeur indiquée dans le fichier score.txt 
 * pour ensuite lui ajouter la valeur du @param addons de cette méthode.
 * C'est un mélange de la méthode getScore et setScore.
 */ 
	public void addToScore(int addons){
		try {
			FileReader scoreReader = new FileReader(this.scoreFile);
			BufferedReader bufferedreader = new BufferedReader(scoreReader);

			String line = bufferedreader.readLine();
			int oldScore = Integer.parseInt(line);

			int newScore = oldScore + addons;

			try {
				FileWriter scoreWriter = new FileWriter(this.scoreFile);
				BufferedWriter bufferedWriter = new BufferedWriter(scoreWriter);

				bufferedWriter.write(String.valueOf(newScore));

				try{
					bufferedWriter.close();
				}catch(IOException e) {
					System.err.println("Erreur de fermeture de fichier : "+e);
				}
			}catch(IOException e) {
				System.err.println("Erreur d'ouverture/d'écriture de fichier : "+e);
			}

			try {
				bufferedreader.close();
			}catch(IOException e) {
				System.err.println("Erreur de fermeture de fichier : "+e);
			}

		} catch(IOException e) {
			System.err.println("Erreur de lecture de fichier : "+e);
		}
	}

/**
 * Remet le score à 0 grâçe à la méthode setScore.
 */ 
	public void resetScore() {
		setScore(0);
	}

/**
 * remplace l'ancien meilleur dans le fichier highscore.txt
 * @param newBestScore remplace l'ancienne valeur placée dans le fichier highscore.txt
 */
	public void setHighestScore(int newBestScore) {
		this.score = newBestScore;

		try {
			File bestScoreFile = new File("highscore.txt");
			FileWriter scoreWriter = new FileWriter(bestScoreFile);
			BufferedWriter bufferedWriter = new BufferedWriter(scoreWriter);

			bufferedWriter.write(String.valueOf(newBestScore));

			try {
				bufferedWriter.close();
			} catch(IOException e) {
				System.err.println("Erreur de fermeture de fichier : "+e);
			}
		} catch(IOException e) {
			System.err.println("Erreur d'ouverture de fichier : "+e);
		}

	}
/**
 * @return le plus haut score stocké dans un fichier highscore.txt
 */
	public int getHighestScore() {
		try {
			File bestScoreFile = new File("highscore.txt");
			FileReader scoreReader = new FileReader(bestScoreFile);
			BufferedReader bufferedreader = new BufferedReader(scoreReader);

			String line = bufferedreader.readLine();
			if(line != null) {
				this.highestScore = Integer.parseInt(line); 
			}

			try {
				bufferedreader.close();
			} catch(IOException e) {
				System.err.println("Erreur de fermeture de fichier : "+e);
			}
		} catch(IOException e) {
			System.err.println("Erreur d'ouverture de fichier : "+e);
		} catch(NumberFormatException e) {
			System.err.println("Le contenu du fichier n'est pas un entier valide : "+e);
		}

		return this.highestScore;


	}

}