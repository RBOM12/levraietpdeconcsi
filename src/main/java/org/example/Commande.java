package org.example;

import java.util.HashMap;

public class Commande {
    private static int compteurCommande = 0;
    private int idCommande;
    private Client client;
    private HashMap<Produit, Integer> hashProduits;


    public Commande( Client c) {
        this.client = c;
        compteurCommande++;
        this.idCommande = compteurCommande;
        hashProduits = new HashMap<Produit, Integer>();
    }

    /*public void passerCommande(Marchand m){

    }
   Donc seul le commerçant passe commande ou on passe commande à un commercant ?
     */

    public void addProduit(Produit p, int quantite){
        if (this.hashProduits.containsKey(p)){
            this.hashProduits.put(p, this.hashProduits.get(p) + quantite);
        }
        else {
        this.hashProduits.put(p, quantite);}
    }
    public int getIdCommande() {
        return this.idCommande;
    }

    public float getPrixCommande() {
        float prixCommande = 0;
        for (Produit p : this.hashProduits.keySet()){
            prixCommande += p.getPrixProduit() * this.hashProduits.get(p);
        }
        return prixCommande;
    }

    public HashMap<Produit, Integer> getHashProduits() {
        return this.hashProduits;
    }
}
