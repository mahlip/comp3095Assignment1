package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.web.datatransfer.RecipeDataTransfer;

import java.util.List;

public interface RecipeService {
    Recipe save(RecipeDataTransfer recipeDataTransfer, String name);

    List<Recipe> findAll();

    Recipe findById(long id);

    List<Recipe> findByKeyword(String keyword);

}
