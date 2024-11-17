package org.example;

public class Commande {
    private String nomCommande;
    private int idCommande;
    private int quantiteCommande;
    private float prixCommande;

    public Commande(String nomCommande, int idCommande, int quantiteCommande, float prixCommande) {
        this.nomCommande = nomCommande;
        this.idCommande = idCommande;
        this.quantiteCommande = quantiteCommande;
        this.prixCommande = prixCommande;
    }

    /*public void passerCommande(Marchand m){

    }
   Donc seul le commerçant passe commande ou on passe commande à un commercant ?
     */

    public String getNomCommande() {
        return nomCommande;
    }

    public void setNomCommande(String nomCommande) {
        this.nomCommande = nomCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public float getPrixCommande() {
        return prixCommande;
    }

    public void setPrixCommande(float prixCommande) {
        this.prixCommande = prixCommande;
    }
}
