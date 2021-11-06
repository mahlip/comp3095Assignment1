package ca.gbc.comp3095.assignment1.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="MEAL")
public class MealPlan{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MEAL_ID")
    private Long id;

    @Column(name="INGREDIENTS", nullable = false)
    private String ingredients;

    @Column(name ="PREPWORK")
    private String prepwork;
    @Column(name ="Meal", nullable = false)
    private String recipe;

    @Column(name ="NAME", nullable = false)
    private String name;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "USER_ID")
    private AppUser owner;

    @Column(name ="PUBLIC")
    private boolean shared;


    public MealPlan(String ingredients,
                  String prepwork,
                  String instructions,
                  String name,
                  boolean shared,
                  AppUser user) {
        //super();
        this.ingredients = ingredients;
        this.prepwork = prepwork;
        this.recipe = instructions;
        this.name = name;
        this.shared = shared;
        this.owner = user;
    }

    public MealPlan() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrepwork() {
        return prepwork;
    }

    public void setPrepwork(String prepwork) {
        this.prepwork = prepwork;
    }

    public String getMeal() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
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

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }
}

