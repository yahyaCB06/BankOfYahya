package com.bankofhassan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class Compte {
    @Expose
    private String numCompte;
    @Expose
    private Date dateCreation;
    @Expose
    private Date dateUpdate;
    @Expose
    private String devise;
    @Expose
    private Client client;
    
    private final List<Transaction> transactions=new ArrayList<>();

    private Banque banque;

    public Compte(Banque banque, Client client, Date dateCreation, Date dateUpdate, String devise, String numCompte) {
        this.banque = banque;
        this.client = client;
        this.dateCreation = dateCreation;
        this.dateUpdate=dateUpdate;
        this.devise = devise;
        this.numCompte = numCompte;
    }

    public String getNumCompte() {
        return numCompte;
    }
    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public Date getDateUpdate() {
        return dateUpdate;
    }
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Compte() {
    }


    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }
    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }
    public List<Transaction> getTransactions(){
        return this.transactions;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }
    public void ajoutetransaction(Transaction transaction){
        int i=0;
        for(Transaction tr:transactions){
            if(tr.getReference().equals(transaction.getReference())){
                i=1;
                    
            }
        }
        if(i==0){
            transactions.add(transaction);
        }
}
public boolean recherchetransaction(Transaction transaction){
    boolean i=false;
    for(Transaction tr:transactions){
        if(tr.getReference().equals(transaction.getReference())){
            i=true;

        }
        
}
return i;

}
public String toJson() {
       Gson gson = new GsonBuilder()
               .setPrettyPrinting()
               .excludeFieldsWithoutExposeAnnotation()
               .create();
       return gson.toJson(this);}

    
}
