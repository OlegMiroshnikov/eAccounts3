package lv.javaguru.java3.eaccounts3.services.client;

import lv.javaguru.java3.eaccounts3.domain.Client;
import lv.javaguru.java3.eaccounts3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientValidator clientValidator;

    @Override
    @Transactional
    public Client addClient(Client client) {
        clientValidator.validateClient(client);
        return clientRepository.saveAndFlush(client);
    }

    @Override
    @Transactional
    public Client updateClient(Client client, Long id) {
        clientValidator.validateClient(client);
//        Client original = clientRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException("Client by id could not found (id = " + id + ")"));
        Client original = getClientById(id);
        client.setId(id);
        return clientRepository.saveAndFlush(client);
    }

    @Override
    @Transactional
    public void removeClient(Long id) {
        clientValidator.validateRemovedClient(id);
        clientRepository.deleteById(id);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Client by id is not exist"));
    }

    @Override
    public Client getClientByPersonalCode(String personalCode) {
        return clientRepository.findByPersonalCode(personalCode).orElseThrow(() ->
                new IllegalArgumentException("Client by personal is not exist"));
    }

    @Override
    public List<Client> getClientList() {
        return clientRepository.findAll();
    }

}
