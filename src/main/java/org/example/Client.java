package org.example;

public class Client extends Compte{

    private String mdp;
    private String pseudo;
    private String nom;
    private String prenom;
    private String adresse;

    public Client(String nom, String prenom, String adresse, String pseudo, String mdp) {
        super(nom, prenom, adresse, pseudo, mdp);
    }


    public void acheterProduit(int quantite, Produit produit,Marchand marchand){
        if(produit.getQuantite() >= quantite){
            produit.setQuantite(produit.getQuantite() - quantite);
            marchand.setSolde(marchand.getSolde() + quantite * produit.getPrix());
        }


    }
}
