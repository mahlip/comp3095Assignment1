package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.config.CustomAppUserDetails;
import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.model.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAppUserDetailService implements UserDetailsService {

    @Autowired
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = repository.findByEmail(email);
        if(appUser == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomAppUserDetails(appUser);
    }
}
