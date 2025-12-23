package Joueur;
import Monstres.Monstre;
import Objets.*;
import Environement.*;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Joueur {
    private int pv;
    private int oxygeneActuel;
    private int oxygeneTotal;
    private ArrayList <Equipement> equipement;
    private ArrayList <InfosMonstre> bestiaire;
    private ArrayList <Lore> histoire;
    private int nbCles;
    private boolean carteMagnetique;
    private Salle salleActuelle;
    public  Scanner entree;

    public Joueur(){
        pv = 100;
        oxygeneActuel = 100;
        oxygeneTotal = 100;

        ArrayList<Equipement> equipement = new ArrayList<Equipement>();
        // remplir cette liste avec tous les objets générés et le booleen obtenu = False

        ArrayList<InfosMonstre> bestiaire = new ArrayList<InfosMonstre>();
        // vide, se remplit lors de rencontre ou si on obtient une InfoMonstre

        ArrayList<Lore> histoire = new ArrayList<Lore>();
        // vide, se remplit si on obtient un trésor sur l'histoire du jeu

        entree = new Scanner(System.in);  // objet pour les inputs
    }

    public int getPv() {
        return this.pv;
    }
    public int getOxygeneActuel() {
        return oxygeneActuel;
    }
    public int getOxygeneTotal() {
        return oxygeneTotal;
    }
    public int getNbCles() {
        return nbCles;
    }
    public boolean getCarteMagnetique() {
        return carteMagnetique;
    }
    public Salle getSalleActuelle() {
        return salleActuelle;
    }

    public void perdrePv(int perte) {
        pv -= perte;
    }
    public void gagnerPv(int gain) {
        pv += gain;
    }

    public void perdreOxygene(int perte) {
        oxygeneActuel -= perte;
    }
    public void gagnerOxygene(int gain) {
        oxygeneTotal += gain;
    }
    public void resetOxygene() {
        oxygeneActuel = getOxygeneTotal();
    }

    public boolean utiliserCle(){
        if (nbCles > 0){
            nbCles --;
            return true;
        }  else {
            System.out.println("Vous n'avez pas de clé pour ouvrir le caisson. Il va falloir en trouver.");
            return false;
        }
    }

    public ArrayList<Equipement> getEquipement() {
        return equipement;
    }
    public ArrayList<InfosMonstre> getBestiaire() {
        return bestiaire;
    }
    public ArrayList<Lore> getHistoire() {
        return histoire;
    }

    // A TESTER
    public Equipement utiliserObjet(){
        // permet de choisir un objet dans l'équipement et de le return pour se battre
        int cpt = 0;
        System.out.println("-------- Vos objets --------");
        System.out.println("0 - Ne pas utiliser d'objet ");
        for (Equipement e : equipement){
            if (e.isObtenu()){
                cpt ++;
                System.out.println(cpt +" "+ e.getNom());
            }
        }
        while (true){
            // rep doit etre un entier, soit 0 pour sortir soit un chiffre entre 1 et la longueur de la liste -> rep - 1 donne l'indice du bon objet
            String rep = entree.nextLine();
            try{
                int r = Integer.parseInt(rep);
                if (r == 0) {
                    return null;
                } else if (r > 0 && r <= cpt) {
                    return equipement.get(cpt-1);
                } else {
                    System.out.println("Veuillez faire un choix valide.");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Veuillez entrer un nombre.");
            }
        }
    }

    // TODO : voir comment ça marche via la partie de Mael
    public void seDeplacer(){
        // TODO : Changement de salle :
        //  donner lettre de la sortie voulue : z pour une sortie en face, d pour droite, s pour derrière (toujours là, retourner sur nos pas), q pour gauche
        //  invite de déplacement s’adapte à la salle

    }
    // A TESTER
    public boolean ouvrirInventaire(){
        // inventaire général du joueur :
        //affiches les infos de base du joueur (pv, oxygène)
        //affiche le choix :
        //quitterJeu()	quitterInventaire()	ouvrirBestaire()	ouvrirHistoire()	ouvrirEquipement()
        boolean inventaire = true;
        boolean quitter = false;

        System.out.println("-------- Inventaire --------");
        System.out.println("pv : "+getPv()+"     oxygène : "+ getOxygeneActuel()+"/"+getOxygeneTotal());
        System.out.println("Que-voulez vous faire ?");
        System.out.println("1 - Voir mes equipements");
        System.out.println("2 - Voir le Bestiaire");
        System.out.println("3 - Consulter les notes trouvées");
        System.out.println("4 - Quitter l'inventaire");
        System.out.println("q - Quitter la partie (attention vous perdrez votre progression)");
        while(inventaire){
            String rep = entree.nextLine();
            switch (rep) {
                case "1":
                    ouvrirEquipement();
                    break;
                case "2":
                    ouvrirBestaire();
                    break;
                case "3":
                    ouvrirHistoire();
                    break;
                case "4":
                    inventaire = false;
                    break;
                case "q":
                    quitter = true;
                    inventaire = false;
                    break;
                default:
                    System.out.println("Veuillez faire un choix valide.");
                    break;
            }
        }
        return quitter;

    }
    // A TESTER
    public void ouvrirBestaire(){
        // affiche le contenu du bestiaire
        if (bestiaire.isEmpty()) {
            System.out.println("Aucun monstre repertorié.");
        }
        else{
            for (InfosMonstre m : bestiaire){
                m.Visualiser();
            }
        }
    }
    // A TESTER
    private void ouvrirHistoire(){
        // affiche toutes les notes récupérées sur le Lore
        if (histoire.isEmpty()) { // histoire.size() == 0
            System.out.println("Aucune note n'a été trouvée pour l'heure.");
        }
        else{
            for (Lore h : histoire){
                h.Visualiser();
            }
        }
    }
    // A TESTER
    private void ouvrirEquipement(){
        // affiche toutes les notes récupérées sur le Lore
        // on a forcément 1 objet donc pas de vérif si la liste est vide

        // affiche les objets, les clés et si on a la carte magnétique de l'étage
        System.out.println("Nombre de clés possédées : "+ getNbCles());
        if (getCarteMagnetique()){
            System.out.println("Carte magnétique trouvée ");
        } else {
            System.out.println("Carte magnétique non trouvée ");
        }

        for (Equipement e : equipement){
            if (e.isObtenu()) {
                e.Visualiser();
            }
        }
    }

}
