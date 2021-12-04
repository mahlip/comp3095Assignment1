/*
 * Project: < Recipe Web Application >
 * Assignment: < assignment 1 >
 * Author(s): <Mohamed Ahlip>
 * Student Number: <10128994>
 * Date: 30/10/2021
 * Description: <The AppUserService class uses the prepackaged UserDetailsService class from the Spring Security dependency
 *               to save the information for registering users.>
 */
package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.web.datatransfer.AppUserRegistrationDataTransfer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {
    AppUser getUser(String name);

    AppUser save(AppUserRegistrationDataTransfer appUserRegistrationDataTransfer);

    AppUser getEditUserId(Long id);
}
