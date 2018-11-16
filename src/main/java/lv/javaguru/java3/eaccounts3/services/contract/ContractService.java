package lv.javaguru.java3.eaccounts3.services.contract;

import lv.javaguru.java3.eaccounts3.domain.Client;
import lv.javaguru.java3.eaccounts3.domain.Company;
import lv.javaguru.java3.eaccounts3.domain.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    Contract addContract(Contract contract);

    Contract updateContract(Contract contract);

    void removeContract(Contract contract);

    Optional<Contract> getContractById(Long id);

    Optional<Contract> getContractByCompanyIdAndClientId(Long companyId, Long clientId);

    List<Contract> getContractList();

    List<Contract> getContractListByClientId(Long clientId);

    List<Contract> getContractListByCompanyId(Long companyId);

    List<Company> getCompanyListByClientId(Long clientId);

    List<Client> getClientListByCompanyId(Long companyId);
}
