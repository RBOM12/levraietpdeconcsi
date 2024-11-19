package org.example;

public class Produit {

    private static int compteur = 0;
    private String nomProduit;
    private int idProduit;
    private int quantiteProduit;
    private float prixProduit;
    private Marchand marchand;

    public Produit(String nomProduit, float prixProduit, Marchand marchand) {
        compteur++;
        this.nomProduit=nomProduit;
        this.idProduit=compteur;
        this.prixProduit=prixProduit;
        this.marchand=marchand;
    }



    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getIdProduit() {
        return idProduit;
    }


    public float getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(float prixProduit) {
        this.prixProduit = prixProduit;
    }
}
