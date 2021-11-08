/*
 * Project: < Recipe Web Application >
 * Assignment: < assignment 1 >
 * Author(s): <Mohamed Ahlip>
 * Student Number: <10128994>
 * Date: 30/10/2021
 * Description: <The MainLoginController class serves as the app's controller for the login screen.>
 */package ca.gbc.comp3095.assignment1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainLoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
