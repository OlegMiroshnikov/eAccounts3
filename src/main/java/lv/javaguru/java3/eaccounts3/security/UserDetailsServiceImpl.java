package lv.javaguru.java3.eaccounts3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        // с помощью нашего сервиса UserService получаем User
//        User user = userService.getUser("colibri");
//        // указываем роли для этого пользователя
//        Set<GrantedAuthority> roles = new HashSet();
//        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
//
//        // на основании полученных данных формируем объект UserDetails
//        // который позволит проверить введенный пользователем логин и пароль
//        // и уже потом аутентифицировать пользователя
//        UserDetails userDetails =
//                new org.springframework.security.core.userdetails.User(user.getLogin(),
//                        user.getPassword(),
//                        roles);
//
//        return userDetails;
//    }
//
//}