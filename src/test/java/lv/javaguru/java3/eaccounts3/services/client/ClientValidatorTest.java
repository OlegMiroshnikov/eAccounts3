package lv.javaguru.java3.eaccounts3.services.client;

import lv.javaguru.java3.eaccounts3.domain.Client;
import lv.javaguru.java3.eaccounts3.domain.Contract;
import lv.javaguru.java3.eaccounts3.domain.builder.ClientBuilder;

import lv.javaguru.java3.eaccounts3.repository.ClientRepository;
import lv.javaguru.java3.eaccounts3.repository.ContractRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class ClientValidatorTest {

    @Mock
    private ContractRepository contractRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientValidator validator = new ClientValidator();

    private Client client;

    @Before
    public void init() {
        client = ClientBuilder.createClient()
                .withId(1L)
                .withPersonalCode("personalCode")
                .withName("name")
                .withAddress("address")
                .withEMail("eMail")
                .build();
        Mockito.when(clientRepository.findById(1L))
                .thenReturn(Optional.of(client));
    }

    @Test
    public void validateClient_clientIsNull_isFail() {
        client = null;
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("Client must not be null");
    }

//    @Test
//    public void validateClient_iDIsNull_isFail() {
//        client.setId(null);
//        Throwable thrown = catchThrowable(() -> {
//            validator.validateClient(client);
//        });
//        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
//        assertThat(thrown.getMessage()).isEqualTo("Client id must not be null");
//    }

    @Test
    public void validateClient_personalCodeIsNull_isFail() {
        client.setPersonalCode(null);
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("Client personal code must not be null");
    }

    @Test
    public void validateClient_personalCodeIsEmpty_isFail() {
        client.setPersonalCode("");
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("Client personal code must not be empty");
    }

    @Test
    public void validateClient_nameIsNull_isFail() {
        client.setName(null);
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("Client name must not be null");
    }

    @Test
    public void validateClient_nameIsEmpty_isFail() {
        client.setName("");
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("Client name must not be empty");
    }

    @Test
    public void validateClient_eMailIsNull_isFail() {
        client.seteMail(null);
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("Client eMail must not be null");
    }

    @Test
    public void validateClient_eMailIsEmpty_isFail() {
        client.seteMail("");
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("Client eMail must not be empty");
    }

    @Test
    public void validateClient_OK() {
        Mockito.when(clientRepository.findByPersonalCode("personalCode"))
                .thenReturn(Optional.empty());
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isNull();;
    }

    @Test
    public void validateClient_duplicatePersonalCode_isFail() {
        Client foundClient = ClientBuilder.createClient()
                .withId(2L)
                .withPersonalCode("personalCode")
                .withName("name")
                .withAddress("address")
                .withEMail("eMail")
                .build();
        Mockito.when(clientRepository.findByPersonalCode("personalCode"))
                .thenReturn(Optional.of(foundClient));
        Throwable thrown = catchThrowable(() -> {
            validator.validateClient(client);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("There are also client with same personal code");
    }

    @Test
    public void validateRemovedClient_OK() {
        List<Contract> contracts = new ArrayList();
        Mockito.when(contractRepository.findAllByClientId(1L))
                .thenReturn(contracts);
        Throwable thrown = catchThrowable(() -> {
            validator.validateRemovedClient(1L);
        });
        assertThat(thrown).isNull();;
    }

    @Test
    public void validateRemovedClient_notExistClientById_isFail() {
        Mockito.when(clientRepository.findById(1L))
                .thenReturn(Optional.empty());
        Throwable thrown = catchThrowable(() -> {
            validator.validateRemovedClient(1L);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("Client by id is not exist");
    }

    @Test
    public void validateRemoveClient_isExistAnyContractsByClientId_isFail() {
        List<Contract> contracts = new ArrayList();
        contracts.add(new Contract());
        Mockito.when(contractRepository.findAllByClientId(1L))
                .thenReturn(contracts);
        Throwable thrown = catchThrowable(() -> {
            validator.validateRemovedClient(1L);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isEqualTo("There are also contracts with this client");
    }

}