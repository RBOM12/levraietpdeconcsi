package org.example;

public class Produit {

    private String nomProduit;
    private int idProduit;
    private int quantiteProduit;
    private float prixProduit;

    public Produit(String nomProduit, int idProduit, int quantiteProduit, float prixProduit){
        this.nomProduit=nomProduit;
        this.idProduit=idProduit;
        this.quantiteProduit=quantiteProduit;
        this.prixProduit=prixProduit;
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

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public float getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(float prixProduit) {
        this.prixProduit = prixProduit;
    }
}
