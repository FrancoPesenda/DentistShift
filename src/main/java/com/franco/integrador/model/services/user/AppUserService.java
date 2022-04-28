package com.franco.integrador.model.services.user;

import com.franco.integrador.model.entities.AppUser;
import com.franco.integrador.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    UserRepository repository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userTemp = repository.findByEmail(username) ;
        if (userTemp.isPresent()){
            return userTemp.get() ;
        }else {
            throw new UsernameNotFoundException("Email de usuario no encontrado") ;
        }
    }
}
