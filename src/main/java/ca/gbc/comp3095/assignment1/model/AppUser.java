/*
 * Project: < Recipe Web Application >
 * Assignment: < assignment 1 >
 * Author(s): <Mohamed Ahlip>
 * Student Number: <10128994>
 * Date: 30/10/2021
 * Description: <The purpose of the AppUser class is to initialize an AppUser type that will be used as the entities for the
 *                  profile users of the app's database.>
 */
package ca.gbc.comp3095.assignment1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name ="APP_USER", uniqueConstraints = @UniqueConstraint( columnNames = "EMAIL"))
public class AppUser{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_ID")
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name ="LAST_NAME")
    private String lastName;
    @Column(name ="EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name ="PASSWORD",nullable = false, length = 64)
    private String password;
    @Column(name ="reset_password_token")
    private String resetPasswordToken;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "APP_USER_ROLE",
            joinColumns = @JoinColumn(
                    name = "USER_ID", referencedColumnName = "USER_ID"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "ROLE_ID", referencedColumnName = "USER_ID"
            )
    )
    private Collection<AppUserRole> roles;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Recipe> recipes = new ArrayList<>();

    public AppUser(String firstName,
                String lastName,
                String email,
                String password,
                Collection<AppUserRole> roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public AppUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<AppUserRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppUserRole> roles) {
        this.roles = roles;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipe.setOwner(this);
        recipes.add(recipe);
    }

}
