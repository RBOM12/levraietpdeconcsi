package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    private Client client;
    private Marchand marchand;

    @Before
    public void setUp() {
        client = new Client("Doe", "John", "123 Rue Principale", "johndoe", "password123");
        marchand = new Marchand("Dupont", "Marie", "456 Rue Secondaire", "maried", "password");
    }

    @Test
    public void testAjouterProduitPanier() throws Exception {
        marchand.ajouterProduit("Produit1", 10.0f, 50);
        client.ajouterProduitPanier(marchand, "Produit1", 5);

        float valeurPanier = client.getvaleurPanier();
        assertEquals("La valeur totale du panier devrait être correcte", 50.0f, valeurPanier, 0.01);
    }

    @Test
    public void testSuppProduitPanier() throws Exception {
        marchand.ajouterProduit("Produit2", 20.0f, 30);
        client.ajouterProduitPanier(marchand, "Produit2", 2);

        client.suppProduitPanier("Produit2");
        float valeurPanier = client.getvaleurPanier();
        assertEquals("La valeur totale du panier après suppression devrait être 0", 0.0f, valeurPanier, 0.01);
    }

    @Test
    public void testAfficherProduits() throws Exception {
        marchand.ajouterProduit("Produit3", 15.0f, 20);
        client.ajouterProduitPanier(marchand, "Produit3", 3);

        client.afficherproduits();
    }

    @Test
    public void testPasserCommande() throws Exception {
        marchand.ajouterProduit("Produit4", 30.0f, 10);
        client.ajouterProduitPanier(marchand, "Produit4", 2);

        client.passercommande();

        assertEquals("L'historique des commandes devrait contenir une commande", 1, client.histoCommandes.size());
        assertEquals("La valeur du panier après commande devrait être 0", 0.0f, client.getvaleurPanier(), 0.01);
    }

    @Test
    public void testAfficherHistorique() throws Exception {
        marchand.ajouterProduit("Produit5", 25.0f, 15);
        client.ajouterProduitPanier(marchand, "Produit5", 1);

        client.passercommande();
        client.afficherhistorique();
        // Vérification visuelle (peut être vérifiée en mockant les outputs)
    }

    @Test
    public void testPayer() {
        client.payer(100.0f);
    }

    @Test
    public void testDemanderAfficherProduits() throws Exception {
        marchand.ajouterProduit("Produit6", 40.0f, 5);
        client.demanderafficherproduits(marchand);
    }

    @Test
    public void testGetValeurPanier() throws Exception {
        marchand.ajouterProduit("Produit7", 50.0f, 10);
        client.ajouterProduitPanier(marchand, "Produit7", 2);

        float valeurPanier = client.getvaleurPanier();
        assertEquals("La valeur totale du panier devrait être correcte", 100.0f, valeurPanier, 0.01);
    }
}
