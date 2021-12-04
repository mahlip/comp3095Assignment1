package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.service.AppUserServiceImpl;
import ca.gbc.comp3095.assignment1.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class MyProfileController {

    @Autowired
    private AppUserServiceImpl appUserService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/myProfile")
    public String showProfilePage(Model model, Principal principal){

        String email = principal.getName();
        AppUser appUser = appUserService.getUser(email);
        model.addAttribute("appUser", appUser);
        return "myProfile";
    }
    @PostMapping("/saveAppUser")
    public String saveAppUser(@ModelAttribute("user") AppUser appUser, HttpServletRequest request){
        String password = request.getParameter("password");
        appUserService.saveAppUser(appUser, password);
        return "redirect:/myProfile";
    }

    @GetMapping("/showEditPage/{id}")
    public String showEditPage(@PathVariable(value = "id") long id, Model model, RedirectAttributes ra){
        try {
            AppUser appUser = appUserService.getEditUserId(id);
            model.addAttribute("user", appUser);
            model.addAttribute("pageTitle", "Edit User (ID: " + id +")");
            return "edit";
        } catch (UsernameNotFoundException e){
            ra.addFlashAttribute("message", "The profile information has been saved successfully.");
            return "redirect:/myProfile";
        }
    }
}
