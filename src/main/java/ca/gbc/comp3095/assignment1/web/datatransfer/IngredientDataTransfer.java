/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Ingredient Planner Data Transfer for the purpose of providing ingredient data related functions.
 */

package ca.gbc.comp3095.assignment1.web.datatransfer;

import ca.gbc.comp3095.assignment1.model.AppUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
public class IngredientDataTransfer {
    private String name;
    private String ingredient;
    private String username;

    public IngredientDataTransfer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

}
