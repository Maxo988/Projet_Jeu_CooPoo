package Objets;

public class Arme extends Item {
    protected int Damage;

    public Arme (String Nom, String Description, int Damage) {
        super(Nom, Description);
        this.Damage=Damage;
    }
}
