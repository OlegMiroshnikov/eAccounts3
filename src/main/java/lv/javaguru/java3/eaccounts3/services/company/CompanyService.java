package lv.javaguru.java3.eaccounts3.services.company;

import lv.javaguru.java3.eaccounts3.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    Company addCompany(Company company);

    Company updateCompany(Company company);

    void removeCompany(Company company);

    Optional<Company> getCompanyById(Long id);

    Optional<Company> getCompanyByRegNr(String regNr);

    List<Company> getCompanyList();
}
