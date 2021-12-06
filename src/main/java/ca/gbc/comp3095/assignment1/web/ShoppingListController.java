/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Shopping List  Controller for the purpose of controlling individual actions associated with the Shopping Planner.
 */

package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.Shopping;
import ca.gbc.comp3095.assignment1.model.Ingredients;
import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.service.IngredientsService;
import ca.gbc.comp3095.assignment1.service.ShoppingService;
import ca.gbc.comp3095.assignment1.web.datatransfer.ShoppingDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingListController {

    @Autowired
    private IngredientsService ingredientsService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ShoppingService shoppingService;

    @RequestMapping("/newShopping")
    public String test(Model model, Principal principal) {
        long num = 1;
        model.addAttribute("user",shoppingService.findById(num));

        return "/viewShoppingList";
    }

    @RequestMapping("/shoppingPlanner")
    public String showIngredientsForm(Model model, Principal principal){
        model.addAttribute("record",new ShoppingDataTransfer());

        List<Ingredients> allIngredients,ingredients;
        allIngredients = ingredientsService.findAll();
        ingredients = new ArrayList<>();
        for (Ingredients ingredient:allIngredients) {
            if(ingredient.getOwner().equals(appUserService.getUser(principal.getName())) || ingredient.isShared()){
                ingredients.add(ingredient);
            }
        }
        model.addAttribute("ingredients",ingredients);

        return "/shoppingPlanner";
    }

    @RequestMapping(value = "/processShopping", method = RequestMethod.POST)
    public String recordIngredient(@ModelAttribute("record") ShoppingDataTransfer shoppingDataTransfer, Model model, Principal principal){
        model.addAttribute("shopping",shoppingService.save(shoppingDataTransfer,principal.getName()));
        return "/viewShoppingList";
    }


    @GetMapping(value = "/viewShoppingList")
    public String searchRecipes(Model model, Principal principal){
        List<Shopping> allShopping,shopping;
        allShopping = shoppingService.findAll();
        shopping = new ArrayList<>();
        for (Shopping shop:allShopping) {
            if(shop.getOwner().equals(appUserService.getUser(principal.getName())) || shop.isShared()){
                shopping.add(shop);
            }
        }
        model.addAttribute("shopping",shopping);
        return "viewShoppingList";
    }
}


