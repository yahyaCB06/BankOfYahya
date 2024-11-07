package com.bankofhassan;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompteTest {

    private Client client;
    private Compte compte;
    private Banque banque;

    @BeforeEach
    public void setUp() {
        client = new Client("C001", "John", "Doe", "123 Main St", "555-1234", "john.doe@email.com");
        banque = new Banque("B001", "Morocco");
        compte = new Compte(banque, client, new Date(), new Date(), "MAD", "12345");
    }

    @Test
    public void testAddTransaction() {
        Transaction transaction = new Transaction(client.getComptes(), compte, "TX123", new Date(), false);
        compte.ajoutetransaction(transaction);
        assertTrue(compte.getTransactions().contains(transaction), "Transaction should be added to compte");
    }

    @Test
    public void testAjoutTransaction() {
        Transaction transaction = new Transaction(client.getComptes(), compte, "TX123", new Date(), false);
        compte.ajoutetransaction(transaction);
        assertEquals(1, compte.getTransactions().size(), "There should be one transaction");

        // Try adding the same transaction again
        compte.ajoutetransaction(transaction);
        assertEquals(1, compte.getTransactions().size(), "There should still be only one transaction");
    }

    @Test
    public void testRechercheTransactionExist() {
        Transaction transaction = new Transaction(client.getComptes(), compte, "TX123", new Date(), false);
        compte.addTransaction(transaction);
        assertTrue(compte.recherchetransaction(transaction), "Transaction should exist");
    }

    @Test
    public void testToJson() {
        String json = compte.toJson();
        assertTrue(json.contains("\"numCompte\": \"12345\""), "JSON should contain account number");
    }
}
