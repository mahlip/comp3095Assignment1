/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Ingredients Planner Controller for the purpose of controlling individual actions associated with the Ingredients Planner.
 */

package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.Ingredients;
import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.service.IngredientsService;
import ca.gbc.comp3095.assignment1.service.RecipeService;
import ca.gbc.comp3095.assignment1.web.datatransfer.FavouriteDataTransfer;
import ca.gbc.comp3095.assignment1.web.datatransfer.IngredientDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IngredientsController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private IngredientsService ingredientsService;

    @RequestMapping("/newIngredient")
    public String test(Model model, Principal principal) {
        long num = 1;
        model.addAttribute("user",ingredientsService.findById(num));

        return "/viewIngredients";
    }

    @RequestMapping("/ingredientPlanner")
    public String showRecipeForm(Model model, Principal principal){
        model.addAttribute("record",new IngredientDataTransfer());

        List<Recipe> allRecipes,recipes;
        allRecipes = recipeService.findAll();
        recipes = new ArrayList<>();
        for (Recipe recipe:allRecipes) {
            if(recipe.getName().equals(principal.getName()) || recipe.isShared()){
                recipes.add(recipe);
            }
        }
        model.addAttribute("recipes",recipes);

        return "/ingredientPlanner";
    }

    @RequestMapping(value = "/processIngredient", method = RequestMethod.POST)
    public String recordIngredient(@ModelAttribute("record") IngredientDataTransfer ingredientDataTransfer, Model model, Principal principal){
        model.addAttribute("ingredient",ingredientsService.save(ingredientDataTransfer,principal.getName()));
        return "/viewIngredients";
    }

    @GetMapping(value = "/viewIngredients")
    public String searchRecipes(Model model, Principal principal){
        List<Ingredients> allIngredients,ingredients;
        allIngredients = ingredientsService.findAll();
        ingredients = new ArrayList<>();
        for (Ingredients ingredient:allIngredients) {
            if(ingredient.getOwner().equals(appUserService.getUser(principal.getName())) || ingredient.isShared()){
                ingredients.add(ingredient);
            }
        }
        model.addAttribute("ingredients",ingredients);
        return "viewIngredients";
    }

    @PostMapping(value = "/recipeIngredients")
    public String recipeIngredients(@ModelAttribute("record") FavouriteDataTransfer favouriteDataTransfer, Model model, Principal principal){
        Recipe recipe = recipeService.findById(favouriteDataTransfer.getId());
        List<Ingredients> ingredients = new ArrayList<>();
        for (Ingredients ingredient:recipe.getRecipeIngredients()) {
                ingredients.add(ingredient);
        }
        model.addAttribute("ingredients",ingredients);
        return "viewIngredients";
    }
}

