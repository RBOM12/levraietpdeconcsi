package org.example;

import java.util.HashMap;

public class Utilisateur  {
    private HashMap<String, Compte> hashComptes = new HashMap<String, Compte>();

    private Catalogue catalogue;

    public Utilisateur() {
        this.catalogue = new Catalogue();
    }

    public Compte connexion( String pseudo, String motDePasse)throws Exception{
        if (this.hashComptes.containsKey(pseudo)){
            Compte compte = this.hashComptes.get(pseudo);
            if (compte.getMdp().equals(motDePasse)){
                System.out.println("Connexion réussie");
                return compte;
            } else {
                System.out.println("Mot de passe incorrect");

            }
        } else {
            System.out.println("Mot de passe incorrect");
        }
        return null;
    }

    public Compte inscription( String nom, String prenom, String adresse, String pseudo, String motDePasse,boolean isMarchand){
        if (this.hashComptes.containsKey(pseudo)){
            System.out.println("Pseudo déjà utilisé");
            return null;
        }
        if (isMarchand){
            Marchand marchand = new Marchand(nom, prenom, adresse, pseudo, motDePasse);
            this.hashComptes.put(pseudo, marchand);
            return marchand;
        } else {
            Client client = new Client(nom, prenom, adresse, pseudo, motDePasse);
            this.hashComptes.put(pseudo, client);
            return client;
        }
    }

    public void voirMarchands(){
        System.out.println("Liste des marchands");
        this.catalogue.getMarchands();
    }

    public void voirProduitMarchands(Marchand marchand){
        System.out.println("Liste des produits du marchand");
        marchand.presenterproduit();
    }

}
