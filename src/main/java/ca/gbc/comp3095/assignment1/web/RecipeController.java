package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class RecipeController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/newRecipe")
    public String home(Model model, Principal principal) {
        //model.addAttribute("user",appUserService.getUser(principal.getName()));
        //model.addAttribute("user","Mo");
        long num = 1;
        model.addAttribute("user",recipeService.findById(num));

        return "/recipeSuccess";
    }
}
