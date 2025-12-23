package Objets;

import Joueur.Joueur;
import Monstres.Monstre;

public class Torche extends Equipement{

    public Torche (String nom, String description, int poids){
        super(nom, description, poids);
    }

    public void utiliser(Joueur joueur, Monstre monstre) {
        System.out.println("Votre lampe torche est allumé, ce qui vous permet de " + 
                "découvrir votre environnement ");
    }
    
    public void utiliserC(Monstre monstre) {
        System.out.println("Vous essayez d'éblouir le monstre");
    }
}
