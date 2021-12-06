/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Jeremy Buchanan
 * Student Number: 100928225
 * Date: 2021-11-07
 * Description: Controller handling everything to do with create view and search recipe pages
 */

package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.model.Ingredients;
import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.service.IngredientsService;
import ca.gbc.comp3095.assignment1.service.RecipeService;
import ca.gbc.comp3095.assignment1.web.datatransfer.FavouriteDataTransfer;
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

    @Autowired
    private IngredientsService ingredientsService;

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
        List<Ingredients> ingredients = ingredientsService.findAll();
        model.addAttribute("ingredients",ingredients);
        return "/createRecipe";
    }

    @RequestMapping(value = "/processRecipe", method = RequestMethod.POST)
    public String recordRecipe(@RequestParam("ingredients") List<Ingredients> ingredients, @ModelAttribute("record") RecipeDataTransfer recipeDataTransfer, Model model, Principal principal){
        System.out.println(ingredients);
        model.addAttribute("recipe",recipeService.save(ingredients, recipeDataTransfer,principal.getName()));
        System.out.println(ingredients);
        return "/recipeSuccess";
    }


    @GetMapping(value = "/viewRecipe/{id}")
    public String viewRecipe(@PathVariable long id, Model model, Principal principal){
        Recipe recipe = recipeService.findById(id);
        boolean favourite = false;
        for(AppUser lover : recipe.getLovers()) {
            if(lover.getEmail().equals(principal.getName())){
                favourite = true;
            }
            
        }
        model.addAttribute("recipe",recipe);
        model.addAttribute("number",id);
        model.addAttribute("favourite",favourite);
        model.addAttribute("record",new FavouriteDataTransfer());
        return "viewRecipe";
    }



    @RequestMapping("/viewRecipes")
    public String searchRecipes(Model model, Principal principal){
        List<Recipe> allRecipes,recipes;
        allRecipes = recipeService.findAll();
        recipes = new ArrayList<>();
        for (Recipe recipe:allRecipes) {
            if(recipe.getOwner().getEmail().equals(principal.getName()) || recipe.isShared()){
                recipes.add(recipe);
            }
        }
        model.addAttribute("recipes",recipes);
        return "viewRecipes";
    }

    @RequestMapping("/viewMyRecipes")
    public String searchMyRecipes(Model model, Principal principal){
        List<Recipe> allRecipes,recipes;
        allRecipes = recipeService.findAll();
        recipes = new ArrayList<>();
        for (Recipe recipe:allRecipes) {
            if(recipe.getOwner().getEmail().equals(principal.getName())){
                recipes.add(recipe);
            }
        }
        model.addAttribute("recipes",recipes);
        return "viewRecipes";
    }

    @RequestMapping("/viewFavouriteRecipes")
    public String viewMyFavourites(Model model, Principal principal){
        AppUser user = appUserService.getUser(principal.getName());
        List<Recipe> recipes = user.getFavourites();
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
            if(recipe.getOwner().getEmail().equals(principal.getName()) || recipe.isShared()){
                recipes.add(recipe);
            }
        }
        model.addAttribute("recipes",recipes);
        return "viewRecipes";
    }

    @RequestMapping(value = "/faveRecipe", method = RequestMethod.POST)
    public String faveRecipe(@ModelAttribute("record") FavouriteDataTransfer favouriteDataTransfer, Model model, Principal principal){
        Recipe recipe = recipeService.findById(favouriteDataTransfer.getId());
        AppUser user = appUserService.getUser(principal.getName());
        List<AppUser> lovers = recipe.getLovers();
        lovers.add(user);
        recipe.setLovers(lovers);
        recipeService.save(recipe);
        model.addAttribute("recipe",recipe);
        model.addAttribute("favourite",true);
        model.addAttribute("recipe",recipe);
        return "viewRecipe";
    }
}
