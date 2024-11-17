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

    /*public void passerCommande( Marchand m, Produit p, int quantite){
        new Commande();
    }
    Il faudrait mettre au clair la commmande a t elle un nom propre ou le nom du commercant ?
    et sa relation avec produit est inexistante avec produit
     */

    public void getCommandes(){

    }
}
