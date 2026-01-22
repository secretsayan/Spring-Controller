package com.myproject.userserviceevebatch.security.services;

import com.myproject.userserviceevebatch.models.User;
import com.myproject.userserviceevebatch.repositories.UserRepository;
import com.myproject.userserviceevebatch.security.models.CustomUserDetails;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@JsonDeserialize
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User with email: " + username + " doesn't exist");
        }

        return new CustomUserDetails(optionalUser.get());
    }
}
