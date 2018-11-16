package lv.javaguru.java3.eaccounts3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCrypt;

//@EnableJpaAuditing
@SpringBootApplication
public class EAaccounts3Application {

    public static void main(String[] args) {
        SpringApplication.run(EAaccounts3Application.class, args);
    }
}
