package Objets;

public class Objets {
    protected String nom;
    protected String description;
    protected boolean obtenu = false;
    protected int Poids;

    public Objets (String nom, String description, int Poids){
        this.nom = nom;
        this.description = description;
        this.Poids = Poids;
        this.obtenu = false;
    }

}
