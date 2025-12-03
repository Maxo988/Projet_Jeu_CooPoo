package Monstres;
import Objets.Item;

public class Boss extends Monstre {
    public Boss (String nom, int pvMax, int degats, String description, Item item, boolean agr, String infos)
    {
        super(nom, pvMax, degats, description);
    }

    public void pouvoirSpecial()
    {

    }
}
