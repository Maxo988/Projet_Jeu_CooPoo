package Objets;
import Monstres.Monstre;
import Joueur.Joueur;

import static java.lang.Boolean.TRUE;

public class InfosMonstre extends Tresor {
    private Monstre monstre;

    public InfosMonstre(Monstre monstre)
    {
        super();
        this.monstre = monstre;
    }

    public void visulatiser()
    {
        if(obtenu)
            System.out.println(monstre.getNom()+" "+ monstre.getPv()+ " "+ monstre.getComportement() + " " + monstre.getDescription() + " " + monstre.getInfoSpes());
        else
            System.out.println(monstre.getNom()+" "+ monstre.getPv()+ " "+ monstre.getComportement() + " " + monstre.getDescription());
    }

    public void recuperer()
    {
        System.out.println("Vous avec récupéré une note.");
        obtenu = TRUE;
    }
}
