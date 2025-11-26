package Environement;

import Monstres.Monstre;

import java.util.ArrayList;

public class Salle {
    protected String description;
    protected boolean immergee;
    protected boolean iaActive;
    /*
    protected boolean presenceMonstre;
    protected Monstre monstre;
    A voir si je le mets que dans les classes filles pouvant accueilr des monstres
     */
    protected boolean coffre;
    protected boolean tresor;
    protected boolean visitee;

    public Salle (String description, boolean immergee, boolean iaActive, /*boolean presenceMonstre, Monstre monstre,*/ boolean coffre, boolean tresor) {
        this.description = description;
        this.immergee = immergee;
        this.iaActive = iaActive;
        /*
        this.presenceMonstre = presenceMonstre;
        this.monstre = monstre;
         */
        this.coffre = coffre;
        this.tresor = tresor;
        this.visitee = false;
    }
}
