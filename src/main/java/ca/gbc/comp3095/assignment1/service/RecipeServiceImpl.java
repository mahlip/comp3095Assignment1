package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Recipe;
import ca.gbc.comp3095.assignment1.model.repository.RecipeRepository;
import ca.gbc.comp3095.assignment1.web.datatransfer.RecipeDataTransfer;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{
    private RecipeRepository recipeRepository;
    private AppUserService appUserService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, AppUserService appUserService) {
        this.recipeRepository = recipeRepository;
        this.appUserService = appUserService;
    }

    @Override
    public Recipe save(RecipeDataTransfer recipeDataTransfer) {
        Recipe recipe = new Recipe(recipeDataTransfer.getIngredients(),
                recipeDataTransfer.getPrepWork(),
                recipeDataTransfer.getRecipe(),
                recipeDataTransfer.getName(),
                recipeDataTransfer.getShared(),
                appUserService.getUser(recipeDataTransfer.getUsername()));
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        return recipe;
    }


}