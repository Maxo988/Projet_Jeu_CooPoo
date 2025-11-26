package Objets;

public  class Item {
    protected int ID;
    protected String nom;
    protected String description;
    protected boolean obtenu = false;
    protected int poids;


    public Item(int ID, String Nom, String Description, int Poids) {
        this.ID = ID;
        this.nom = Nom;
        this.description = Description;
        this.poids = Poids;
    }
}
