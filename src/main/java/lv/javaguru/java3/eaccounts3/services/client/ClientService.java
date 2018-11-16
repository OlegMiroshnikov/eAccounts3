package lv.javaguru.java3.eaccounts3.services.client;

import lv.javaguru.java3.eaccounts3.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client addClient(Client client);

    Client updateClient(Client client, Long id);

    void removeClient(Long id);

    Client getClientById(Long id);

    Client getClientByPersonalCode(String personalCode);

    List<Client> getClientList();
}
