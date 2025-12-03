package Environement;

import java.util.ArrayList;

public class Vaisseau {
    public ArrayList<Etage> etages;

    public Vaisseau() {
        this.etages = new ArrayList<>();
        etages.add(new Etage(1));
        etages.add(new Etage(2));
        etages.add(new Etage(3));
    }
}
