package Environement;

public class Etage {
    private Salle[][] carte;
    private int posX;
    private int posY;
    private int difficulte;
    private final static int taille = 5;
    private boolean immergee = false;
    private final int departX = 2;
    private final int departY = 0;
    private final int finX = 2;
    private final int finY = 4;

    public Etage(int difficulte) {
        carte = new Salle[taille][taille];
        posX = departX;
        posY = departY;
        this.difficulte = difficulte;
    }

}
