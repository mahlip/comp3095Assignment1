package ca.gbc.comp3095.assignment1.web.datatransfer;

import ca.gbc.comp3095.assignment1.model.AppUser;

public class MealDataTransfer {
    private String ingredients;
    private String prepWork;
    private String recipe;
    private String name;
    private String username;
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

    public boolean getShared(){
        return shared;
    }

    public String getUsername() {
        return username;
    }

    public MealDataTransfer() {

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

    public String getPrepWork() {
        return prepWork;
    }

    public void setPrepWork(String prepwork) {
        this.prepWork = prepwork;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
