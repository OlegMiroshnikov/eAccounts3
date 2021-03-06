package lv.javaguru.java3.eaccounts3.command.client;

import lv.javaguru.java3.eaccounts3.domain.Client;
import lv.javaguru.java3.eaccounts3.rest.dto.ClientDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.eaccounts3.rest.dto.builder.ClientDTOBuilder.createClientDTO;

@Component
public class ClientConverter {
    public ClientDTO convert(Client client) {
        return createClientDTO()
                .withId(client.getId())
                .withPersonalCode(client.getPersonalCode())
                .withName(client.getName())
                .withAddress(client.getAddress())
                .withEMail(client.geteMail())
                .withVersion(client.getVersion())
                .build();
    }
}
