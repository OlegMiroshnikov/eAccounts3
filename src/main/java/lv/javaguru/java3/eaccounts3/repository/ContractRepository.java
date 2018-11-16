package lv.javaguru.java3.eaccounts3.repository;

import lv.javaguru.java3.eaccounts3.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

//    @Query("select c from Contract c where c.clientId = :clientId")
//    List<Contract> findAllByClientId(@Param("clientId") Integer clientId);
//
//    @Query("select c from Contract c where c.companyId = :companyId")
//    List<Contract> findAllByCompanyId(@Param("companyId") Integer companyId);
//
//    @Query("select c from Contract c where c.companyId = :companyId and c.clientId = :clientId")
//    Optional<Contract> findByCompanyIdAndClientId(@Param("companyId") Integer companyId,
//                                                  @Param("clientId") Integer clientId);

    List<Contract> findAllByClientId(Long clientId);

    List<Contract> findAllByCompanyId(Long companyId);

    Optional<Contract> findByCompanyIdAndClientId(Long companyId, Long clientId);


}
