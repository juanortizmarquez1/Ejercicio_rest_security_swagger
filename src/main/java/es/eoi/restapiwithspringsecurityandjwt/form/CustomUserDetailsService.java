package es.eoi.restapiwithspringsecurityandjwt.form;

import es.eoi.restapiwithspringsecurityandjwt.entity.User;
import es.eoi.restapiwithspringsecurityandjwt.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("Username: " + s + " not found"));
    }
}
