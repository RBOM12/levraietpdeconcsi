package org.example;

public class Client extends Compte{

    private String mdp;
    private String pseudo;
    private String nom;
    private String prenom;
    private String adresse;


    public Client(String nom, String prenom, String adresse, int codeCB, int numCB, String pseudo, String mdp){
        this.mdp = mdp;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codeCB = codeCB;
        this.numCB = numCB;

    }

    public void acheterProduit(int quantite, Produit produit,Marchand marchand){
        if(produit.getQuantite() >= quantite){
            produit.setQuantite(produit.getQuantite() - quantite);
            marchand.setSolde(marchand.getSolde() + quantite * produit.getPrix());
        }


    }
}
