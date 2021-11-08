/*
 * Project: < Recipe Web Application >
 * Assignment: < assignment 1 >
 * Author(s): <Mohamed Ahlip>
 * Student Number: <10128994>
 * Date: 01/11/2021
 * Description: <This AppUserRepository class implements the findByEmail method which is used to prevent duplicate emails being
 *               created and is also used for login features, among other things.>
 */
package ca.gbc.comp3095.assignment1.model.repository;

import ca.gbc.comp3095.assignment1.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
