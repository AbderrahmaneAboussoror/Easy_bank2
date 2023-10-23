package com.AboussororAbderrahmane.app.services;


import com.AboussororAbderrahmane.app.daoImplementaion.ClientDAOImp;
import com.AboussororAbderrahmane.app.entities.Client;

import java.util.Collections;
import java.util.List;

public class ClientService {

    private final ClientDAOImp clientDAOImp;

    public ClientService(ClientDAOImp instance) {
        clientDAOImp = instance;
    }

    public Client save(Client client) {

        return clientDAOImp.save(client).orElse(null);

    }

    public  boolean delete(String code) {

        return clientDAOImp.delete(code);
    }

    public List<Client> findAll() {

        return clientDAOImp.findAll().orElse(Collections.emptyList());

    }

    public  Client findByCode(String code) {

        return clientDAOImp.findByCode(code).orElse(null);
    }

    public  Client findByAddress(String address) {

        return clientDAOImp.findByAddress(address).orElse(null);
    }

    public  boolean update(Client client) {

        return clientDAOImp.update(client);
    }

}
