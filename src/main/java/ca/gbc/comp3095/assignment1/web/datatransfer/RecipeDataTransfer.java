/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Jeremy Buchanan
 * Student Number: 100928225
 * Date: 2021-11-07
 * Description: Data Transfer Class to handle the Create Recipe Form's Data
 */
package ca.gbc.comp3095.assignment1.web.datatransfer;

import ca.gbc.comp3095.assignment1.model.Ingredients;
import java.util.Set;

public class RecipeDataTransfer {
    private Set<Ingredients> ingredients;
    private String prepWork;
    private String recipe;
    private String name;
    private boolean shared;


    /*public RecipeDataTransfer(String ingredients,
                  String prepWork,
                  String instructions,
                  String name,
                              boolean shared,
                              String username) {
        //super();
        this.ingredients = ingredients;
        this.prepWork = prepWork;
        this.recipe = instructions;
        this.name = name;
        this.username = username;
        this.shared = shared;
    }*/

    public RecipeDataTransfer(){

    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public boolean getShared(){
        return shared;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrepWork() {
        return prepWork;
    }

    public void setPrepWork(String prepWork) {
        this.prepWork = prepWork;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}