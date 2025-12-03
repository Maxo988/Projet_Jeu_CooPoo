package Objets;

public class Arme extends Equipement {
    protected int Degats;

    public Arme (String Nom, String Description, int Poids, int Degats) {
        super(Nom, Description, Poids);
        this.Degats=Degats;
    }
}
