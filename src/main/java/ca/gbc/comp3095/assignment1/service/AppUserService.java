package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.web.datatransfer.AppUserRegistrationDataTransfer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {
    AppUser getUser(String name);

    AppUser save(AppUserRegistrationDataTransfer appUserRegistrationDataTransfer);
}
