/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-11-6
 * Description: Meal Planner Service for the purpose of providing functions related to saving and locating Meal plans from the repository.
 */

package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.MealPlan;
import ca.gbc.comp3095.assignment1.web.datatransfer.MealDataTransfer;


import java.util.List;

public interface MealService {
    MealPlan save(MealDataTransfer mealDataTransfer, String name);

    List<MealPlan> findAll();

    MealPlan findById(long id);

    List<MealPlan> findByKeyword(String keyword);
}

