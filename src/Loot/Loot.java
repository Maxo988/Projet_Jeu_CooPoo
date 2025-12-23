package Loot;
import Objets.Arme;

import java.util.ArrayList;

import java.util.Random;

public class Loot {
    private ArrayList<Item> items = new ArrayList<Item>();
    private static final Random random = new Random();
    private int poidsTotal;

    public void initArme() {
        Arme poings = new Arme(0, "Poings", "Vos poings. Ils manquent d'entrainement mais ne vous ont jamais déçu", 0, 3, 4);
        Arme barredeFer = new Arme(1, "Barre de Fer", "Une barre de fer rouillée mais qui a malgré tout l'air solide",1, 5, 8);
        Arme harpon = new Arme(2, "Harpon", "Un harpon qui servait ... surement à quelque chose. La flèche revient automatiquement à l'aide d'un système de poulie.",1, 8, 10);
        Arme machette = new Arme(3, "Machette", "Une machette à l'air robuste et bien aiguisé",1, 4, 10 );
    }

    public void initItem() {
        Item lampeTorche = new Item(4, "Lampe Torche", "Une lampe permettant d'éclairer les recoins les plus sombres de la base", 1);
        Item kitdeCrochetage = new Item(5, "Kit de Crochetage", "Les portes de la base sont férmées par des clés magnétiques, à quoi bon ce kit pourrait servir ?", 1);
        Item peluche = new Item(6, "Peluche", "Réconfortante, mais pas utile pour autant",1);
    }
}
