package com.jobassistant.login_signup.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jobassistant.login_signup.model.User;
import com.jobassistant.login_signup.repository.UserRepository;
import java.util.Set;
import java.util.HashSet;

public class AuthUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {

        com.jobassistant.login_signup.model.User user = userRepository.findbyEmail(Email).get();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        user.getAuthorities()
          .forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getName())));

        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
}
