package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestionCompteTest {

    private GestionCompte gestionCompte;

    @Before
    public void setUp() {
        gestionCompte = new GestionCompte();
    }

    @Test
    public void testAjouterCompte() {
        Compte compte = new Compte("Dupont", "Jean", "123 Rue Principale", "jeand", "password123");
        gestionCompte.ajouterCompte(compte);

        assertEquals("Le compte devrait être ajouté à la collection", compte, gestionCompte.comptes.get("jeand"));
    }

    @Test
    public void testSupprimerCompte() {
        Compte compte = new Compte("Durand", "Paul", "456 Rue Secondaire", "pauld", "securepass");
        gestionCompte.ajouterCompte(compte);
        gestionCompte.supprimerCompte(compte);

        assertNull("Le compte devrait être supprimé de la collection", gestionCompte.comptes.get("pauld"));
    }

    @Test
    public void testGetCompte_Valide() {
        Compte compte = new Compte("Martin", "Claire", "789 Rue Tertiaire", "clairem", "mypassword");
        gestionCompte.ajouterCompte(compte);

        Compte resultat = gestionCompte.getCompte("clairem", "mypassword");
        assertEquals("Le compte récupéré devrait correspondre", compte, resultat);
    }

    @Test
    public void testGetCompte_Invalide() {
        Compte resultat = gestionCompte.getCompte("inconnu", "password");
        assertNull("La récupération d'un compte inexistant devrait retourner null", resultat);
    }

    @Test
    public void testInitAdim() {
        gestionCompte.initadim();

        Compte admin = gestionCompte.comptes.get("admin");
        assertNotNull("L'administrateur devrait être initialisé", admin);
        assertTrue("L'administrateur devrait être une instance de Administrateur", admin instanceof Administrateur);
    }

    @Test
    public void testInitMarchands() {
        gestionCompte.initMarchands();

        for (int i = 1; i <= 10; i++) {
            String nom = "m" + i;
            Compte marchand = gestionCompte.comptes.get(nom);
            assertNotNull("Le marchand " + nom + " devrait être initialisé", marchand);
            assertTrue("Le compte " + nom + " devrait être une instance de Marchand", marchand instanceof Marchand);
        }
    }

    @Test
    public void testInitClients() {
        gestionCompte.initClients();

        for (int i = 1; i <= 10; i++) {
            String nom = "c" + i;
            Compte client = gestionCompte.comptes.get(nom);
            assertNotNull("Le client " + nom + " devrait être initialisé", client);
            assertTrue("Le compte " + nom + " devrait être une instance de Client", client instanceof Client);
        }
    }

    @Test
    public void testRecupUnMarchand() {
        Marchand marchand = new Marchand("Martin", "Paul", "123 Rue Marchand", "marchand1", "password");
        gestionCompte.ajouterCompte(marchand);

        Marchand resultat = gestionCompte.recupunmarchand("marchand1");
        assertEquals("Le marchand récupéré devrait correspondre", marchand, resultat);
    }

    @Test
    public void testRecupUnClient() {
        Client client = new Client("Durand", "Julie", "456 Rue Client", "client1", "password");
        gestionCompte.ajouterCompte(client);

        Client resultat = gestionCompte.recupunclient("client1");
        assertEquals("Le client récupéré devrait correspondre", client, resultat);
    }
}
