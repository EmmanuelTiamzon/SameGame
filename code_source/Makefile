### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Main.class : Main.java Fenetre.class
	${JC} ${JCFLAGS} Main.java

Fenetre.class : Fenetre.java Grille.class JeuBlocs.class ControleurSouris.class
	${JC} ${JCFLAGS} Fenetre.java

FenetreDebut.class : FenetreDebut.java PaintFenetreDebut.class MouseFenetreDebut.class
	${JC} ${JCFLAGS} FenetreDebut.java

FenetreFin.class : FenetreFin.java PaintFenetreFin.class MouseFenetreFin.class
	${JC} ${JCFLAGS} FenetreFin.java

Grille.class : Grille.java
	${JC} ${JCFLAGS} Grille.java

GrillePaint.class : GrillePaint.java Grille.class
	${JC} ${JCFLAGS} GrillePaint.java

JeuBlocs.class : JeuBlocs.java Grille.class Score.class
	${JC} ${JCFLAGS} JeuBlocs.java

ControleurSouris.class : ControleurSouris.java Grille.class JeuBlocs.class
	${JC} ${JCFLAGS} ControleurSouris.java

MouseFenetreDebut.class : MouseFenetreDebut.java
	${JC} ${JCFLAGS} MouseFenetreDebut.java

MouseFenetreFin.class : MouseFenetreFin.java
	${JC} ${JCFLAGS} MouseFenetreFin.java

PaintFenetreDebut.class : PaintFenetreDebut.java
	${JC} ${JCFLAGS} PaintFenetreDebut.java

PaintFenetreFin.class : PaintFenetreFin.java
	${JC} ${JCFLAGS} PaintFenetreFin.java

Score.class : Score.java
	${JC} ${JCFLAGS} Score.java

### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###
