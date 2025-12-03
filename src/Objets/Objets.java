package Objets;

public class Objets extends Tresor{
    protected String nom;
    protected String description;
    protected int poids;

    public Objets (String nom, String description, int poids){
        super();
        this.nom = nom;
        this.description = description;
        this.poids = poids;
    }

    public void visualiser() {
        System.out.println(" Détails de l'Objet :");
        System.out.println("Nom: " + this.nom);
        System.out.println("Description: " + this.description);
        System.out.println("Poids: " + this.poids + " kg");
        }


    public String getNom() {
    return (nom);
    }

    public String getDescription () {
    return (description);
    }

    public int getPoids() {
    return (poids);
    }

    public void recuperer(){
        System.out.println("Vous avez obtenu un(e)" + nom + " utilisez le à bon escient.");
    }

}
