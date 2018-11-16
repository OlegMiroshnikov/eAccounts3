package lv.javaguru.java3.eaccounts3.repository;

import lv.javaguru.java3.eaccounts3.domain.Account;
import lv.javaguru.java3.eaccounts3.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

//    @Query("select a from Account a where a.contractId = :contractId")
//    List<Account> findAllByContractId(@Param("contractId") Integer contractId);
    List<Account> findAllByContractId(Long contractId);

//    String sql = "select * from COMPANIES where id = (select companyId from CONTRACTS where id = :id)";

    @Query("select c from Company c where c.id = (select c.companyId from Contract c where c.id = ?1)")
    Optional<Company> findCompanyByContractId(Long contractId);


}
