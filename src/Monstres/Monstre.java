package Monstres;
import Objets.Item;
import Joueur.Joueur;

public class Monstre
{
    protected String nom;
    protected int pv;
    protected int pvMax;
    protected int degats;
    protected String description;
    protected String pointFaible;
    protected Comportement comportement;
    protected String infoSpes;
    protected int poids;

    public Monstre(String nom, int pvMax, int degats, String description, String item, Comportement comp, String infos, int poids)
    {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pvMax;
        this.degats = degats;
        this.description = description;
        this.pointFaible = item;
        this.comportement = comp;
        this.infoSpes = infos;
        this.poids = poids;
    }

    public String getPointFaible()
    {
        return(pointFaible);
    }

    public String getNom()
    {
        return nom;
    }

    public int pvMax()
    {
        return pvMax;
    }

    public int getDegats()
    {
        return degats;
    }

    public int getPoids()
    {
        return poids;
    }

    public int getPv()
    {
        return pv;
    }

    public void perdrePv(int degats)
    {
        pv = -degats;
    }

    public void attaquer(Joueur joueur)
    {
        joueur.perdrePv(degats);
    }

    public void visuClassique()
    {
        /* à définir */
    }
}
