package Objets;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {


    private static final List<Item> LISTE_OBJETS = new ArrayList<>();

    static {
        //Objets de types Arme
        Arme couteauSuisse = new Arme("Couteau suisse", "Description CS", 50);
        Arme lanceHarpon = new Arme("Lance-harpon", "Description LH", 70);
        Arme taser = new Arme("Taser", "Description T", 70);

        // Objets de type UsageUnique (hérite de Item)
        UsageUnique carteMagnetique = new UsageUnique("Carte magnétique", "Permet de passer au niveau supérieur");
        UsageUnique cleCaisson = new UsageUnique("Clé à caisson", "Ouvre n'importe quelle porte d'un étage donné");

        // Objets de type Item (classe de base, ou peut-être des consommables simples)
        Item lampeTorche = new Item("Lampe torche", "Description LP");
        Item bandage = new Item("Bandage", "Rend 30 pv");
        Item bouteilleOxygene = new Item("Bouteille d'oxygène", "Augmente la réserve d'oxygène de 20");

        // --- 2. Ajoutez les objets à la liste ---
        LISTE_OBJETS.add(couteauSuisse);
        LISTE_OBJETS.add(lanceHarpon);
        LISTE_OBJETS.add(taser);
        LISTE_OBJETS.add(carteMagnetique);
        LISTE_OBJETS.add(cleCaisson);
        LISTE_OBJETS.add(lampeTorche);
        LISTE_OBJETS.add(bandage);
        LISTE_OBJETS.add(bouteilleOxygene);
    }

    public static List<Item> getObjets() {
        return LISTE_OBJETS;
    }
}