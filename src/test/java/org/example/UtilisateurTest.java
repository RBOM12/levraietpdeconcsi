package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilisateurTest {

    private Utilisateur utilisateur;

    @Before
    public void setUp() {
        utilisateur = new Utilisateur();
    }

    @Test
    public void testInscriptionAsMarchand() {
        Compte compte = utilisateur.inscription(
                "Doe",
                "John",
                "123 Main St",
                "johndoe",
                "securepassword",
                true
        );

        assertNotNull("L'inscription devrait retourner un objet Compte", compte);
        assertTrue("Le Compte devrait être une instance de Marchand", compte instanceof Marchand);
    }

    @Test
    public void testInscriptionAsClient() {
        Compte compte = utilisateur.inscription(
                "Smith",
                "Jane",
                "456 Elm St",
                "janesmith",
                "anotherpassword",
                false
        );

        assertNotNull("L'inscription devrait retourner un objet Compte", compte);
        assertTrue("Le Compte devrait être une instance de Client", compte instanceof Client);
    }

    @Test
    public void testInscription_PseudoAlreadyUsed() {
        Compte firstInscription = utilisateur.inscription(
                "Brown",
                "Charlie",
                "789 Oak St",
                "charlieb",
                "password123",
                false
        );
        assertNotNull("La première inscription devrait réussir", firstInscription);

        Compte secondInscription = utilisateur.inscription(
                "Brown",
                "Charles",
                "101 Pine St",
                "charlieb",
                "newpassword",
                true
        );
        assertNull("La seconde inscription avec le même pseudo devrait retourner null", secondInscription);
    }

    @Test
    public void testConnexion() throws Exception {
        Compte inscrit = utilisateur.inscription(
                "Taylor",
                "Alex",
                "202 Maple St",
                "alext",
                "mypassword",
                false
        );
        assertNotNull("L'inscription devrait réussir", inscrit);

        Compte connected = utilisateur.connexion("alext", "mypassword");
        assertNotNull("La connexion devrait retourner un objet Compte", connected);
        assertEquals("Le Compte connecté devrait être le même que celui inscrit", inscrit, connected);
    }

    @Test
    public void testConnexion_IncorrectPassword() throws Exception {
        utilisateur.inscription(
                "Lee",
                "Chris",
                "303 Birch St",
                "chrisl",
                "securepass",
                true
        );

        Compte connected = utilisateur.connexion("chrisl", "wrongpass");
        assertNull("La connexion avec un mot de passe incorrect devrait retourner null", connected);
    }

    @Test
    public void testVoirMarchands() {
        try {
            utilisateur.voirMarchands();
        } catch (Exception e) {
            fail("La méthode voirMarchands ne devrait pas lever d'exception.");
        }
    }

    @Test
    public void testVoirProduitMarchands() {
        Marchand marchand = new Marchand("Dupont", "Marie", "404 Not Found St", "maried", "password");

        try {
            utilisateur.voirProduitMarchands(marchand);
        } catch (Exception e) {
            fail("La méthode voirProduitMarchands ne devrait pas lever d'exception.");
        }
    }
}

