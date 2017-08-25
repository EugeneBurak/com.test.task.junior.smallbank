package com.test.task.junior.smallbank.services;

import com.test.task.junior.smallbank.entity.Client;
import java.util.List;

public interface ClientService {
    Client addClient(Client client);
    void deleteClient(int id);
    Client getClientById(int id);
    Client editClient(Client client);
    List<Client> getAllClients();

}
