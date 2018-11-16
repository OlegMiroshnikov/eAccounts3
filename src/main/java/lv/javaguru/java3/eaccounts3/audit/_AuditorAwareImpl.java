package lv.javaguru.java3.eaccounts3.audit;

//import org.springframework.data.domain.AuditorAware;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Optional;
//
//class AuditorAwareImpl implements AuditorAware<String> {
//
//    @Override
//    public Optional<String> getCurrentAuditor() {
//        return Optional.of(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
//    }
//}