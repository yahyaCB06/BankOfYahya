package com.bankofhassan;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class Client {
    @Expose
    private String numClient;
    @Expose
    private String nom;
    @Expose
    private String prenom;
    @Expose
    private String adresse;
    @Expose
    private String phone;
    @Expose
    private String email;
    
    private final List<Compte> comptes=new ArrayList<>();
    public String getNumClient() {
        return numClient;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public List<Compte> getComptes() {
        return comptes;
    }
    public Client(String numClient, String nom, String prenom, String adresse, String phone, String email) {
        this.numClient = numClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;
    }
    public void setNumClient(String numClient) {
        this.numClient = numClient;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void addCompte(Compte c){
        this.comptes.add(c);
    }
    public void createcompte(Compte compte){
        int i=0;
        for(Compte com:comptes){
            if(com.getNumCompte().equals(compte.getNumCompte())){
                i=1;


            }

            
            
        }
        if(i==0){
            comptes.add(compte);
        }
    }
    public boolean recherchecompte(Compte compte){
        boolean i=false;
        for(Compte com:comptes){
            if(com.getNumCompte().equals(compte.getNumCompte())){
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
