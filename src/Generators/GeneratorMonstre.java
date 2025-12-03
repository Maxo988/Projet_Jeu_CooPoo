package Generators;
import java.util.ArrayList;
import java.util.Random;

import Monstres.Comportement;
import Monstres.Monstre;
import Monstres.Boss;
import Objets.Arme;
import Objets.Item;

public class GeneratorMonstre {
    private ArrayList<Monstre> listMonstre = new ArrayList<>();


    public GeneratorMonstre()
    {

    }

    public void initMonstre() {
        Monstre Ambystoma = new Monstre(
                "Ambystoma",
                1,
                0,
                "Un petit animal a l’air inoffensif et tout mignon … Vous n’allez quand même pas faire ce à quoi je pense ?",
                "taser",
                Comportement.INOFFENSIF,
                "Espèce rare d’axolotl, animaux de compagnie de l’IA. Il ne vous attaquera pas, ne se défendra pas.",
                100);
        Monstre Cotylorhiza = new Monstre(
                "Cotylorhiza",
                100,
                10,
                "Sorte de méduse ressemblant à un oeuf au plat volant",
                "Lance harpon",
                Comportement.DEFENSIF,
                "Avec son air gluant et ses tentacules menaçantes, il ne faut probablement pas s’en approcher. Une arme à distance comme un lance-harpon serait plus efficace.",
                100);
        Monstre Cornuta = new Monstre(
                "Cornuta",
                150,
                "Description à définir.",
                "Torche",
                Comportement.AGRESSIF,
                "Baudroie géante mutée, bien qu’elle émette de la lumière elle même, elle la craint comme la peste."
                100
        );
    }

    public Monstre genereMonstre()
    {

    }

}
