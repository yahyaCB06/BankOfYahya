package com.bankofhassan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
public class Transaction {
    
    public enum transtype{VIRIN,VIREST,VIRCHAC,VIRMULTA};
    @Expose
    private transtype type;
    @Expose
    private Date timeStamp;
    @Expose
    private String reference;
    
    private Compte emetteur;
    private List<Compte> benificiaires=new ArrayList<>();
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Compte getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Compte emetteur) {
        this.emetteur = emetteur;
    }

    public List<Compte> getBenificiaires() {
        return benificiaires;
    }

    public void setBenificiaires(List<Compte> benificiaires) {
        this.benificiaires = benificiaires;
    }
    public Transaction(List<Compte> benificiaires, Compte emetteur, String reference, Date timeStamp, boolean isCheque) {
        this.benificiaires = benificiaires;
        this.emetteur = emetteur;
        this.reference = reference;
        this.timeStamp = timeStamp;
        if (isCheque) {
            this.type = transtype.VIRCHAC;
        } else {
            if (this.benificiaires.size() == 1) {
                // Check if the account from which money is sent (emetteur) and the beneficiary account are from the same bank
                if ((this.emetteur.getBanque().getId()).equals(this.benificiaires.get(0).getBanque().getId()) &&
                    (this.emetteur.getBanque().getPays()).equals(this.benificiaires.get(0).getBanque().getPays())) {
                    this.type = transtype.VIRIN;
                } else {
                    this.type = transtype.VIREST;
                }
            }
            if (this.benificiaires.size() > 1) {
                this.type = transtype.VIRMULTA;
            }
        }
    }

    public transtype getType() {
        return type;
    }
    public String toJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);}
    

}
