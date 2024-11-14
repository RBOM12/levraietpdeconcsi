package org.example;

public class Client extends Utilisateur{

    private String nom;
    private String prenom;
    private String adresse;
    private int codeCB;
    private int numCB;

    public void utilisiateur(String nom, String prenom, String adresse, int codeCB, int numCB){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codeCB = codeCB;
        this.numCB = numCB;

    }
}
