package lv.javaguru.java3.eaccounts3.domain.builder;

import lv.javaguru.java3.eaccounts3.domain.Company;

public class CompanyBuilder {

    private Long id;
    private String regNr;
    private String name;
    private String address;
    private String eMail;
    private String pathFromAccounts;
    private String pathToAccounts;

    private CompanyBuilder() {
    }

    public static CompanyBuilder createCompany() {
        return new CompanyBuilder();
    }

    public Company build() {
        Company company = new Company();
        company.setId(id);
        company.setRegNr(regNr);
        company.setName(name);
        company.setAddress(address);
        company.seteMail(eMail);
        company.setPathFromAccounts(pathFromAccounts);
        company.setPathToAccounts(pathToAccounts);
        return company;
    }

    public CompanyBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CompanyBuilder withRegNr(String regNr) {
        this.regNr = regNr;
        return this;
    }

    public CompanyBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CompanyBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyBuilder withEMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public CompanyBuilder withPathFromAccounts(String pathFromAccounts) {
        this.pathFromAccounts = pathFromAccounts;
        return this;
    }

    public CompanyBuilder withPathToAccounts(String pathToAccounts) {
        this.pathToAccounts = pathToAccounts;
        return this;
    }

}
