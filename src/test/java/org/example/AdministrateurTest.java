package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdministrateurTest {

    private Administrateur administrateur;

    @Before
    public void setUp() {
        administrateur = new Administrateur("Dupont", "Jean", "123 Rue Admin", "adminj", "securepassword");
    }

    @Test
    public void testAdministrateurCreation() {
        assertNotNull("L'administrateur ne devrait pas être null après sa création", administrateur);
        assertEquals("Le nom de l'administrateur devrait être correct", "Dupont", administrateur.getNom());
        assertEquals("Le prénom de l'administrateur devrait être correct", "Jean", administrateur.getPrenom());
        assertEquals("L'adresse de l'administrateur devrait être correcte", "123 Rue Admin", administrateur.getAdresse());
        assertEquals("Le pseudo de l'administrateur devrait être correct", "adminj", administrateur.getPseudo());
        assertEquals("Le mot de passe de l'administrateur devrait être correct", "securepassword", administrateur.getMdp());
    }

    @Test
    public void testInheritance() {
        assertTrue("L'administrateur devrait être une instance de Compte", administrateur instanceof Compte);
    }
}
