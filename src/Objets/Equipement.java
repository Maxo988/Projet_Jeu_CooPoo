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
        listeEquipement.add(new Bandage("Bandage", "Ce bandage vous permettra de soigner " +
                "vos blessures et gagner 30 pv", 3, 30));
        listeEquipement.add(new Arme("Couteau-suisse", "Un outil polyvalent qui sert à " +
                " fois d'arme de mêlée de base pour des dégâts légers en dernier recours et d'outil " +
                "utilitaire pour la réparation ou le piratage de l'environnement. ", 3, 2));
        listeEquipement.add(new Arme("Lance-harpon", "Un dispositif pneumatique lourd qui" +
                " tire des harpons câblés, infligeant des dégâts massifs et permettant de tirer la cible " +
                "ou de se propulser.", 3, 1));
        listeEquipement.add(new Arme("Taser", "Un pistolet électrique compact projetant " +
                "des sondes qui infligent des dégâts modérés et, surtout, étourdissent la cible pour un " +
                "contrôle de foule immédiat.", 3, 4));

        return (listeEquipement);
    }

}
