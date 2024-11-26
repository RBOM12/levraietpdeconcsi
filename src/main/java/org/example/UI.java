package org.example;

import java.util.Scanner;

public class UI {
    Compte c;

    public UI() throws Exception {
        System.out.println("Bienvenue sur notre site de vente en ligne");
        System.out.println("------------------------------------------");
        System.out.println("1. Se connecter");
        System.out.println("2. S'inscrire");
        System.out.println("3. Voir catalogue");
        System.out.println("4. Quitter");
        System.out.println("------------------------------------------");

        int choix = 0;
            choix = saisirChoix();
            switch (choix) {
                case 1:
                    String pseudo = saisirString("Veuillez saisir votre pseudo : ");
                    String mdp = saisirString("Veuillez saisir votre mot de passe : ");
                    this.c= new Utilisateur().connexion(pseudo, mdp);
                    break;
                case 2:
                    String nom = saisirString("Veuillez saisir votre nom : ");
                    String prenom = saisirString("Veuillez saisir votre prénom : ");
                    String adresse = saisirString("Veuillez saisir votre adresse : ");
                    pseudo = saisirString("Veuillez saisir votre pseudo : ");

                    mdp = saisirString("Veuillez saisir votre mot de passe : ");
                    this.c=new Utilisateur().inscription( nom, prenom, adresse, pseudo, mdp, estMarchand());
                    if (this.c instanceof Marchand){
                        //uiMarchand((Marchand) this.c);
                    } else {
                        uiClient((Client) this.c);
                    }
                    break;
                case 3:
                    System.out.println("Afficher Marchands");

                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
    }
    public void uiClient(Client c) throws Exception {

        System.out.println("Bienvenue " + c.getPseudo());
        System.out.println("------------------------------------------");
        System.out.println("1. Ajouter un produit au panier");
        System.out.println("2. Passer commande");
        System.out.println("3. Payer");
        System.out.println("4. Voir mes commandes");
        System.out.println("5. Se déconnecter");
        System.out.println("------------------------------------------");

        int choix = 0;
        while (choix != 5) {
            choix = saisirChoix();
            switch (choix) {
                case 1:
                    System.out.println("Ajouter un produit au panier");
                    String nom = saisirString("Veuillez saisir le nom du produit : ");
                    int quantite = saisirInt("Veuillez saisir la quantite du produit : ");
                    //c.ajouterProduitPanier(nom, quantite);

                    break;
                case 2:
                    System.out.println("Passer commande");
                    c.passercommande();
                    break;
                case 3:
                    System.out.println("Payer");
                    //c.payer();

                    break;
                case 4:
                    System.out.println("Voir mes commandes");
                    c.getCommandes();
                    break;
                case 5:
                    System.out.println("Se déconnecter");
                    c.deconnexion();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }

    public void uiMarchand(Marchand m) throws Exception {
        System.out.println("Bienvenue " + m.getPseudo());
        System.out.println("------------------------------------------");
        System.out.println("1. Créer un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Voir mes commandes");
        System.out.println("5. Se déconnecter");
        System.out.println("------------------------------------------");

        int choix = 0;
        while (choix != 5) {
            choix = saisirChoix();
            switch (choix) {
                case 1:
                    String nom = saisirString("Veuillez saisir le nom du produit : ");
                    Float prix = saisirFloat("Veuillez saisir le prix du produit : ");
                    int quantite = saisirInt("Veuillez saisir la quantite du produit : ");
                    m.ajouterProduit(nom, prix, quantite);
                    System.out.println("Produit " + nom + " ajouté");
                    break;
                case 2:
                    System.out.println("Modifier un produit");
                    this.modifierProduit(m);
                    break;
                case 3:
                    nom = saisirString("Veuillez saisir le nom du produit : ");
                    m.supprimerProduit(m.choisirProduit(nom));
                    System.out.println("Produit " + nom + " supprimé");
                    break;
                case 4:
                    System.out.println("Voir mes commandes");
                    break;
                case 5:
                    System.out.println("Se déconnecter");
                    c.deconnexion();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }

    public int saisirChoix() {
        System.out.println("Veuillez saisir votre choix : ");
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        try {
            choix = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Veuillez saisir un nombre");
        }
        return choix;
    }

    public String saisirString(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private Float saisirFloat(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextFloat();
    }

    private int saisirInt(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


    public boolean estMarchand(){
        while (true){
            System.out.println("Etes-vous un marchand ? (O/N)");
            Scanner sc = new Scanner(System.in);
            String reponse = sc.nextLine();
            if (reponse.equals("O")){
                return true;
            } else if (reponse.equals("N")){
                return false;
            } else {
                System.out.println("Réponse invalide");
            }
        }
    }

    public void modifierProduit(Marchand m) throws Exception {
        String nom = saisirString("Veuillez saisir le nom du produit : ");
        System.out.println("Voulez vous modifier le nom ou le prix du produit ? (N/P)");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();
        if (reponse.equals("N")) {
            String nouveauNom = saisirString("Veuillez saisir le nouveau nom du produit : ");
            m.modifierNomProduit(m.choisirProduit(nom), nouveauNom);
        } else if (reponse.equals("P")) {
            Float nouveauPrix = saisirFloat("Veuillez saisir le nouveau prix du produit : ");
            m.modifierPrixProduit(m.choisirProduit(nom), nouveauPrix);
        } else {
            System.out.println("Réponse invalide");
        }
    }
}
