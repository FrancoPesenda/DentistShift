package com.franco.integrador.model.services.user;

import com.franco.integrador.model.entities.AppUser;
import com.franco.integrador.model.entities.AppUserRol;
import com.franco.integrador.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository repository ;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = passwordEncoder.encode("morningstar");
        repository.save(new AppUser("Franco","FrancoP","francopesenda@gmail.com",pass, AppUserRol.ROL_USER)) ;
    }
}
