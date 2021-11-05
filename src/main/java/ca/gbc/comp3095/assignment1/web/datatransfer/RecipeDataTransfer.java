package ca.gbc.comp3095.assignment1.web.datatransfer;

public class RecipeDataTransfer {
    private String ingredients;
    private String prepwork;
    private String recipe;
    private String name;
    private AppUser owner;


    public Recipe(String ingredients,
                  String prepwork,
                  String instructions,
                  String name) {
        //super();
        this.ingredients = ingredients;
        this.prepwork = prepwork;
        this.recipe = instructions;
        this.name = name;
    }

    public Recipe() {

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

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }
}

