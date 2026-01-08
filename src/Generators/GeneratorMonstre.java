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

        // génération des montres communs et leur ajout dans la liste du générateur.
        Monstre Laticauda = new Monstre(
                "Lauticauda Colubrina",
                50,
                50,
                "Vous tombez sur ce monstre",
                "Une sorte de serpent ressemblant étrangement à un pyjama rayé. Il arpente la pièce avec une froideur et une assurance montrant qu'il n'est pas inquiet.",
                "",
                Comportement.DEFENSIF,
                "Autrement appelé le cobra de mer, ce serpent est venimeux, l'attaquer représente un risque néanmoins ce n'est pas un grand belligérant.",
                3,
                "Le monstre vous mord de toutes ses forces.");
        Monstre Ambystoma = new Monstre(
                "Ambystoma",
                1,
                0,
                "Vous tombez sur ce monstre",
                "Un petit animal a l’air inoffensif et tout mignon … Vous n’allez quand même pas faire ce à quoi je pense ?",
                "taser",
                Comportement.INOFFENSIF,
                "Espèce rare d’axolotl, animaux de compagnie de l’IA. Il ne vous attaquera pas, ne se défendra pas.",
                3,
                "Il vous regarde d'un air attendrissant");
        Monstre Cotylorhiza = new Monstre(
                "Cotylorhiza",
                100,
                10,
                "Vous tombez sur ce monstre",
                "Sorte de méduse ressemblant à un oeuf au plat volant",
                "Lance harpon",
                Comportement.AGRESSIF,
                "Avec son air gluant et ses tentacules menaçantes, il ne faut probablement pas s’en approcher. Une arme à distance comme un lance-harpon serait plus efficace. Ne vous fiez pas à son apparence, elle n'aime pas la compagnie.",
                3,
         "Le monstre vous donne un coup de tentacule.");

        listMonstre.add(Laticauda);
        listMonstre.add(Ambystoma);
        listMonstre.add(Cotylorhiza);

        switch(difficulte)
        {
            case 1:
                Monstre Cornuta = new Monstre(
                        "Cornuta",
                        150,
                        10,
                        "Vous tombez sur ce monstre",
                        "Description à définir.",
                        "Torche",
                        Comportement.AGRESSIF,
                        "Baudroie géante mutée, bien qu’elle émette de la lumière elle même, elle la craint comme la peste.",
                        5,
                        "Le monstre vous donne un coup de machoire puissant.");
                listMonstre.add(Cornuta);
                ;break;
            case 2:
                Monstre Kiwa = new Monstre(
                        "Kiwa hirsuta",
                        80,
                        25,
                        "Vous tombez sur ce monstre",
                        "C'est une espèce rare de crabe de la taille d’un chien, cependant, il ne réagit pas à vos mouvements.",
                        "",
                        Comportement.DEFENSIF,
                        "Crabe particulier qui se distingue par une fourrure présente sur ses pinces et ses pâtes. Il est aveugle mais attention s’il vous repère ! Il est aussi appelé crabe yéti pour ses poils mais également pour sa force…",
                        5,
                        "Le monstre vous pince très fort. Vous réussissez malgré tout à vous extirper.");
                listMonstre.add(Kiwa);
                ;break;
            case 3:
                Monstre Alviniconcha = new Monstre(
                        "Alviniconcha",
                        50,
                        60,
                        "Vous tombez sur ce monstre",
                        "Vous croisez, à l’autre bout de la pièce, un escargot imposant qui se dirige lentement mais sûrement vers vous avec une intention malveillante pour autant que vous puissiez en juger.",
                        "Taser",
                        Comportement.AGRESSIF,
                        "Gastéropode qui, malgré sa taille imposante, n’est pas très intimidant. Des organismes unicellulaires recouvrent sa carapace et se nourrissent en dissolvant de façon spectaculaire toute matière étrangère à son hôte. Hargneux de nature, il cherchera à vous nuire mais est sensible aux charges électriques.",
                        5,
                        "Le monstre vous cogne avec sa coquille.");
                listMonstre.add(Alviniconcha);
                ;break;
        }

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
        return(null);
    }

}
