package org.example;

import java.util.HashMap;

public class GestionCompte {
    HashMap<String, Compte> comptes;

    public GestionCompte() {
        comptes = new HashMap<String, Compte>();
    }

    public void ajouterCompte(Compte compte) {
        comptes.put(compte.getPseudo(), compte);
    }

    public void supprimerCompte(Compte compte) {
        comptes.remove(compte.getPseudo());
    }

    public Compte getCompte(String pseudo, String mdp) {

        if (!comptes.containsKey(pseudo)) {
            return null;
        }
        Compte compte = comptes.get(pseudo);
        if (compte.getMdp().equals(mdp)) {
            return compte;
        }
        return null;

    }

    public void initadim() {
        Administrateur admin = new Administrateur("admin", "admin", "admin", "admin", "toto");
        comptes.put("admin", admin);
    }

    public void initMarchands() {
        for (int i = 1; i <= 10; i++) {
            String nom = "m" + i;
            String prenom = "toto"+i;
            Marchand marchand = new Marchand(nom,prenom , "adresse_" + nom, "siret_" + nom, "toto");
            comptes.put(nom, marchand);
        }
    }

    public void initClients() {
        for (int i = 1; i <= 10; i++) {
            String nom = "c" + i;
            Client client = new Client(nom, "email_" + nom + "@example.com", "adresse_" + nom, "numero_" + nom, "toto");
            comptes.put(nom, client);
        }
    }

    public void getmarchand() {
        System.out.println("Voici la liste des marchands inscrit sur le site:");
        for (Compte compte : comptes.values()) {
            if (compte instanceof Marchand) {
                System.out.println("- " + compte.getPseudo());
            }
        }
    }

    public void getclients() {
        System.out.println("Voici la liste des clients inscrit sur le site:");
        for (Compte compte : comptes.values()) {
            if (compte instanceof Client) {
                System.out.println("- " + compte.getPseudo());
            }
        }
    }

    public void initialise() {
        initadim();
        initMarchands();
        initClients();
    }

    public Marchand recupunmarchand(String pseudo) {
        if (!comptes.containsKey(pseudo)) {
            return null;
        }
        Compte compte = comptes.get(pseudo);
        return (Marchand) compte;
    }

    public void afficherTousLesProduits() {
        for (Compte compte : comptes.values()) {
            if (compte instanceof Marchand) {
                Marchand marchand = (Marchand) compte;
                System.out.println("Produits de " + marchand.getPseudo());
                marchand.presenterproduit();
            }
        }
    }

    public Client recupunclient(String pseudo) {
        if (!comptes.containsKey(pseudo)) {
            return null;
        }
        Compte compte = comptes.get(pseudo);
        return (Client) compte;
    }

    public void modifcompte(Compte c) {
        System.out.println("Que voulez-vous modifier?");
        System.out.println("1. Pseudo");
        System.out.println("2. Mot de passe");
        System.out.println("3. Prenom");
        System.out.println("4. Adresse");
        System.out.println("5. Nom");
        System.out.println("6. annuler");
        int choix = 0;

        while (choix != 7) {
            choix = new GestionUI().saisirChoix();
            switch (choix) {
                case 1:
                    String pseudo = new GestionUI().saisirString("Veuillez saisir le nouveau pseudo : ");
                    c.setPseudo(pseudo);
                    break;
                case 2:
                    String mdp = new GestionUI().saisirString("Veuillez saisir le nouveau mot de passe : ");
                    c.setMdp(mdp);
                    break;
                case 3:
                    String prenom = new GestionUI().saisirString("Veuillez saisir le nouveau prenom : ");
                    c.setPrenom(prenom);
                    break;
                case 4:
                    String adresse = new GestionUI().saisirString("Veuillez saisir la nouvelle adresse : ");
                    c.setAdresse(adresse);
                    break;
                case 5:
                    String nom = new GestionUI().saisirString("Veuillez saisir le nouveau nom : ");
                    c.setNom(nom);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }

    }
}
