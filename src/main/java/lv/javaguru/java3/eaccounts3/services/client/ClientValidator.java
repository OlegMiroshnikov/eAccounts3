package lv.javaguru.java3.eaccounts3.services.client;

import lv.javaguru.java3.eaccounts3.domain.Client;
import lv.javaguru.java3.eaccounts3.domain.Contract;
import lv.javaguru.java3.eaccounts3.repository.ClientRepository;
import lv.javaguru.java3.eaccounts3.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Component
public class ClientValidator {

    @Autowired
    private ContractRepository contractRepository;

    private ClientRepository clientRepository;

    public void validateClient(Client client) {
        validateClientIsNulle(client);
        validatePersonalCode(client.getPersonalCode());
        validateName(client.getName());
        validateEMail(client.geteMail());
        validateDuplicatePersonalCode(client.getPersonalCode());
    }

    public void validateRemovedClient(Long id) {
        validateIsExistClientById(id);
        validateIsExistAnyContractByClientId(id);
    }

    private void validateClientIsNulle(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client must not be null");
        }
    }

    private void validatePersonalCode(String personalCode) {
        if (personalCode == null) {
            throw new IllegalArgumentException("Client personal code must not be null");
        }
        if (StringUtils.isEmpty(personalCode)) {
            throw new IllegalArgumentException("Client personal code must not be empty");
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Client name must not be null");
        }
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Client name must not be empty");
        }
    }

    private void validateEMail(String eMail) {
        if (eMail == null) {
            throw new IllegalArgumentException("Client eMail must not be null");
        }
        if (StringUtils.isEmpty(eMail)) {
            throw new IllegalArgumentException("Client eMail must not be empty");
        }
    }

    private void validateDuplicatePersonalCode(String personalCode) {
        if (personalCode != null && !personalCode.trim().isEmpty()) {
            Optional<Client> client = clientRepository.findByPersonalCode(personalCode);
            if (client.isPresent()) {
                throw new IllegalArgumentException("There are also client with same personal code");
            }
        }
    }

    private void validateIsExistClientById(Long id) {
        if (id != null) {
            Optional<Client> client = clientRepository.findById(id);
            if (!client.isPresent()) {
                throw new IllegalArgumentException("Client by id is not exist");
            }
        }
    }

    private void validateIsExistAnyContractByClientId(Long id) {
        if (id != null) {
            List<Contract> contracts = contractRepository.findAllByClientId(id);
            if (contracts.size() != 0) {
                throw new IllegalArgumentException("There are also contracts with this client");
            }
        }
    }

}
