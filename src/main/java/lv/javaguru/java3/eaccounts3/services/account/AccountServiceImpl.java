package lv.javaguru.java3.eaccounts3.services.account;

import lv.javaguru.java3.eaccounts3.domain.Account;
import lv.javaguru.java3.eaccounts3.domain.Company;
import lv.javaguru.java3.eaccounts3.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    public void removeAccount(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Company> getCompanyByContractId(Long contractId) {
        return accountRepository.findCompanyByContractId(contractId);
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountListByContractId(Long contractId) {
        return accountRepository.findAllByContractId(contractId);
    }
}
