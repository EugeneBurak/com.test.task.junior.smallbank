package com.test.task.junior.smallbank.services.impl;

import com.test.task.junior.smallbank.entity.Client;
import com.test.task.junior.smallbank.repository.ClientRepository;
import com.test.task.junior.smallbank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        Client savedClient = clientRepository.saveAndFlush(client);
        return savedClient;
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.delete(id);
    }

    @Override
    public Client getClientById(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client editClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
