package com.bankofhassan;
import java.util.ArrayList;
import java.util.List;
public class ClientManage {
    private final List<Client> clients=new ArrayList<>();
    private final List<Compte> comptes=new ArrayList<>();
public void ajoutClient(Client client){
    if (!rechercheclient(client)){
        clients.add(client);
    }
}
public void ajoutCompte(Compte c){
    if (!rechercheCompte(c)){
        comptes.add(c);
    }
}

public boolean rechercheclient(Client client){
    boolean i=false;
    for(Client c:clients){
        if(c.getNumClient().equals(client.getNumClient())){
            i=true;
            break;
        }
    }
    return i;     
}
public boolean rechercheCompte(Compte compte){
    boolean i=false;
    for(Compte c:comptes){
        if(c.getNumCompte().equals(compte.getNumCompte())){
            i=true;
            break;
        }
    }
    return i;     
}

}
 