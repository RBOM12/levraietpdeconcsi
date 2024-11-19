package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Marchand extends Compte  {

    HashMap<Produit,Integer> mesProduits = new HashMap<Produit,Integer>();
    ArrayList<Commande> mesCommandes = new ArrayList<Commande>();

    public Marchand(String nom, String prenom, String adresse, String pseudo, String mdp) {
        super(nom, prenom, adresse, pseudo, mdp);
    }

    public void ajouterProduit(String nom, float prix, int quantite) throws Exception {
        if (prix<0){
            throw new Exception("Prix négatif");

        }
        if (quantite<0){
            throw new Exception("Quantité négative");
        }
        Produit p = new Produit(nom,prix, this);
       this.mesProduits.put(p, quantite );
    }

    public void ajouterQuantiteProduit(Produit p, int quantite) throws Exception {
        if (quantite<0){
            throw new Exception("Quantité négative");
        }
        if (this.mesProduits.containsKey(p)){
            this.mesProduits.put(p, this.mesProduits.get(p)+quantite);
        }

    }
    public void retirerQuantiteProduit(Produit p, int quantite) throws Exception {
        if (quantite<0){
            throw new Exception("Quantité négative");
        }
        if (this.mesProduits.containsKey(p)){
            if (this.mesProduits.get(p)<quantite){
                throw new Exception("Quantité insuffisante");
            }
            this.mesProduits.put(p, this.mesProduits.get(p)-quantite);
        }

    }

    public void modifierNomProduit(Produit p, String nom){
        p.setNomProduit(nom);
    }
    public void modifierPrixProduit(Produit p, float prix) throws Exception {
        if (prix<0){
            throw new Exception("Prix négatif");
        }
        p.setPrixProduit(prix);
    }


    public void supprimerProduit(Produit p){
        this.mesProduits.remove(p);

    }

    public void envoyerCommande (Commande c){
        mesCommandes.add(c);
    }
    public void getCommandes(){

    }

    public void getProduits(){

    }




}
