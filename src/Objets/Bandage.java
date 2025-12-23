package Objets;
import Joueur.Joueur;
import Monstres.Monstre;

public class Bandage extends Equipement{
    protected int Soin;

    public Bandage (String nom, String description, int poids, int soin){
        super(nom, description, poids);
        this.Soin = soin = 30;
    }

    public void utiliser(Joueur joueur, Monstre monstre) {
        if (joueur != null) {
            System.out.println("Vous tenter de soigner vos dégats en utilisant les bandages que vous avez " +
                    " trouvés, espérons que cela fonctionne pour vous.");
            joueur.gagnerPv(30);
        }
    }
}
