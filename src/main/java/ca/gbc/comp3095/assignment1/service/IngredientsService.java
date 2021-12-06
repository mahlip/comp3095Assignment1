/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Ingredients Service for the purpose of providing functions related to saving and locating ingredients from the repository.
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
