package org.example;

public class Produit {

    private String nomProduit;
    private int idProduit;
    private int quantiteProduit;
    private long prixProduit;

    public Produit(String nomProduit, int idProduit, int quantiteProduit, long prixProduit){
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

    public long getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(long prixProduit) {
        this.prixProduit = prixProduit;
    }
}
