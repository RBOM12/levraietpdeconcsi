package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
public class CommandeTest {
    private Commande commande;
    private Client client;
    private Produit produit1;
    private Produit produit2;

    @Before
    public void setUp() {
        client = new Client("Ronaldo", "Cristiano", "Madere, Portugal", "CR7", "8etterThanMessi" );
        commande = new Commande(client);

        Marchand marchand1 = new Marchand("LeLoupDe", "LinkedIn", "1 rue des corpos", "LeVraiLoupDeLinkedIn", "MotDePasse");
        Marchand marchand2 = new Marchand("LAutrucheDe", "Snapchat", "1 rue des influs", "LaVraieAutrucheDeSnap", "12345678");

        produit1 = new Produit("Produit 1", 10.0F, marchand1);
        produit2 = new Produit("Produit 2", 20.0F, marchand2);
    }

    @Test
    public void addProduit() {
        commande.addProduit(produit1, 2);
        HashMap<Produit, Integer> produits = commande.getHashProduits();
        assertTrue(produits.containsKey(produit1));
        assertEquals(2, (int) produits.get(produit1));
    }

    @Test
    public void getPrixCommande() {
        commande.addProduit(produit1, 2);
        commande.addProduit(produit2, 1);
        float prixTotal = commande.getPrixCommande();
        assertEquals(40.0f, prixTotal, 0.001f);
    }
}