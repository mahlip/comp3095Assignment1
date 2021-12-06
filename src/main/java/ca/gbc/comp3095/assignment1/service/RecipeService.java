/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Jeremy Buchanan
 * Student Number: 100928225
 * Date: 2021-11-07
 * Description: Interface for the Recipe service for spring injection
 */
package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Ingredients;
import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.web.datatransfer.RecipeDataTransfer;

import java.util.List;

public interface RecipeService {
    Recipe save(List<Ingredients> ingredients, RecipeDataTransfer recipeDataTransfer, String name);

    Recipe save(Recipe recipe);

    List<Recipe> findAll();

    Recipe findById(long id);

    List<Recipe> findByKeyword(String keyword);

}
