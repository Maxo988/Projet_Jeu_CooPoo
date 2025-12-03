package Objets;

public class Torche extends Equipement{

    public Torche (String nom, String description, int poids){
        super(nom, description, poids);
    }

    public void utiliser() {
        System.out.println("Votre lampe torche est allumé, ce qui vous permet de " + 
                "découvrir votre environnement ");
    }
    
    public void utiliserC() {
        // à finir : torche si point faible va faire fuir le monstre et mettre fin au combat
        System.out.println("Vous essayez d'éblouir le monstre");
    }
}
