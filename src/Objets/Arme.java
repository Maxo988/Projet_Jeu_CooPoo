package Objets;

public class Arme extends Item {
    protected int MaxDmg;
    protected int MinDamage;

    public Arme (int ID, String Nom, String Description,int Poids, int MinDamage, int MaxDmg) {
        super(ID, Nom, Description, Poids);
        this.MaxDmg = MaxDmg;
        this.MinDamage = MinDamage;
    }
}
