//Objets.java
package Objets;

/// @author gp2
public abstract class Objets extends Tresor{
    /// Nom de l'objet
    protected String nom;

    /// Description de l'objet
    protected String description;

    /// Poids de l'objet
    protected int poids;

    /// Constructeur customisé, les valeurs attribuées seront celles données lors de l'instanciation
    /// @param nom nom de l'objet
    /// @param description description de l'objet
    /// @param poids poids de l'objet
    public Objets (String nom, String description, int poids){
        super();
        this.nom = nom;
        this.description = description;
        this.poids = poids;
    }

    /// Permet de visualier les informations que l'on connait d'un objet
    public void visualiser() {
        System.out.println(" Détails de l'Objet :");
        System.out.println("Nom: " + this.nom);
        System.out.println("Description: " + this.description);
    }

    /// Retourne le nom de l'objet
    /// @return nom de l'objet
    public String getNom() {
        return (nom);
    }

    /// Retourne la description de l'objet
    /// @return description de l'objet
    public String getDescription () {
        return (description);
    }

    /// Retourne le poids de l'objet
    /// @return poids de l'objet
    public int getPoids() {
        return (poids);
    }

    /// Permets de récupérer un objet
    public void recuperer(){
        System.out.println("Vous avez obtenu un(e)" + nom + " utilisez le à bon escient.");
    }


}

