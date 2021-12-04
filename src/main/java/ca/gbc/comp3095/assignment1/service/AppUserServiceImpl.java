/*
 * Project: < Recipe Web Application >
 * Assignment: < assignment 1 >
 * Author(s): <Mohamed Ahlip>
 * Student Number: <10128994>
 * Date: 30/10/2021
 * Description: <This class uses the datatransfer package to input new user entries into the database.  The class also
 *               has a method that detects if login entries exist or not.>
 */
package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.model.AppUserRole;
import ca.gbc.comp3095.assignment1.model.repository.AppUserRepository;
import ca.gbc.comp3095.assignment1.web.datatransfer.AppUserRegistrationDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService{

    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        super();
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser save(AppUserRegistrationDataTransfer appUserRegistrationDataTransfer) {

        AppUserRole role = new AppUserRole("ROLE_USER");
        AppUser appUser = new AppUser(appUserRegistrationDataTransfer.getFirstName(),
                appUserRegistrationDataTransfer.getLastName(),
                appUserRegistrationDataTransfer.getEmail(),
                passwordEncoder.encode(appUserRegistrationDataTransfer.getPassword()),
                Arrays.asList(role));

        return appUserRepository.save(appUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        AppUser appUser = appUserRepository.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails
                .User(appUser.getEmail(), appUser.getPassword(), mapRolesToAuthorities(appUser.getRoles()));
    }

    public AppUser getUser(String username){
        AppUser appUser = appUserRepository.findByEmail(username);
        return appUser;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<AppUserRole> roles){
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public void updateResetPasswordToken(String token, String username) throws AppUserNotFoundException{
        AppUser appUser = appUserRepository.findByEmail(username);
        if(appUser != null){
            appUser.setResetPasswordToken(token);
            appUserRepository.save(appUser);
        }else{
            throw new AppUserNotFoundException("Could not find a user with email:" + username);
        }
    }

    public AppUser getByResetPasswordToken(String resetPasswordToken){
        return appUserRepository.findByResetPasswordToken(resetPasswordToken);
    }

    public void updatePassword(AppUser appUser, String newPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(newPassword);

        appUser.setPassword(encodePassword);
        appUser.setResetPasswordToken(null);

        appUserRepository.save(appUser);
    }
    public AppUser getEditUserId(Long id){
        Optional<AppUser> result = appUserRepository.findById(id);
            if(result.isPresent()){
                return result.get();
            } else {
                throw new UsernameNotFoundException("Could not find any users with ID: " + id);
            }
    }

    public void saveAppUser(AppUser appUser, String newPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(newPassword);
        appUser.setPassword(encodePassword);
        this.appUserRepository.save(appUser);
    }
}
