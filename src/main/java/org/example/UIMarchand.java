package org.example;

import java.awt.*;

public class UIMarchand {
    GestionUI gUI = new GestionUI();
    GestionCompte gC;
    private String nom;
    private float prix;
    private int quantite;

    public void start(Marchand m) throws Exception {
        System.out.println("Bienvenue " + m.getPseudo());
        System.out.println("------------------------------------------");
        System.out.println("1. Créer un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer une quantité d'un produit");
        System.out.println("4. Supprimer un produit de mon catalogue");
        System.out.println("5. Voir mes ventes");
        System.out.println("6. Voir mes clients");
        System.out.println("7. Se déconnecter");
        System.out.println("8. Supprimer le compte");
        System.out.println("------------------------------------------");

        int choix = 0;
        while (choix != 5) {
            choix = gUI.saisirChoix();
            switch (choix) {
                case 1:
                    this.nom = gUI.saisirString("Veuillez saisir le nom du produit : ");
                    this.prix = gUI.saisirFloat("Veuillez saisir le prix du produit : ");
                    this.quantite = gUI.saisirInt("Veuillez saisir la quantite du produit : ");
                    m.ajouterProduit(nom, prix, quantite);
                    System.out.println("Produit " + nom + " ajouté");
                    break;
                case 2:
                    System.out.println("Modifier un produit");
                    m.modifierProduit();
                    break;
                case 3:
                    this.nom = gUI.saisirString("Veuillez saisir le nom du produit : ");
                    quantite = gUI.saisirInt("Veuillez saisir la quantite du produit : ");
                    m.retirerQuantiteProduit(nom, quantite);
                    System.out.println("Quantité de produit " + nom + " supprimée");
                    break;

                case 4:
                    nom = gUI.saisirString("Veuillez saisir le nom du produit : ");
                    m.supprimerProduit(m.choisirProduit(nom));
                    System.out.println("Produit " + nom + " supprimé");
                    break;
                case 5:
                    m.afficherVentes();
                    break;
                case 6:
                    m.afficherClients();
                    break;
                case 7:
                    System.out.println("Déconnexion");
                    m.deconnexion();
                    break;
                case 8:
                    System.out.println("Suppretion du compte");
                    supprimermoncompte(m);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }

    public void supprimermoncompte(Marchand m) {
        {
            gC.supprimerCompte(m);
        }
    }
}

