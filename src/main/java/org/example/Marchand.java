package org.example;

import java.util.ArrayList;

public class Marchand extends Compte {

    ArrayList<Produit> mesProduits = new ArrayList<Produit>();
    ArrayList<Commande> mesCommandes = new ArrayList<Commande>();

    public Marchand(String nom, String prenom, String adresse, String pseudo, String mdp) {
        super(nom, prenom, adresse, pseudo, mdp);
    }

    public void ajouterProduit(Produit p){
        new Produit("nom", 3, 5, 1.5F);
       mesProduits.add(p);
    }


    public void supprimerProduit(Produit p){
        mesProduits.remove(p);

    }
    public void envoyerProduit(int quantite, Commande c){
        if (c.p.getQuantiteProduit()>=quantite){
            p.setQuantiteProduit(p.getQuantiteProduit()-quantite);
        }else{
            System.out.println("Quantité insuffisante");
        }


    }

    public void envoyerCommande (Commande c){
        mesCommandes.add(c);
    }
    public void getCommandes(){

    }

    public void getProduits(){

    }




}
