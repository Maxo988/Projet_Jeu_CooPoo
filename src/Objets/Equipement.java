package Objets;
import java.util.ArrayList;

public class Equipement extends Objets {
    public Equipement (String nom, String description, int Poids){
        super(nom, description, Poids);
    }

    public ArrayList<Equipement> initEquipement(){
        ArrayList<Equipement> listeEquipement = new ArrayList<Equipement>();
        listeEquipement.add(new Torche("Lampe torche", "Grâce à cette lampe torche, vous pourrez" +
                "explorer le sous-marin et elle pourra vous donnez des avantages sur certains monstres", 3));
        listeEquipement.add(new Equipement("nom2", "d2", 3));
        listeEquipement.add(new Equipement("nom3", "d3", 3));
        listeEquipement.add(new Equipement("nom4", "d4", 3));
        listeEquipement.add(new Equipement("nom5", "d5", 3));

        return (listeEquipement);
    }

}
