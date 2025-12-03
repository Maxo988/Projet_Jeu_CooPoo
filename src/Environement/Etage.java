package Environement;

import java.util.ArrayList;
import java.util.Scanner;

public class Etage {
    private Salle[][] carte;
    private int posX;
    private int posY;
    private int difficulte;
    private final static int taille = 2;
    private boolean immergee = false;
    private final int departX = 0;
    private final int departY = 1;
    private final int finX = 1;
    private final int finY = 0;
    private final int maxX = taille - 1;
    private final int maxY = taille -1;
            ;

    public Etage(int difficulte) {
        carte = new Salle[taille][taille];
        posX = departX;
        posY = departY;
        this.difficulte = difficulte;
    }

    public void seDeplacer() {
        char direction = 'n';
        var choixDisponibles = new ArrayList<Character>();
        ArrayList<String> directionsDisponibles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        if (posX < maxX) {
            choixDisponibles.add('d');
            directionsDisponibles.add("D : Droite");
        }
        if (posY < maxY) {
            choixDisponibles.add('s');
            directionsDisponibles.add("S : Bas");
        }
        if (posX > 0) {
            choixDisponibles.add('q');
            directionsDisponibles.add("Q : Gauche");
        }
        if (posY > 0) {
            choixDisponibles.add('z');
            directionsDisponibles.add("Z : Haut");
        }
        while (true) {
        System.out.println("Choisir une direction");
        for (String directionsDisponible : directionsDisponibles) {
            System.out.println(directionsDisponible);
        }
        System.out.println("0 : Annuler");
        String stringChoix = scanner.nextLine();
            if (!stringChoix.isEmpty()) {
                direction = stringChoix.charAt(0);
                direction =  Character.toUpperCase(direction);
                if (choixDisponibles.contains(direction) || (direction == '0')) {
                    break;
                }
                else {
                    System.out.println("Erreur ! Votre saisie n'est pas conforme");
                }
            }
            else {
                System.out.println("Veuillez saisir un caractère");
            }
        }
        switch (direction) {
            case 'Z':
                posY--;
                break;
            case 'Q':
                posX--;
                break;
            case 'S':
                posY++;
                break;
            case 'D':
                posX++;
                break;
            case '0':
                break;
        }

    }

    public void arriverSalle(int x, int y) {

    }

}
