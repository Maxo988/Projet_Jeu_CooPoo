package Generators;

import java.util.ArrayList;
import java.util.Random;
import Monstres.Comportement;
import Monstres.Monstre;
import Monstres.Boss;
import Objets.Arme;
import Objets.Equipement;
import Environement.Etage;

public class GeneratorMonstre {
    private ArrayList<Monstre> listMonstre = new ArrayList<>();
    Random randomGenerator = new Random();

    public GeneratorMonstre()
    {
    }

    public Monstre genereMonstre(int difficulte)
    {
        int somme = 0;
        int poidsTotal = 0;
        int poidsActuel = 0;

        switch(difficulte)
        {
            case 1:
                Monstre Ambystoma = new Monstre(
                        "Ambystoma",
                        1,
                        0,
                        "Vous tombez sur ce monstre",
                        "Un petit animal a l’air inoffensif et tout mignon … Vous n’allez quand même pas faire ce à quoi je pense ?",
                        "taser",
                        Comportement.INOFFENSIF,
                        "Espèce rare d’axolotl, animaux de compagnie de l’IA. Il ne vous attaquera pas, ne se défendra pas.",
                        100);
                Monstre Cotylorhiza = new Monstre(
                        "Cotylorhiza",
                        100,
                        10,
                        "Vous tombez sur ce monstre",
                        "Sorte de méduse ressemblant à un oeuf au plat volant",
                        "Lance harpon",
                        Comportement.DEFENSIF,
                        "Avec son air gluant et ses tentacules menaçantes, il ne faut probablement pas s’en approcher. Une arme à distance comme un lance-harpon serait plus efficace.",
                        2);
                Monstre Cornuta = new Monstre(
                        "Cornuta",
                        150,
                        10,
                        "Vous tombez sur ce monstre",
                        "Description à définir.",
                        "Torche",
                        Comportement.AGRESSIF,
                        "Baudroie géante mutée, bien qu’elle émette de la lumière elle même, elle la craint comme la peste.",
                        3);

                listMonstre.add(Ambystoma);
                listMonstre.add(Cotylorhiza);
                listMonstre.add(Cornuta);

                for(Monstre monstre :  listMonstre)
                {
                    poidsTotal += monstre.getPoids();
                }
                int tirage = randomGenerator.nextInt(3);
                tirage +=1;
                for(Monstre monstre : listMonstre)
                {
                    poidsActuel += monstre.getPoids();
                    if(poidsActuel >= tirage)
                    {
                        return(monstre);
                    }
                }
                ;break;
            case 2:
                return null;
                ;break;
            case 3:
                return null;
                ;break;
            default:
                return null;
        }
    }

}
