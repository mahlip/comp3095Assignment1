package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.model.AppUserRole;
import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.model.repository.RecipeRepository;
import ca.gbc.comp3095.assignment1.web.datatransfer.AppUserRegistrationDataTransfer;
import ca.gbc.comp3095.assignment1.web.datatransfer.RecipeDataTransfer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl {
    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe save(String ingredients,
                       String prepwork,
                       String instructions,
                       String name) {
        Recipe recipe = new Recipe(ingredients,prepwork,instructions,name);

        return recipeRepository.save(recipe);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails
                .User(appUser.getEmail(), appUser.getPassword(), mapRolesToAuthorities(appUser.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<AppUserRole> roles){
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
