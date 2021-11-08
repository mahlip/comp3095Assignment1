package ca.gbc.comp3095.assignment1.web.datatransfer;

public class RecipeDataTransfer {
    private String ingredients;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
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