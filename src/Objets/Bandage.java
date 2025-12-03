package Objets;

public class Bandage extends Equipement{
    protected int Soin;

    public Bandage (String nom, String description, int poids, int soin){
        super(nom, description, poids);
        this.Soin = soin;
    }
}
