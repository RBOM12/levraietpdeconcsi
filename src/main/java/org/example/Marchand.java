package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Marchand extends Compte  {

    HashMap<Produit,Integer> mesProduits = new HashMap<Produit,Integer>();
    HashMap<Produit,Integer> mesVentes = new HashMap<Produit,Integer>();
    GestionUI g = new GestionUI();


    public Marchand(String nom, String prenom, String adresse, String pseudo, String mdp) {
        super(nom, prenom, adresse, pseudo, mdp);
    }

    public void ajouterProduit(String nom, float prix, int quantite) throws Exception {
        if (prix<0){
            throw new Exception("Prix négatif");

        }
        if (quantite<0){
            throw new Exception("Quantité négative");
        }
        Produit p = new Produit(nom,prix, this);
       this.mesProduits.put(p, quantite );
    }

    public void ajouterQuantiteProduit(Produit p, int quantite) throws Exception {
        if (quantite<0){
            throw new Exception("Quantité négative");
        }
        if (this.mesProduits.containsKey(p)){
            this.mesProduits.put(p, this.mesProduits.get(p)+quantite);
        }

    }
    public void retirerQuantiteProduit(String q, int quantite) throws Exception {
        if (quantite<0){
            throw new Exception("Quantité négative");
        }
        Produit p = getProduit(q);
        if (this.mesProduits.containsKey(p)){
            if (this.mesProduits.get(p)<quantite){
                throw new Exception("Quantité insuffisante");
            }
            this.mesProduits.put(p, this.mesProduits.get(p)-quantite);
        }

    }

    public void venteProduit(String nom, int quantite) throws Exception {
        Produit p = getProduit(nom);
        if (this.mesProduits.containsKey(p)){
            if (this.mesProduits.get(p)<quantite){
                throw new Exception("Quantité insuffisante");
            }
            if (this.mesVentes.containsKey(p)){
                this.mesVentes.put(p, this.mesVentes.get(p)+quantite);
            }
            else {
                this.mesVentes.put(p, quantite);
            }
            this.mesProduits.put(p, this.mesProduits.get(p)-quantite);
        }



    }

    public void modifierNomProduit(Produit p, String nom){
        p.setNomProduit(nom);
    }

    public void modifierPrixProduit(Produit p, float prix) throws Exception {
        if (prix<0){
            throw new Exception("Prix négatif");
        }
        p.setPrixProduit(prix);
    }


    public void supprimerProduit(Produit p){
        this.mesProduits.remove(p);
    }

    public void modifierQuantiteProduit(Produit p, int quantite) throws Exception {
        if (quantite<0){
            throw new Exception("Quantité négative");
        }
        int q = this.mesProduits.get(p) - quantite;


        this.mesProduits.put(p, q);
    }


    public void envoyerCommande (Commande c){
        mesCommandes.add(c);
    }
    public void getCommandes(){

    }

    public void presenterproduit(){
        System.out.println("Voici les produits que j'ai à vendre : ");
        for (Produit produit : this.mesProduits.keySet()){
            System.out.println("- "+produit.getNomProduit()+" à seulement : "+produit.getPrixProduit()+"€");
        }

    }

    public Produit choisirProduit(String nom){
        for (Produit produit : this.mesProduits.keySet()){
            if (produit.getNomProduit().equals(nom)){
                return produit;
            }
        }
        return null;
    }

    public void modifierProduit() throws Exception {
        String nom = g.saisirString("Veuillez saisir le nom du produit : ");
        System.out.println("Voulez vous modifier le nom ou le prix ou ajouter une quantité du produit ? (N/P/Q)");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.nextLine();
        if (reponse.equals("N")) {
            String nouveauNom = g.saisirString("Veuillez saisir le nouveau nom du produit : ");
            modifierNomProduit(choisirProduit(nom), nouveauNom);
        } else if (reponse.equals("P")) {
            Float nouveauPrix = g.saisirFloat("Veuillez saisir le nouveau prix du produit : ");
            modifierPrixProduit(choisirProduit(nom), nouveauPrix);
        } else if (reponse.equals("Q")) {
            int quantite = g.saisirInt("Veuillez saisir la quantité à ajouter : ");
            ajouterQuantiteProduit(choisirProduit(nom), quantite);
        } else {
            System.out.println("Réponse invalide");
        }
    }

    public Produit getProduit(String nom){
        for (Produit produit : this.mesProduits.keySet()){
            if (produit.getNomProduit().equals(nom)){
                return produit;
            }
        }
        return null;
    }


}
