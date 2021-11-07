package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.MealPlan;
import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.service.MealService;
import ca.gbc.comp3095.assignment1.web.datatransfer.MealDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MealPlannerController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private MealService mealService;

    @RequestMapping("/newMeal")
    public String test(Model model, Principal principal) {
        long num = 1;
        model.addAttribute("user",mealService.findById(num));

        return "/viewMeals";
    }

    @RequestMapping("/mealPlanner")
    public String showRecipeForm(Model model){
        model.addAttribute("record",new MealDataTransfer());
        return "/mealPlanner";
    }

    @RequestMapping(value = "/processMeal", method = RequestMethod.POST)
    public String recordMeal(@ModelAttribute("record") MealDataTransfer mealDataTransfer, Model model, Principal principal){
        model.addAttribute("meal",mealService.save(mealDataTransfer,principal.getName()));
        return "/viewMeals";
    }

    @GetMapping(value = "/viewMeals")
    public String searchRecipes(Model model, Principal principal){
        List<MealPlan> allMeals,meals;
        allMeals = mealService.findAll();
        meals = new ArrayList<>();
        for (MealPlan meal:allMeals) {
            if(meal.getName().equals(principal.getName()) || meal.isShared()){
                meals.add(meal);
            }
        }
        model.addAttribute("recipes",meals);
        return "viewMeals";
    }
}
