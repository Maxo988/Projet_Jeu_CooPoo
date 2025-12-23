package Objets;
import Joueur.Joueur;
import Monstres.Monstre;

public class Arme extends Equipement {
    protected int degats;

    public Arme (String Nom, String Description, int Poids, int Degats) {
        super(Nom, Description, Poids);
        this.degats=Degats;
    }

    public void utiliser(Joueur joueur, Monstre monstre){
        if (monstre != null) {
            if (this.nom.equalsIgnoreCase(monstre.getPointFaible())) {
                monstre.perdrePv((int) (degats * 1.5));
                System.out.println("Bien joué, vous avez trouvé son point faible, " +
                        " le monstre semble vraiment sonné par votre attaque.");
            } else {
                monstre.perdrePv(degats);
                System.out.println("Votre attaque a fonctionné mais aurait été plus efficace avec " +
                        " une autre arme.");
            }
        }
    }

    public int getDegats() {
        return degats;
    }
}
