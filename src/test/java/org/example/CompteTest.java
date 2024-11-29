package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompteTest {

    private Compte compte;

    @Before
    public void setUp() {
        compte = new Compte("Dupont", "Jean", "123 Rue Principale", "jeand", "password123");
    }

    @Test
    public void testCompteCreation() {
        assertNotNull("Le compte ne devrait pas être null après sa création", compte);
        assertEquals("Le nom du compte devrait être correct", "Dupont", compte.getNom());
        assertEquals("Le prénom du compte devrait être correct", "Jean", compte.getPrenom());
        assertEquals("L'adresse du compte devrait être correcte", "123 Rue Principale", compte.getAdresse());
        assertEquals("Le pseudo du compte devrait être correct", "jeand", compte.getPseudo());
        assertEquals("Le mot de passe du compte devrait être correct", "password123", compte.getMdp());
    }

    @Test
    public void testSetGetNom() {
        compte.setNom("Martin");
        assertEquals("Le nom du compte devrait être mis à jour correctement", "Martin", compte.getNom());
    }

    @Test
    public void testSetGetPrenom() {
        compte.setPrenom("Paul");
        assertEquals("Le prénom du compte devrait être mis à jour correctement", "Paul", compte.getPrenom());
    }

    @Test
    public void testSetGetAdresse() {
        compte.setAdresse("456 Rue Secondaire");
        assertEquals("L'adresse du compte devrait être mise à jour correctement", "456 Rue Secondaire", compte.getAdresse());
    }

    @Test
    public void testSetGetPseudo() {
        compte.setPseudo("pauld");
        assertEquals("Le pseudo du compte devrait être mis à jour correctement", "pauld", compte.getPseudo());
    }

    @Test
    public void testSetGetMdp() {
        compte.setMdp("newpassword");
        assertEquals("Le mot de passe du compte devrait être mis à jour correctement", "newpassword", compte.getMdp());
    }

    @Test
    public void testDeconnexion() {
        System.out.println("Test déconnexion :");
        compte.deconnexion();
    }

    @Test
    public void testSupprimerCompte() {
        try {
            compte.supprierCompte(compte);
            // Aucune exception ne devrait être levée
        } catch (Exception e) {
            fail("La méthode supprierCompte ne devrait pas lever d'exception");
        }
    }
}
