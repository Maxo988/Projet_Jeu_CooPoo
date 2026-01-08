//Monstre.java
package Monstres;
import Objets.Equipement;
import Joueur.Joueur;

/// 0author Gp2
public class Monstre
{
    ///Nom du monstre
    protected final String nom;
    ///Nombre de pv actuel du monstre
    protected int pv;
    ///Nombre de pv de base du monstre, constant
    protected final int pvMax;
    ///Nombre de dégâts infligé par le monstre
    protected int degats;
    ///Introduction textuelle du monstre dans le jeu
    protected final String introduction;
    ///Description du monstre
    protected final String description;
    ///Informations détaillées du monstre
    protected final String infoSpes;
    ///Point faible de ce monstre
    protected final String pointFaible;
    ///Comportement du monstre
    protected final Comportement comportement;
    ///Description de l'attaque
    protected final String attaque;
    ///Poids du monstre
    protected final int poids;

    ///Constructeur customisé pour instancier un monstre, les attributs prendront les valeurs remplies lors de l'instanciation
    /// @param nom Le nom de la créature
    /// @param pv Les points de vie de départ
    /// @param degats Les dégâts d'attaque
    /// @param intro L'introduction du monstre dans le jeu
    /// @param description La description du monstre
    /// @param item Les points faibles du monstre
    /// @param comp Le comportement du monstre
    /// @param infos Les informations complètes sur le monstre
    /// @param poids Le poids du monstre
    /// @param attaque L'attaque executé par ce monstre
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

    ///@return les points faibles du monstre.
    public String getPointFaible()
    {
        return(pointFaible);
    }

    ///@return la description du monstre.
    public String getDescription()
    {
        return description;
    }

    ///@return l'introduction du monstre
    public String getIntroduction()
    {
        return introduction;
    }

    ///@return les informations complète sur le monstre.
    public String getInfoSpes()
    {
        return infoSpes;
    }

    ///@return le nom du monstre.
    public String getNom()
    {
        return nom;
    }

    ///@return le nombre de degats effectué par le monstre.
    public int getDegats()
    {
        return degats;
    }

    ///@return le poids du monstre.
    public int getPoids()
    {
        return poids;
    }

    ///@return  les points de vie actuels du monstre.
    public int getPv()
    {
        return pv;
    }

    ///Enlève des points de vie au monstre lors d'une attaque pendant un combat
    /// @param degats Le nombre de points de vie à retirer.
    public void perdrePv(int degats)
    {
        pv = -degats;
    }

    ///@return le comportement du monstre.
    public String getComportement()
    {
        return(comportement.name());
    }

    ///@return l'attaque que peut effectuer le monstre.
    public String getAttaque()
    {
        return(attaque);
    }

    ///Permet d'attaquer le joueur durant un combat
    /// @param joueur Le joueur qui subit l'attaque.
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
