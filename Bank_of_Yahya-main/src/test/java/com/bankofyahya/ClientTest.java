package com.bankofhassan;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {

    private Client client;
    private Compte compte;

    @BeforeEach
    public void setUp() {
        client = new Client("C001", "John", "Doe", "123 Main St", "555-1234", "john.doe@email.com");
        compte=new Compte(new Banque("B001", "Morocco"), client, new Date(), new Date(), "MAD", "Com001");
    }

    @Test
    public void testAddCompte() {
        client.addCompte(compte);
        assertTrue(client.getComptes().contains(compte), "Compte should be added to client");
    }

    @Test
    public void testCreateCompte() {
        Compte newCompte = new Compte(new Banque("B001", "Morocco"), client, new Date(), new Date(), "USD", "67890");
        client.createcompte(newCompte);
        assertTrue(client.getComptes().contains(newCompte), "Compte should be created and added");
    }

    @Test
    public void testRecherchecompteExist() {
        client.addCompte(compte);
        assertTrue(client.recherchecompte(compte), "Compte should exist");
    }

    @Test
    public void testRecherchecompteNonExist() {
        assertFalse(client.recherchecompte(compte), "Compte should not exist");
    }

    @Test
    public void testToJson() {
        String json = client.toJson();
        assertTrue(json.contains("\"numClient\": \"C001\""), "JSON should contain client number");
    }
}
