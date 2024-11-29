package org.example;

public class UIMarchand {
    GestionUI gUI = new GestionUI();
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
        System.out.println("5. Voir mes commandes");
        System.out.println("6. Se déconnecter");
        System.out.println("------------------------------------------");

        int choix = 0;
        while (choix != 5) {
            choix = gUI.saisirChoix();
            switch (choix) {
                case 1:
                    String nom = gUI.saisirString("Veuillez saisir le nom du produit : ");
                    float prix = gUI.saisirFloat("Veuillez saisir le prix du produit : ");
                    int quantite = gUI.saisirInt("Veuillez saisir la quantite du produit : ");
                    m.ajouterProduit(nom, prix, quantite);
                    System.out.println("Produit " + nom + " ajouté");
                    break;
                case 2:
                    System.out.println("Modifier un produit");
                    m.modifierProduit();
                    break;
                case 3:
                    nom = gUI.saisirString("Veuillez saisir le nom du produit : ");
                    quantite = gUI.saisirInt("Veuillez saisir la quantite du produit : ");
                    m.supprimerQuantiteProduit(m.choisirProduit(nom), quantite);
                    System.out.println("Quantité de produit " + nom + " supprimée");
                    break;

                case 3:
                    nom = gUI.saisirString("Veuillez saisir le nom du produit : ");
                    m.supprimerProduit(m.choisirProduit(nom));
                    System.out.println("Produit " + nom + " supprimé");
                    break;
                case 4:
                    System.out.println("Voir mes commandes");
                    break;
                case 5:
                    System.out.println("Se déconnecter");
                    m.deconnexion();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }
}
