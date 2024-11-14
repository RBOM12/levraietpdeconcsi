package org.example;

public class Compte {
    private String mdp;
    private String pseudo;
    private String nom;
    private String prenom;
    private String adresse;

    public Compte(String nom, String prenom, String adresse, String pseudo, String mdp){
        this.mdp = mdp;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        }


    public void deconnexion(){
        System.out.println("Déconnexion réussie");
    }
}
