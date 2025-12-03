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
        System.out.println("Vous essayez d'éblouir le monstre");
    }
}
