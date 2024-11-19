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



    public void ajouterProduitPanier(Produit p, int quantite){
        this.panier.addProduit(p, quantite);
    }

    public void passercommande(){
        this.histoCommandes.add(this.panier);
        this.panier = new Commande(this);

    }


    public void getCommandes(){

    }
    public void payer (float montant){
        System.out.println("Paiement de "+montant+"€ effectué");

    }
}

