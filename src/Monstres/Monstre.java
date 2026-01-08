package Monstres;
import Objets.Equipement;
import Joueur.Joueur;


public class Monstre
{
    protected String nom;
    protected int pv;
    protected int pvMax;
    protected int degats;
    protected String introduction;
    protected String description;
    protected String infoSpes;
    protected String pointFaible;
    protected Comportement comportement;
    protected String attaque;

    protected int poids;

    public Monstre(String nom, int pv, int degats, String intro, String description, String item, Comportement comp, String infos, int poids, String attaque)
    {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.degats = degats;
        this.description = description;
        this.pointFaible = item;
        this.comportement = comp;
        this.infoSpes = infos;
        this.poids = poids;
        this.introduction = intro;
        this.attaque = attaque;
    }

    public String getPointFaible()
    {
        return(pointFaible);
    }

    public String getDescription()
    {
        return description;
    }

    public String getIntroduction()
    {
        return introduction;
    }

    public String getInfoSpes()
    {
        return infoSpes;
    }

    public String getNom()
    {
        return nom;
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

    public String getComportement()
    {
        return(comportement.name());
    }

    public String getAttaque()
    {
        return(attaque);
    }

    public void attaquer(Joueur joueur)
    {
        if(comportement == Comportement.AGRESSIF)
            joueur.perdrePv(degats);
        else if(comportement == Comportement.DEFENSIF)
        {
            if(pv == pvMax)
            {
                System.out.println("Le monstre est sur ses gardes mais ne semble pas vouloir vous attaquer.");
            }
            else
            {
                System.out.println("Le monstre est devenu violent et vous attaque.");
                joueur.perdrePv(degats);
            }
        }
        else
        {
            System.out.println("Le monstre n'est pas une menace pour vous. Etes-vous sûr de vouloir continuer le combat ?");
        }
    }

    public void visuClassique()
    {
        /* à définir */
    }
}
