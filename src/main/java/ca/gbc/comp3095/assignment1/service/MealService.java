package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.MealPlan;
import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.web.datatransfer.MealDataTransfer;
import ca.gbc.comp3095.assignment1.web.datatransfer.RecipeDataTransfer;

import java.util.List;

public interface MealService {
    MealService save(RecipeDataTransfer recipeDataTransfer, String name);

    List<MealService> findAll();

    MealService findById(long id);

    List<MealService> findByKeyword(String keyword);
}

