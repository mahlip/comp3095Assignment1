/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-11-6
 * Description:
 */

package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Ingredients;
import ca.gbc.comp3095.assignment1.model.repository.IngredientsRepository;
import ca.gbc.comp3095.assignment1.web.datatransfer.IngredientDataTransfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService{
    private IngredientsRepository ingredientsRepository;
    private AppUserService appUserService;


    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository, AppUserService appUserService) {
        this.ingredientsRepository = ingredientsRepository;
        this.appUserService = appUserService;
    }

    @Override
    public Ingredients save(IngredientDataTransfer ingredientDataTransfer, String name) {
        Ingredients ingredient = new Ingredients(ingredientDataTransfer.getName(),
                ingredientDataTransfer.getIngredient(),
                appUserService.getUser(name));
        return ingredientsRepository.save(ingredient);
    }

    @Override
    public List<Ingredients> findAll(){
        return ingredientsRepository.findAll();
    }

    @Override
    public Ingredients findById(long id) {
        Ingredients ingredient = ingredientsRepository.findById(id).get();
        return ingredient;
    }

    public List<Ingredients> findByKeyword(String keyword){
        return ingredientsRepository.searchIgnoreCase(keyword);
    }

}
