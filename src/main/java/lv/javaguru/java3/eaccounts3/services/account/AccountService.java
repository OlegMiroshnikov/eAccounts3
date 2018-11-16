package lv.javaguru.java3.eaccounts3.services.account;

import lv.javaguru.java3.eaccounts3.domain.Account;
import lv.javaguru.java3.eaccounts3.domain.Company;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account addAccount(Account account);

    Account updateAccount(Account account);

    void removeAccount(Account account);

    Optional<Account> getAccountById(Long id);

    Optional<Company> getCompanyByContractId(Long id);

    List<Account> getAccountList();

    List<Account> getAccountListByContractId(Long contractId);
}
