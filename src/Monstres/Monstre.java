package Monstres;

public class Monstre {
    protected String nom;
    protected int currentHealth;
    protected int maxHealth;
    protected int maxDmg;
    protected int minDmg;
    protected String description;
    /*
    test push github
     */

    public Monstre(String nom, int maxHealth, int maxDmg, int minDmg, String description) {
        this.nom = nom;
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.maxDmg = maxDmg;
        this.minDmg = minDmg;
        this.description = description;
    }
}
