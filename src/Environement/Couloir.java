package Environement;

import Monstres.Monstre;

public class Couloir extends Salle{
    protected boolean presenceMonstre;
    protected Monstre monstre;

    public Couloir (String description, boolean immergee, boolean iaActive, boolean presenceMonstre, Monstre monstre, boolean coffre, boolean tresor) {
        super(description, immergee, iaActive, coffre, tresor);
        this.presenceMonstre = presenceMonstre;
        this.monstre = monstre;
    }

}
