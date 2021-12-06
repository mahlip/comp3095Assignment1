/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-11-6
 * Description: Meal Planner Service implementation for the purpose of providing functions related to saving and locating Meal plans from the repository.
 */

package ca.gbc.comp3095.assignment1.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name ="INGREDIENTS")
public class Ingredients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ING_ID")
    private Long id;

    @Column(name="Name", nullable = false)
    private String name;

    @Column(name="Ingredient", nullable = false)
    private String ingredient;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "USER_ID")
    private AppUser owner;

    @Column(name ="PUBLIC")
    private boolean shared;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "ING_ID"),
            inverseJoinColumns = @JoinColumn(name = "RECIPE_ID"))
    List<Recipe> uses;

    public Ingredients(String name,
                       String ingredient,
                    AppUser user) {
        //super();
        this.name = name;
        this.ingredient = ingredient;
        this.shared = shared;
        this.owner = user;
    }

    public Ingredients() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public AppUser getOwner() {
        return owner;
    }

    public Long getId() {
        return id;
    }

    public boolean isShared() {
        return shared;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }
}
