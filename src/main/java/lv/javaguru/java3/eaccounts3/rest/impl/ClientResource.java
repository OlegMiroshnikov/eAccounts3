package lv.javaguru.java3.eaccounts3.rest.impl;

import lv.javaguru.java3.eaccounts3.command.client.ClientConverter;
import lv.javaguru.java3.eaccounts3.command.client.ClientDTOConverter;
import lv.javaguru.java3.eaccounts3.domain.Client;
import lv.javaguru.java3.eaccounts3.rest.dto.ClientDTO;
import lv.javaguru.java3.eaccounts3.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
//@RequestMapping(value = "/api")
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
@PreAuthorize("hasRole('ROLE_USER')")
public class ClientResource {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConverter clientConverter;
    @Autowired
    private ClientDTOConverter clientDTOConverter;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        System.out.println("HELLO!!!");
        return new ResponseEntity<>("Hello ", HttpStatus.OK);
    }

    @GetMapping("/hello/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> helloAdmin() {
        System.out.println("HELLO ADMIN!!!");
        return new ResponseEntity<>("Hello ADMIN", HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        System.out.println("LOGOUT");
        return new ResponseEntity<>("Logout", HttpStatus.OK);
    }

    @PostMapping(value = "/clients")
    public ClientDTO create(@RequestBody ClientDTO clientDTO) {
        Client client = clientDTOConverter.convert(clientDTO);
        return clientConverter.convert(clientService.addClient(client));
    }

    @PutMapping("/clients/{id}")
    public ClientDTO update(@RequestBody ClientDTO clientDTO, @PathVariable Long id) {
        Client client = clientDTOConverter.convert(clientDTO);
        return clientConverter.convert(clientService.updateClient(client, id));
    }

    @DeleteMapping("/clients/{id}")
    public void remove(@PathVariable Long id) {
        clientService.removeClient(id);
    }

    @GetMapping("/clients")
    public List<Client> getAll() {
        return clientService.getClientList();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO get(@PathVariable Long id) {
        return clientConverter.convert(clientService.getClientById(id));
    }

    @GetMapping("/clients/{personalCode}")
    public ClientDTO getClientByPersonalCode(@PathVariable String personalCode) {
        return clientConverter.convert(clientService.getClientByPersonalCode(personalCode));
    }

}


