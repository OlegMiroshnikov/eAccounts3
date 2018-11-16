package lv.javaguru.java3.eaccounts3.services.company;

import lv.javaguru.java3.eaccounts3.domain.Company;
import lv.javaguru.java3.eaccounts3.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company addCompany(Company company) {
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public Company updateCompany(Company company) {
         return companyRepository.saveAndFlush(company);
    }

    @Override
    public void removeCompany(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Optional<Company> getCompanyByRegNr(String regNr) {
        return companyRepository.findByRegNr(regNr);
    }

    @Override
    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }
}
