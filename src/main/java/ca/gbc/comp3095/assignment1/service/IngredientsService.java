/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-11-6
 * Description:
 */

package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Ingredients;
import ca.gbc.comp3095.assignment1.web.datatransfer.IngredientDataTransfer;


import java.util.List;

public interface IngredientsService {
    Ingredients save(IngredientDataTransfer ingredientDataTransfer, String name);

    List<Ingredients> findAll();

    Ingredients findById(long id);

    List<Ingredients> findByKeyword(String keyword);
}
