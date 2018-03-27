package com.actionlistapi.service;

import com.actionlistapi.model.CustomUserDetails;
import com.actionlistapi.model.Principal;
import com.actionlistapi.repository.PrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PrincipalRepository principalRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Principal user = principalRepository.findByUniversityId(username);
        if (user == null)
            return null;
        else
            return new CustomUserDetails(user);
    }
}
