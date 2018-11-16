package lv.javaguru.java3.eaccounts3.domain.builder;

import lv.javaguru.java3.eaccounts3.domain.Client;

public class ClientBuilder {

    private Long id;
    private String personalCode;
    private String name;
    private String address;
    private String eMail;
    private Long version;

    private ClientBuilder() {
    }

    public static ClientBuilder createClient() {
        return new ClientBuilder();
    }

    public Client build() {
        Client client = new Client();
        client.setId(id);
        client.setPersonalCode(personalCode);
        client.setName(name);
        client.setAddress(address);
        client.seteMail(eMail);
        client.setVersion(version);
        return client;
    }

    public ClientBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientBuilder withPersonalCode(String personalCode) {
        this.personalCode = personalCode;
        return this;
    }

    public ClientBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientBuilder withEMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public ClientBuilder withVersion(Long version) {
        this.version = version;
        return this;
    }
}