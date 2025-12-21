import Joueur.Joueur;
import Environement.*;
import Monstres.*;
import Objets.*;

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
        joueur = new Joueur();
        // init du vaisseau complete : vaisseau, etages, salles, monstres et trésors dans chaque etc
        vaisseau = new Vaisseau();
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
            // affiche description générale,
            // si monstre add description,
            // sinon affiche details pièce -> recup objets, propose changer d'étage ou indique que c ici si on a pas la carte etc
            joueur.getSalleActuelle().cinematiqueEntree();
            menuPrincipal();
        }
    }

    private void menuPrincipal(){
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Se déplacer vers une autre salle");
        System.out.println("2 - Ouvrir l'inventaire");
        if (joueur.getSalleActuelle().getMonstre() != null) {
            System.out.println("3 - Se battre contre le monstre");
            System.out.println("5 - Fuir le monstre");
        }
        if (joueur.getSalleActuelle() instanceof Cuisine ){
            System.out.println("4 - Cuisiner quelque chose");
        }
        boolean nok = true;
        while (nok) {
            String rep = entree.nextLine();

            switch (rep) {
                case "1":
                    vaisseau..seDeplacer(); // lien SalleActuelle - posX et posY dans Etage ? comment savoir sur quel etage on est ?
                    // se déplacer dans l'étage -> change posX et posY etage PUIS mettre à jour la salleActuelle dans joueur
                    // -> need return l'objet Salle via seDeplacer()
                    nok = false; break;
                case "2":
                    // ouvre l'inventaire, fait le lien avec la decision de quitter
                    boolean quitter = joueur.ouvrirInventaire();
                    if (quitter) {
                        quitterJeu();
                    }
                    nok = false; break;

                default:
                    if (joueur.getSalleActuelle().getMonstre() != null) { // SI ça peut se faire ainsi
                        switch (rep) {
                            case "3":
                                combat(joueur, joueur.getSalleActuelle().getMonstre());
                                nok = false; break;
                            case "5":
                                System.out.println("Vous fuyez comme un lâche et retournez dans la salle précédente");
                                // se déplacer -> voir comment faire dc
                                nok = false; break;
                        }
                    } else if (joueur.getSalleActuelle() instanceof Cuisine) {
                        if (rep.equals("4")) {
                            joueur.getSalleActuelle().Cuisiner();
                            nok = false;
                        }
                    } else {
                        System.out.println("Veuillez faire un choix valide.");
                    }
                    break;
            }
        }
    }

    private void combat(Joueur joueur, Monstre monstre) {
        // boucle de l'instance de combat entre le joueur et le monstre
        boolean fini = false;
        System.out.println("------- Que le combat commence ! -------");
        while(!fini) {

            // ------------ Verifications de base ------------

            // à chaque tour du combat, si salle immergée l'oxygène baisse. à 0 c game over
            if (monstre.getPv() <= 0) {
                System.out.println("Bravo ! Vous avez vaincu le monstre.");
                joueur.getSalleActuelle().setMonstre(null); // vider la pièce
                fini = true;
            } else if (joueur.getPv() <= 0 ) {
                System.out.println("Vous avez succombé à vos blessures, c'est fini pour vous.");
                CinematiqueGameOver();
                fini = true;
            } else if (joueur.getOxygeneActuel() <= 0) {
                System.out.println("Faute d'oxygène, vous sombrez dans l'inconscience... définitivement. " +
                        "C'est fini pour vous.");
                CinematiqueGameOver();
                fini = true;
            } else if (joueur.getSalleActuelle().isImmergee()){
                joueur.perdreOxygene(10);
            }



            // ------------ Tour du joueur ------------

            // actions du combat : utiliser un objet        attaquer (couteau suisse)   fuir()

            System.out.println("Que voulez-vous faire ?");
            System.out.println("1 - Utiliser un objet");
            System.out.println("2 - Consulter le bestiaire ");
            System.out.println("3 - Frapper à mains nues ");
            System.out.println("4 - Fuir le combat ");
            String rep = entree.nextLine();

            switch (rep) {
                case "1":
                    Equipement choix = joueur.utiliserObjet(); // recup choix d'utilisation 

                    if (choix instanceof Bandage){
                        choix.utiliser(joueur); // print + soigne si bandage

                    } else if (choix instanceof Torche){
                        ((Torche) choix).utiliserC(monstre); // utiliser pas fini dans Torche pour prendre en compte tt

                        /*if ("Torche".equalsIgnoreCase(monstre.getPointFaible())){
                            // fin du combat, c gagné. Le monstre craint la lumière
                            System.out.println("Bravo ! Vous avez vaincu le monstre.");
                            fini = true;
                        } else {
                            System.out.println("Vous voyez beaucoup mieux le monstre maintenant. Cela ne semble pas faire plus d'effet.");
                        }*/

                    } else if (choix instanceof Arme){
                        ((Arme) choix).utiliser(monstre);

                        /* if (choix.getNom().equalsIgnoreCase(monstre.getPointFaible())) {
                            System.out.println("Votre arme est super efficace contre lui ! Vous le blessez gravement.");
                            monstre.perdrePv(3*((Arme) choix).getDegats()); // verif
                        }
                        else {
                            System.out.println("Un petit coup pour vous, un grand pas pour votre survie. Heureusement que vous ne loupez jamais votre cible.");
                            monstre.perdrePv(((Arme) choix).getDegats());
                        }*/
                    }
                    break;

                case "2": // regarder le bestiaire prend un tour
                    joueur.ouvrirBestaire();
                    break;

                case "3":// coup de poing fait 1 de dégat
                    monstre.perdrePv(1);
                    break;

                case "4": // option de fuite si passif
                    if (monstre.getComportement().equalsIgnoreCase("INOFFENSIF")){
                        System.out.println("Le monstre semble vous laisser fuir tandis que vous prenez congé comme un lâche.");
                        // se déplacer -> voir comment faire dc
                        fini = true;
                    } else {
                        System.out.println("Le monstre semble déterminé à vous barrer la route. Impossible de fuir desormais...");
                    }
                    break;
            }

            // ------------ Tour du monstre ------------
            monstre.attaquer(joueur);
            
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
