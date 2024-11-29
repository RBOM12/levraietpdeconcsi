package org.example;

import java.util.ArrayList;

public class Client extends Compte{
    private Commande panier ;
    private ArrayList<Commande> histoCommandes;

    public Client(String nom, String prenom, String adresse, String pseudo, String mdp) {
        super(nom, prenom, adresse, pseudo, mdp);
        this.panier = new Commande(this);
        this.histoCommandes = new ArrayList<Commande>();
    }
    public void ajouterProduitPanier(Marchand m,String p, int quantite){
        this.panier.addProduit( m,p, quantite);
    }
    public void passercommande() throws Exception {
        this.histoCommandes.add(this.panier);
        this.panier.envoieProduits();
        this.panier = new Commande(this);


    }
    public void afficherproduits(){
        System.out.println("Voici les produits de votre panier:");
        for (Produit p : this.panier.getHashProduits().keySet()){
            System.out.println(p.getNomProduit()+" : "+p.getPrixProduit()+"€ x"+this.panier.getHashProduits().get(p));
        }
    }

    public void suppProduitPanier(String nomProduit){
        for (Produit p : this.panier.getHashProduits().keySet()){
            if (p.getNomProduit().equals(nomProduit)){
                this.panier.getHashProduits().remove(p);
                return;
            }
        }
        System.out.println("Produit non trouvé");
    }

    public void afficherhistorique(){
        System.out.println("Voici votre historique de commandes:");
        for (Commande c : this.histoCommandes){
            System.out.println("Voici les produits de votre panier:"+c.getIdCommande());
            for (Produit p : c.getHashProduits().keySet()){
                System.out.println(p.getNomProduit()+" : "+p.getPrixProduit()+"€ x"+this.panier.getHashProduits().get(p));
            } }

    }
    public void payer (float montant){
        System.out.println("Paiement de "+montant+"€ effectué");

    }

    public void demanderafficherproduits(Marchand marchand){
        System.out.println("Quels produits avez-vous à vendre?");
        marchand.presenterproduit();
    }

    public float getvaleurPanier(){
        float valeur = 0;
        for (Produit p : this.panier.getHashProduits().keySet()){
            valeur += p.getPrixProduit() * this.panier.getHashProduits().get(p);
        }
        return valeur;
    }

    public void suppressionCompte() {
        GestionCompte.supprimerCompte(this);
    }


}

