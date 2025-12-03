import Joueur.Joueur;
import Environement.Vaisseau;
import Monstres.Monstre;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private Vaisseau vaisseau;
    private Joueur joueur;
    public Scanner entree;
    private boolean fin = false;

    public static void main(String[] args){
        Main jeu = new Main();
        jeu.lancerJeu();
    }

    public Main(){
        entree = new Scanner(System.in);
        // init du vaisseau complete : vaisseau, etages, salles, monstres et trésors dans chaque etc
    }

    public Vaisseau getVaisseau() {
        return vaisseau;
    }
    public Joueur getJoueur() {
        return joueur;
    }

    public void lancerJeu() {
        // lance le jeu au démarrage
        CinematiqueDebut();
        while (!fin){
            joueur.getSalleActuelle().CinematiqueEntree();
            // affiche description générale, si monstre add description, sinon affiche details pièce
            menuPrincipal();
        }
    }
    private void menuPrincipal(){
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Se déplacer vers une autre salle");
        System.out.println("2 - Ouvrir l'inventaire");
        if (joueur.getSalleActuelle().monstre != null) {
            System.out.println("3 - Se battre contre le monstre");
            System.out.println("5 - Fuir le monstre");
        }
        if (joueur.getSalleActuelle() instanceof Cuisine ){
            System.out.println("4 - Cuisiner quelque chose");
        }

        String rep = entree.nextLine(); 
        
        switch (rep) {
            case "1" :
                joueur.seDeplacer(); break;
            case "2" :
                // ouvre l'inventaire, fait le lien avec la decision de quitter
                boolean quitter = joueur.ouvrirInventaire();
                if (quitter) {
                    quitterJeu();
                } break;

            default:
                if (joueur.getSalleActuelle().monstre != null) {
                    switch (rep){
                        case "3":
                            combat(joueur, joueur.getSalleActuelle().monstre);
                            break;
                        case "5":
                            System.out.println("Vous fuyez comme un lâche et retournez dans la salle précédente");
                            break;
                    }
                } else if (joueur.getSalleActuelle() instanceof Cuisine){
                    joueur.getSalleActuelle().Cuisiner();
                } else {
                    System.out.println("Veuillez faire un choix valide.");
                } break;
        }
    }

    private void combat(Joueur joueur, Monstre monstre) {
        // boucle de l'instance de combat entre le joueur et le monstre
        boolean fini = false;
        System.out.println("------- Que le combat commence ! -------");
        while(!fini) {
            // à chaque tour du combat, si salle immergée l'oxygène baisse. à 0 c game over
            if (joueur.getSalleActuelle().isImmergee()){
                joueur.perdreOxygene(10);
            }

            if (joueur.getPv() == 0 ) {
                System.out.println("Vous avez succombé à vos blessures, c'est fini pour vous.");
                CinematiqueGameOver();
                fini = true;
            } else if (joueur.getOxygene() == 0) {
                System.out.println("Faute d'oxygène, vous sombrez dans l'inconscience... définitivement. " +
                        "C'est fini pour vous.");
                CinematiqueGameOver();
                fini = true;
            } else if (monstre.getPv() == 0) {
                System.out.println("Bravo ! Vous avez vaincu le monstre.");
            }
            // actions du combat : utiliser un objet        attaquer (couteau suisse)   fuir()
            //
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1 - Utiliser un objet");
            System.out.println("2 - Consulter le bestiaire ");
            System.out.println("3 - Frapper à mains nues ");
            // System.out.println("3 - Fuir le combat ");
            String rep = entree.nextLine();

            switch (rep) {
                case "1":
                    joueur.seDeplacer();
                    break;
            }
        }
    }
    private void quitterJeu() {
        this.fin = true;
    }
    private void CinematiqueDebut() {
        // Clarisse
        System.out.println("cinem d'intro");
    }
    private void CinematiqueGameOver() {
        // Clarisse
        System.out.println("cinem de fin, mort");
        quitterJeu();
    }
    private void CinematiqueFin() {
        // Clarisse
        System.out.println("cinem de fin you win");
        quitterJeu();
    }
}
