package org.example;

public class Administrateur extends Compte{


    public Administrateur(String nom, String prenom, String adresse, String pseudo, String mdp) {
        super(nom, prenom, adresse, pseudo, mdp);
    }

    public void supprimerCompte( Compte compte){
        compte= null;
    }

    public void modifierCompte(Compte compte){

    }
}
