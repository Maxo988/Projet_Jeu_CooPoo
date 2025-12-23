package Objets;

import java.util.ArrayList;

public class Lore extends Objets{
    public Lore (String nom, String description, int poids){
        super (nom, description, poids);
    }

    public void visualiser() {
        System.out.println(nom);
        System.out.println("                      ");
        System.out.println("---------------");
        System.out.println("Description: " + this.description);
    }

    public static ArrayList<Lore> initLore(){
        ArrayList<Lore> listeLore = new ArrayList<Lore>();
        listeLore.add(new Lore("nom1", "d1", 3));
        listeLore.add(new Lore("nom2", "d2", 3));
        listeLore.add(new Lore("nom3", "d3", 3));
        listeLore.add(new Lore("nom4", "d4", 3));
        listeLore.add(new Lore("nom5", "d5", 3));

        return (listeLore);
    }

}

