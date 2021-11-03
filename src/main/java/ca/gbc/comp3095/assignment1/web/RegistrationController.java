package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.model.repository.AppUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {


    private AppUserRepository appUserRepository;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new AppUser());
        return "/registration";
    }

    @PostMapping("/processRegister")
    public String registerUserAccount(AppUser appUser){
        appUserRepository.save(appUser);
        return "/registerSuccess";
    }

}
