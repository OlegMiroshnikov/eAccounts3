package lv.javaguru.java3.eaccounts3.rest.dto.builder;

import lv.javaguru.java3.eaccounts3.rest.dto.ClientDTO;

public class ClientDTOBuilder {

    private Long id;
    private String personalCode;
    private String name;
    private String address;
    private String eMail;
    private Long version;

    private ClientDTOBuilder() {
    }

    public static ClientDTOBuilder createClientDTO() {
        return new ClientDTOBuilder();
    }

    public ClientDTO build() {
        ClientDTO client = new ClientDTO();
        client.setId(id);
        client.setPersonalCode(personalCode);
        client.setName(name);
        client.setAddress(address);
        client.seteMail(eMail);
        client.setVersion(version);
        return client;
    }

    public ClientDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientDTOBuilder withPersonalCode(String personalCode) {
        this.personalCode = personalCode;
        return this;
    }

    public ClientDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ClientDTOBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientDTOBuilder withEMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public ClientDTOBuilder withVersion(Long version) {
        this.version = version;
        return this;
    }

}
