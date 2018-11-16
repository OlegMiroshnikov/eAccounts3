package lv.javaguru.java3.eaccounts3.domain;

import lv.javaguru.java3.eaccounts3.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
//public class Company extends Auditable<String> {
    public class Company extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "reg_nr", nullable = false, unique = true)
    private String regNr;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "e_mail", nullable = true)
    private String eMail;

    @Column(name = "path_from_accounts", nullable = false)
    private String pathFromAccounts;

    @Column(name = "path_to_accounts", nullable = false)
    private String pathToAccounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPathFromAccounts() {
        return pathFromAccounts;
    }

    public void setPathFromAccounts(String pathFromAccounts) {
        this.pathFromAccounts = pathFromAccounts;
    }

    public String getPathToAccounts() {
        return pathToAccounts;
    }

    public void setPathToAccounts(String pathToAccounts) {
        this.pathToAccounts = pathToAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != null ? !id.equals(company.id) : company.id != null) return false;
        if (regNr != null ? !regNr.equals(company.regNr) : company.regNr != null) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (address != null ? !address.equals(company.address) : company.address != null) return false;
        if (eMail != null ? !eMail.equals(company.eMail) : company.eMail != null) return false;
        if (pathFromAccounts != null ? !pathFromAccounts.equals(company.pathFromAccounts) : company.pathFromAccounts != null)
            return false;
        return pathToAccounts != null ? pathToAccounts.equals(company.pathToAccounts) : company.pathToAccounts == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (regNr != null ? regNr.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (pathFromAccounts != null ? pathFromAccounts.hashCode() : 0);
        result = 31 * result + (pathToAccounts != null ? pathToAccounts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", regNr='" + regNr + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", eMail='" + eMail + '\'' +
                ", pathFromAccounts='" + pathFromAccounts + '\'' +
                ", pathToAccounts='" + pathToAccounts + '\'' +
                '}';
    }
}
