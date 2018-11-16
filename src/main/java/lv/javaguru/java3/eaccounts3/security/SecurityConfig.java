package lv.javaguru.java3.eaccounts3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.
//                inMemoryAuthentication()
//                .withUser("user").password("{noop}user").roles("USER").and()
//                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("$2a$04$YdAltVPPLw7VzpR53D3xXuFd6Zwce6P7hO.VZWwNFabjL9bOBaHF2").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("$2a$04$TdxUIfbqp.Bx1IHmfk6MC.cZtnjhHyyT1SRcQ5eJ2sfZMtDBZ/GOC").roles("USER", "ADMIN").build());
//        password = user = $2a$04$YdAltVPPLw7VzpR53D3xXuFd6Zwce6P7hO.VZWwNFabjL9bOBaHF2
//        password = admin = $2a$04$TdxUIfbqp.Bx1IHmfk6MC.cZtnjhHyyT1SRcQ5eJ2sfZMtDBZ/GOC
        return manager;
    }

//    @Bean
//    public UserDetailsService getUserDetailsService(){
//        return new UserDetailsServiceImpl();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/**").hasAnyRole("ADMIN", "USER")
                .and().httpBasic();
        http.formLogin()
                .permitAll();
        http.logout()
                .permitAll()
                .invalidateHttpSession(true);
    }

}
