package org.example;

public class UIClient {
    GestionUI gUI = new GestionUI();
    GestionCompte gC;
    public UIClient(GestionCompte gC) {
        this.gC = gC;
    }

    public void start(Client c) throws Exception {

        System.out.println("Bienvenue " + c.getPseudo());
        System.out.println("------------------------------------------");
        System.out.println("1. Ajouter un produit au panier");
        System.out.println("2. Supprimer un produit au panier");
        System.out.println("3. Voir les produits dans le panier");
        System.out.println("4. Voir les produits du catalogue");
        System.out.println("5. Voir les produits d'un marchand");
        System.out.println("6. Passer commande");
        System.out.println("7. Voir mes commandes");
        System.out.println("8. Se déconnecter");
        System.out.println("9. Supprimer mon compte");
        System.out.println("------------------------------------------");

        int choix = 0;
        while (choix != 5) {
            choix = gUI.saisirChoix();
            switch (choix) {
                case 1:
                    String nm = gUI.saisirString("Veuillez saisir le nom du marchand : ");
                    Marchand m = gC.recupunmarchand(nm);
                    String nom = gUI.saisirString("Veuillez saisir le nom du produit : ");
                    int quantite = gUI.saisirInt("Veuillez saisir la quantite du produit : ");
                    c.ajouterProduitPanier(m,nom, quantite);

                    break;
                case 2:
                    c.afficherproduits();
                    String nomp = gUI.saisirString("Veuillez saisir le nom du produit que vous voulez supr: ");
                    c.suppProduitPanier(nomp);
                    break;
                case 3:
                    c.afficherproduits();
                    break;
                case 4:
                    gC.afficherTousLesProduits();
                    break;
                case 5:
                    String nm1 = gUI.saisirString("Veuillez saisir le nom du marchand : ");
                    Marchand m1 = gC.recupunmarchand(nm1);
                    c.demanderafficherproduits(m1);
                    break;

                case 6:
                    System.out.println("Passer commande");
                    c.passercommande();
                    float t =c.getvaleurPanier();
                    c.payer(t);
                    break;

                case 7:
                    System.out.println("Voir mes commandes");
                    c.afficherhistorique();
                    break;
                case 8:
                    System.out.println("Déconnexion");
                    c.deconnexion();
                    break;
                case 9:
                    System.out.println("Suppressions de votre compte");
                    supprimermoncompte(c);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }

    public void supprimermoncompte(Client c)  {
        gC.supprimerCompte(c);
    }
}