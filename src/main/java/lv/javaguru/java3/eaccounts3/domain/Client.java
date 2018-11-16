package lv.javaguru.java3.eaccounts3.domain;

import lv.javaguru.java3.eaccounts3.audit.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "Client")
//public class Client extends Auditable<String> {
    public class Client extends Auditable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="personal_code", nullable = false, unique = true)
    private String personalCode;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address", nullable = true)
    private String address;

    @Column(name="e_mail", nullable = false)
    private String eMail;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (personalCode != null ? !personalCode.equals(client.personalCode) : client.personalCode != null)
            return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        return eMail != null ? eMail.equals(client.eMail) : client.eMail == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personalCode != null ? personalCode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", personalCode='" + personalCode + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
