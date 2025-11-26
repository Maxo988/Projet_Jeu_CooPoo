package Objets;

public  class Item {
    protected String nom;
    protected String description;
    protected boolean obtenu = false;


    public Item(String Nom, String Description) {
        this.nom = Nom;
        this.description = Description;
    }
}
