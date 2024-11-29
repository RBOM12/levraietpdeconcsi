package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogueTest {

    private Catalogue catalogue;
    private Marchand marchand1;
    private Marchand marchand2;

    @Before
    public void setUp() {
        catalogue = new Catalogue();
        marchand1 = new Marchand("Dupont", "Marie", "123 Rue Principale", "maried", "password");
        marchand2 = new Marchand("Durand", "Paul", "456 Rue Secondaire", "pauld", "password123");
    }

    @Test
    public void testAddMarchand() {
        catalogue.addMarchand(marchand1);
        assertTrue("Le marchand1 devrait être présent dans le catalogue", catalogue.marchands.contains(marchand1));
    }

    @Test
    public void testRemoveMarchand() {
        catalogue.addMarchand(marchand1);
        catalogue.addMarchand(marchand2);

        catalogue.removeMarchand(marchand1);
        assertFalse("Le marchand1 ne devrait plus être présent dans le catalogue", catalogue.marchands.contains(marchand1));
        assertTrue("Le marchand2 devrait toujours être présent dans le catalogue", catalogue.marchands.contains(marchand2));
    }

    @Test
    public void testGetMarchands() {
        catalogue.addMarchand(marchand1);
        catalogue.addMarchand(marchand2);

        System.out.println("Test affichage des marchands :");
        catalogue.getMarchands();
    }

    @Test
    public void testCatalogueVide() {
        assertTrue("Le catalogue devrait être vide après sa création", catalogue.marchands.isEmpty());
    }
}
