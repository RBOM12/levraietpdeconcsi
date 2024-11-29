package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.HashMap;

public class MarchandTest {

    private Marchand marchand;

    @Before
    public void setUp() {
        marchand = new Marchand("Dupont", "Marie", "123 Rue Principale", "maried", "password123");
    }

    @Test
    public void testAjouterProduit() throws Exception {
        marchand.ajouterProduit("Produit1", 10.5f, 100);

        Produit produit = marchand.getProduit("Produit1");
        assertNotNull("Le produit ajouté devrait être dans la liste des produits", produit);
        assertEquals("Le prix du produit ajouté devrait être correct", 10.5f, produit.getPrixProduit(), 0.01);
        assertEquals("La quantité du produit ajouté devrait être correcte", Integer.valueOf(100), marchand.mesProduits.get(produit));
    }

    @Test
    public void testModifierQuantiteProduit() throws Exception {
        marchand.ajouterProduit("Produit4", 20.0f, 50);
        Produit produit = marchand.getProduit("Produit4");

        marchand.modifierQuantiteProduit(produit, 20);

        assertEquals("La quantité modifiée devrait être correcte", Integer.valueOf(30), marchand.mesProduits.get(produit));
    }

    @Test
    public void testVenteProduit_Success() throws Exception {
        Client client = new Client("Smith", "John", "456 Rue Secondaire", "johnsmith", "password");
        marchand.ajouterProduit("Produit6", 30.0f, 50);
        Produit produit = marchand.getProduit("Produit6");

        marchand.venteProduit("Produit6", 10, client);

        assertEquals("La quantité restante du produit après la vente devrait être correcte", Integer.valueOf(40), marchand.mesProduits.get(produit));
        assertEquals("La quantité vendue devrait être enregistrée correctement", Integer.valueOf(10), marchand.mesVentes.get(produit));
        assertTrue("Le client devrait être ajouté à la liste des clients", marchand.mesClients.contains(client));
    }

    @Test
    public void testSupprimerProduit() throws Exception {
        marchand.ajouterProduit("Produit8", 50.0f, 20);
        Produit produit = marchand.getProduit("Produit8");

        marchand.supprimerProduit(produit);

        assertNull("Le produit supprimé ne devrait plus exister", marchand.getProduit("Produit8"));
    }

    @Test
    public void testModifierPrixProduit() throws Exception {
        marchand.ajouterProduit("Produit9", 60.0f, 10);
        Produit produit = marchand.getProduit("Produit9");

        marchand.modifierPrixProduit(produit, 70.0f);

        assertEquals("Le prix modifié devrait être correct", 70.0f, produit.getPrixProduit(), 0.01);
    }
}

