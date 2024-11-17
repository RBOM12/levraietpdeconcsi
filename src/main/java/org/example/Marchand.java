package org.example;

public class Marchand extends Compte {

    public Marchand(String nom, String prenom, String adresse, String pseudo, String mdp) {
        super(nom, prenom, adresse, pseudo, mdp);
    }

    public void ajouterProduit(Produit p){
        new Produit("nom", 3, 5, 1.5F);
    }

    public void modifierProduit(Produit p){

    }

    public void supprimerProduit(Produit p){
        p= null;
    }

    public void getCommandes(){

    }

    public void getProduits(){

    }




}
