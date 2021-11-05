package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.web.datatransfer.AppUserRegistrationDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private AppUserService appUserService;

    public RegistrationController(AppUserService appUserService) {
        super();
        this.appUserService = appUserService;
    }

    @RequestMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new AppUserRegistrationDataTransfer());
        return "/registration";
    }

    @RequestMapping(value = "/processRegister", method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user") AppUserRegistrationDataTransfer appUserRegistrationDataTransfer){
        appUserService.save(appUserRegistrationDataTransfer);
        return "/registerSuccess";
    }

    @RequestMapping({"/mealPlanner"})
    public String mealPlan() {
        return "/mealPlanner";
    }
}
