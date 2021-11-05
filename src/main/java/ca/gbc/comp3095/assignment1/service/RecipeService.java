package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.web.datatransfer.RecipeDataTransfer;

public interface RecipeService {
    Recipe save(RecipeDataTransfer recipeDataTransfer);
}
