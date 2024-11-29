package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProduitTest {

    private Produit produit;
    private Marchand marchand;

    @Before
    public void setUp() {
        marchand = new Marchand("Dupont", "Marie", "123 Rue Marchand", "maried", "password");
        produit = new Produit("ProduitTest", 25.5f, marchand);
    }

    @Test
    public void testProduitCreation() {
        assertNotNull("Le produit ne devrait pas être null après sa création", produit);
        assertEquals("Le nom du produit devrait être correct", "ProduitTest", produit.getNomProduit());
        assertEquals("Le prix du produit devrait être correct", 25.5f, produit.getPrixProduit(), 0.01);
        assertEquals("Le marchand du produit devrait être correctement assigné", marchand, produit.getMarchand());
    }

    @Test
    public void testProduitIdIncrement() {
        Produit produit2 = new Produit("ProduitTest2", 30.0f, marchand);
        assertTrue("L'ID du second produit devrait être supérieur à celui du premier", produit2.getIdProduit() > produit.getIdProduit());
    }

    @Test
    public void testSetGetNomProduit() {
        produit.setNomProduit("NouveauNomProduit");
        assertEquals("Le nom du produit devrait être mis à jour correctement", "NouveauNomProduit", produit.getNomProduit());
    }

    @Test
    public void testSetGetPrixProduit() {
        produit.setPrixProduit(35.0f);
        assertEquals("Le prix du produit devrait être mis à jour correctement", 35.0f, produit.getPrixProduit(), 0.01);
    }

    @Test
    public void testGetMarchand() {
        assertEquals("Le marchand assigné au produit devrait être correct", marchand, produit.getMarchand());
    }
}
