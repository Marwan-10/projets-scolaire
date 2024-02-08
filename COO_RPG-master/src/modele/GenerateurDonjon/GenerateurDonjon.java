package modele.GenerateurDonjon;

import java.util.Random;

import static modele.Couleur.*;

public abstract class GenerateurDonjon {

    private int tour = 0;
    private int salle = 0;
    private boolean capaciteActive = false;


    //méthode qui créé une salle de donjon en réalité
    //TODO ajouter une vrai classe donjon avec le pattern méthode qui compte les tours
    public static void genererDonjon(int hauteur, int largeur){//TODO à découper en generateur donjonSteampunk et medievale
        // Vérification des paramètres
        if (hauteur <= 0 || largeur <= 0) {
            System.out.println("La hauteur et la largeur doivent être supérieures à zéro.");
            return;
        }

        // Création d'une matrice représentant le donjon
        char[][] donjon = new char[hauteur][largeur];

        // Initialisation de la matrice avec des murs noirs
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                donjon[i][j] = ' ';
            }
        }

        placerSymbole(donjon, '$'); // générateur de coffre
        placerSymbole(donjon, 'C');

        // Mise en couleur des murs noirs et de la partie centrale verte
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (i == 0 || j == 0 || i == hauteur-1 || j == largeur-1) {
                    System.out.print(ANSI_BLACK_BACKGROUND + " " + ANSI_RESET);
                } else if (donjon[i][j] == '$') {
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + donjon[i][j] + ANSI_RESET);
                } else if (donjon[i][j] == 'C') {
                    System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK + donjon[i][j] + ANSI_RESET);
                } else {
                    System.out.print(ANSI_GREEN_BACKGROUND + " " + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    //méthode générique pour ajouter des éléments aléatoirement dans une salle de donjon
    private static void placerSymbole(char[][] donjon, char symbole) {
        Random rand = new Random();
        int xPosition, yPosition;

        do {
            xPosition = rand.nextInt(donjon.length - 2) + 1;
            yPosition = rand.nextInt(donjon[0].length - 2) + 1;
        } while (donjon[xPosition][yPosition] != ' ');

        donjon[xPosition][yPosition] = symbole;
    }

    public int getSalle() {
        return salle;
    }

    public int getTour() {
        return tour;
    }
}
