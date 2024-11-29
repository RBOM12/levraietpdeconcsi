package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeTest {

    private Commande commande;
    private Client client;
    private Marchand marchand;

    @Before
    public void setUp() throws Exception {
        client = new Client("Doe", "John", "123 Rue Principale", "johndoe", "password123");
        marchand = new Marchand("Dupont", "Marie", "456 Rue Secondaire", "maried", "password");

        marchand.ajouterProduit("Produit1", 10.0f, 50);
        marchand.ajouterProduit("Produit2", 20.0f, 30);

        commande = new Commande(client);
    }

    @Test
    public void testAddProduit() {
        commande.addProduit(marchand, "Produit1", 3);

        assertEquals("La commande devrait contenir 3 unités de Produit1", Integer.valueOf(3),
                commande.getHashProduits().get(marchand.getProduit("Produit1")));
    }

    @Test
    public void testGetPrixCommande() {
        commande.addProduit(marchand, "Produit1", 2);
        commande.addProduit(marchand, "Produit2", 1);

        float prixTotal = commande.getPrixCommande();
        assertEquals("Le prix total de la commande devrait être correct", 40.0f, prixTotal, 0.01);
    }

    @Test
    public void testEnvoieProduits() throws Exception {
        commande.addProduit(marchand, "Produit1", 2);

        commande.envoieProduits();

        assertEquals("Le stock de Produit1 du marchand devrait être réduit", Integer.valueOf(48),
                marchand.mesProduits.get(marchand.getProduit("Produit1")));
    }

    @Test
    public void testGetIdCommande() {
        int idCommande = commande.getIdCommande();
        assertTrue("L'ID de la commande devrait être supérieur à 0", idCommande > 0);
    }
}
