package org.example;

public class Client extends Utilisateur{

    private String mdp;
    private String pseudo;
    private String nom;
    private String prenom;
    private String adresse;
    private int codeCB;
    private int numCB;

    public void client(String nom, String prenom, String adresse, int codeCB, int numCB, String pseudo, String mdp){
        this.mdp = mdp;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codeCB = codeCB;
        this.numCB = numCB;

    }
}
