/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-11-6
 * Description: Meal Planner Data Transfer for the purpose of providing meal data related functions.
 */

package ca.gbc.comp3095.assignment1.web.datatransfer;

import ca.gbc.comp3095.assignment1.model.AppUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class MealDataTransfer {
    private String name;
    private String recipe;
    private String username;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;

    public MealDataTransfer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
