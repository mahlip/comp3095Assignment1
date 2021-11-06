package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.MealPlan;
import ca.gbc.comp3095.assignment1.web.datatransfer.MealDataTransfer;

import java.util.List;

public interface MealService {
    MealPlan save(MealDataTransfer mealDataTransfer);

    List<MealPlan> findAll();

    MealPlan findById(long id);
}
