package lv.javaguru.java3.eaccounts3.repository;

import lv.javaguru.java3.eaccounts3.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

//    @Query("select c from Client c where c.personalCode = :personalCode")
//    Optional<Client> findByPersonalCode(@Param("personalCode") String personalCode);

    Optional<Client> findByPersonalCode(String personalCode);

}
