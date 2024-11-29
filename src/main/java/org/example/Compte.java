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

    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getAdresse() {
        return adresse;
    }

    public void supprierCompte(Compte compte){

    }

}
