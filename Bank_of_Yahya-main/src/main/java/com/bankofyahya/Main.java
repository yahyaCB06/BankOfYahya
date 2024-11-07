package com.bankofhassan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Création des clients
        Client client1 = new Client("C001", "John", "Doe", "123 Main St", "555-1234", "john.doe@email.com");
        Client client2 = new Client("C002", "Matt", "Brian", "456 Oak St", "555-5678", "matt.brian@email.com");

        // Création de la banque
        Banque banque = new Banque("B001", "Morocco");

        // Création des comptes pour les clients
        Compte compte1 = new Compte(banque, client1, new Date(), new Date(), "MAD", "Com001");
        Compte compte2 = new Compte(banque, client2, new Date(), new Date(), "MAD", "Com002");

        // Ajout des comptes à la banque
        banque.ajoutComptes(compte1);
        banque.ajoutComptes(compte2);

        // Ajout des comptes aux clients
        client1.addCompte(compte1);
        client2.addCompte(compte2);

        // Affichage des informations des clients et de leurs comptes
        System.out.println("Client 1: " + client1.getNom() + " " + client1.getPrenom());
        System.out.println("Compte 1: Numéro " + compte1.getNumCompte() + ", Devise: " + compte1.getDevise());
        System.out.println("Client 2: " + client2.getNom() + " " + client2.getPrenom());
        System.out.println("Compte 2: Numéro " + compte2.getNumCompte() + ", Devise: " + compte2.getDevise());

        // Création d'une transaction (VIRIN: même banque)
        List<Compte> beneficiiaires = new ArrayList<>();
        beneficiiaires.add(compte2);  // Le bénéficiaire est compte2
        Transaction transaction1 = new Transaction(beneficiiaires, compte1, "TX123", new Date(), false);

        // Affichage des informations de la transaction
        System.out.println("\nTransaction 1:");
        System.out.println("Référence: " + transaction1.getReference());
        System.out.println("Type de transaction: " + transaction1.getType());
        System.out.println("Timestamp: " + transaction1.getTimeStamp());

        // Création d'une transaction (VIREST: banques différentes)
        Banque banque2 = new Banque("B002", "France");
        Compte compte3 = new Compte(banque2, client2, new Date(), new Date(), "EUR", "Com003");
        client2.addCompte(compte3);

        beneficiiaires.clear();  // Clear the list for a new transaction
        beneficiiaires.add(compte3);  // Le bénéficiaire est maintenant un compte dans une autre banque
        Transaction transaction2 = new Transaction(beneficiiaires, compte1, "TX124", new Date(), false);

        // Affichage des informations de la nouvelle transaction
        System.out.println("\nTransaction 2:");
        System.out.println("Référence: " + transaction2.getReference());
        System.out.println("Type de transaction: " + transaction2.getType());
        System.out.println("Timestamp: " + transaction2.getTimeStamp());
    }
}
