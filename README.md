# SameGame – SAE 2.1

## Description du projet

SameGame est un jeu solo développé en Java dans lequel le joueur doit supprimer des groupes de blocs de même couleur afin de vider la grille et maximiser son score.  
Le projet a été réalisé dans le cadre du BUT Informatique – SAE 2.1, en utilisant uniquement l’API standard Java, sans bibliothèques externes.

---

## Fonctionnalités principales

- Interface graphique interactive :
  - Menu de démarrage avec bouton "Jouer", "Quitter" et option pour choisir quel type de  grille
  - Grille rempli de formes, de différentes couleurs avec clics interactifs avec le score et le meilleur score
  - Menu de fin avec score final
- Mécanique de jeu :
  - Suppression des groupes de 2 blocs ou plus de la même couleur
  - Application automatique de la gravité (les blocs tombent)
  - Décalage des colonnes vides vers la gauche
  - Calcul du score en fonction du nombre de blocs supprimés
- Système de score :
  - Affichage du score en temps réel
  - Sauvegarde et affichage du meilleur score dans `highscore.txt`

---

## Fichiers importants

- `Main.java` : Lance le jeu.  
- `Grille.java` : Gère la logique du jeu (grille, suppression, gravité, score...).  
- `JeuBlocs.java` : Composant graphique affichant la grille.  
- `ControleurSouris.java` : Gère les clics de l'utilisateur.  
- `Fenetre.java` : Fenêtre principale.  
- `FenetreDebut.java` / `PaintFenetreDebut.java` : Menu de démarrage.  
- `FenetreFin.java` / `PaintFenetreFin.java` : Menu de fin.  
- `Score.java` : Calcule et gère le score du joueur.  
- `MouseFenetreDebut.java` / `MouseFenetreFin.java` : Gestion des clics sur les menus.  
- `highscore.txt` / `score.txt` : Fichiers de sauvegarde du score.

---

## Ressources

Les images suivantes doivent être placées dans un dossier `image/` :

- `Coeur.jpg` : Bloc rouge  
- `Croix.jpg` : Bloc vert  
- `Carre.jpg` : Bloc bleu  
- `Vide.jpg` : Bloc vide 
- `MenuDebut.jpg` : Menu d’accueil
- `MenuDebutSelection.jpg` : Menu après sélection
- `MenuFin.jpg` : Menu de fin

---

## Compilation et exécution

### Avec Makefile (recommandé) :

```bash
make
make run
```

## Auteurs

Ce projet a été réalisé dans le cadre d'une situation d'apprentissage et d'évaluation au sein de la formation de BUT informatique à Fontainebleau avec comme auteurs :
Wael ATIK et Emmanuel TIAMZON.
