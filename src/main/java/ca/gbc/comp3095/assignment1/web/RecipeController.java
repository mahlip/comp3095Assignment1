/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Jeremy Buchanan
 * Student Number: 100928225
 * Date: 2021-11-07
 * Description: Controller handling everything to do with create view and search recipe pages
 */

package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.service.RecipeService;
import ca.gbc.comp3095.assignment1.web.datatransfer.RecipeDataTransfer;
import ca.gbc.comp3095.assignment1.web.datatransfer.SearchKeywordDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/newRecipe")
    public String test(Model model, Principal principal) {
        //model.addAttribute("user",appUserService.getUser(principal.getName()));
        //model.addAttribute("user","Mo");
        long num = 1;
        model.addAttribute("user",recipeService.findById(num));

        return "/recipeSuccess";
    }

    @RequestMapping("/createRecipe")
    public String showRecipeForm(Model model){
        model.addAttribute("record",new RecipeDataTransfer());
        return "/createRecipe";
    }

    @RequestMapping(value = "/processRecipe", method = RequestMethod.POST)
    public String recordRecipe(@ModelAttribute("record") RecipeDataTransfer recipeDataTransfer, Model model, Principal principal){
        model.addAttribute("recipe",recipeService.save(recipeDataTransfer,principal.getName()));
        return "/recipeSuccess";
    }

    /*
    @RequestMapping(value = "/viewRecipe")// method = RequestMethod.POST)
    public String viewRecipe(Model model){
        long recipe = 2;
        model.addAttribute("recipe",recipeService.findById(recipe));
        return "/viewRecipe";
    }*/

    @GetMapping(value = "/viewRecipes")
    public String searchRecipes(Model model, Principal principal){
        List<Recipe> allRecipes,recipes;
        allRecipes = recipeService.findAll();
        recipes = new ArrayList<>();
        for (Recipe recipe:allRecipes) {
            if(recipe.getName().equals(principal.getName()) || recipe.isShared()){
                recipes.add(recipe);
            }
        }
        model.addAttribute("recipes",recipes);
        return "viewRecipes";
    }

    @RequestMapping("/searchRecipe")
    public String searchRecipes(Model model){
        model.addAttribute("search",new SearchKeywordDataTransfer());
        return "/searchRecipe";
    }

    @RequestMapping(value = "/processSearch", method = RequestMethod.POST)
    public String showResults(@ModelAttribute("search") SearchKeywordDataTransfer searchKeywordDataTransfer, Model model, Principal principal){
        List<Recipe> allRecipes,recipes;
        allRecipes = recipeService.findByKeyword(searchKeywordDataTransfer.getKeyword());
        recipes = new ArrayList<>();
        for (Recipe recipe:allRecipes) {
            if(recipe.getName().equals(principal.getName()) || recipe.isShared()){
                recipes.add(recipe);
            }
        }
        model.addAttribute("recipes",recipes);
        return "viewRecipes";
    }
}
