package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.model.MealPlan;
import ca.gbc.comp3095.assignment1.service.AppUserService;
import ca.gbc.comp3095.assignment1.service.RecipeService;
import ca.gbc.comp3095.assignment1.service.MealService;
import ca.gbc.comp3095.assignment1.web.datatransfer.RecipeDataTransfer;
import ca.gbc.comp3095.assignment1.web.datatransfer.MealDataTransfer;
import ca.gbc.comp3095.assignment1.web.datatransfer.SearchKeywordDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MealPlannerController {
}
