package com.bankofhassan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    private Transaction transaction;
    private Compte compte1,compte2;
    private Client client1,client2;
    List<Compte> benificiaires=new ArrayList<>();

    @BeforeEach
    public void setUp() {
        client1 = new Client("C001", "John", "Doe", "123 Main St", "555-1234", "john.doe@email.com");
        compte1 = new Compte(new Banque("B001", "Morocco"), client1, new Date(), new Date(), "MAD", "Com001");
        client1.addCompte(compte1);
        client2 = new Client("C002", "matt", "brian", "123 Main St", "555-1234", "brian.matt@email.com");
        compte2 = new Compte(new Banque("B001", "Morocco"), client2, new Date(), new Date(), "MAD", "Com002");
        client2.addCompte(compte2);
        benificiaires.add(compte2);

        benificiaires.add(compte1);
        transaction = new Transaction(benificiaires, compte2, "TX123", new Date(), false);
    }

    @Test
    public void testTransactionType() {
        assertEquals(Transaction.transtype.VIRMULTA, transaction.getType(), "Transaction type should be VIRIN");
    }

    @Test
    public void testToJson() {
        String json = transaction.toJson();
        assertTrue(json.contains("\"reference\": \"TX123\""), "JSON should contain transaction reference");
    }
}
