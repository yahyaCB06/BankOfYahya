package com.bankofhassan;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
public class Banque {
    @Expose
    private String id;
    @Expose
    private String pays;
    @Expose
    private final List<Compte> comptes=new ArrayList<>();

    public Banque(String id, String pays) {
        this.id = id;
        this.pays = pays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void ajoutComptes(Compte c) {
        this.comptes.add(c);
    }
    public String toJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);}
    }
