package lv.javaguru.java3.eaccounts3.services.contract;

import lv.javaguru.java3.eaccounts3.domain.Client;
import lv.javaguru.java3.eaccounts3.domain.Company;
import lv.javaguru.java3.eaccounts3.domain.Contract;
import lv.javaguru.java3.eaccounts3.repository.ContractRepository;
import lv.javaguru.java3.eaccounts3.services.client.ClientService;
import lv.javaguru.java3.eaccounts3.services.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CompanyService companyService;

    @Override
    public Contract addContract(Contract contract) {
        return contractRepository.saveAndFlush(contract);
    }

    @Override
    public Contract updateContract(Contract contract) {
        return contractRepository.saveAndFlush(contract);
    }

    @Override
    public void removeContract(Contract contract) {
        contractRepository.delete(contract);
    }

    @Override
    public Optional<Contract> getContractById(Long id) {
        return contractRepository.findById(id);
    }

    @Override
    public Optional<Contract> getContractByCompanyIdAndClientId(Long companyId, Long clientId) {
        return contractRepository.findByCompanyIdAndClientId(companyId, clientId);
    }

    @Override
    public List<Contract> getContractList() {
        return contractRepository.findAll();
    }

    @Override
    public List<Contract> getContractListByClientId(Long clientId) {
        return contractRepository.findAllByClientId(clientId);
    }

    @Override
    public List<Contract> getContractListByCompanyId(Long companyId) {
        return contractRepository.findAllByCompanyId(companyId);
    }

    @Override
    public List<Company> getCompanyListByClientId(Long clientId) {
        List<Contract> contracts = contractRepository.findAllByClientId(clientId);
        List<Company> companies = new ArrayList<>();
        for (Contract contract : contracts) {
            if (companyService.getCompanyById(contract.getCompanyId()).isPresent()) {
                companies.add(companyService.getCompanyById(contract.getCompanyId()).get());
            }
        }
        return companies;
    }

    @Override
    public List<Client> getClientListByCompanyId(Long companyId) {
        List<Contract> contracts = contractRepository.findAllByCompanyId(companyId);
        List<Client> clients = new ArrayList<>();
        for (Contract contract : contracts) {
//            Optional<Client> optionalClient = clientService.getClientById(contract.getClientId());
//            if (optionalClient.isPresent()) {
//                clients.add(optionalClient.get());
            Client client = clientService.getClientById(contract.getClientId());
            if (client != null) {
                clients.add(client);
            }
//            if (clientService.getClientById(contract.getClientId()).isPresent()) {
//                clients.add(clientService.getClientById(contract.getClientId()).get());
//            }
        }
        return clients;
    }
}