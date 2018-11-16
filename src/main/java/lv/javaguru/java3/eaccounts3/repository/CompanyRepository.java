package lv.javaguru.java3.eaccounts3.repository;

import lv.javaguru.java3.eaccounts3.domain.Company;
import org.hibernate.dialect.function.AnsiTrimEmulationFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

//    @Query("select c from Company c where c.regNr = :regNr")
//    Optional<Company> findByRegNr(@Param("regNr") String regNr);

    Optional<Company> findByRegNr(String regNr);
}
