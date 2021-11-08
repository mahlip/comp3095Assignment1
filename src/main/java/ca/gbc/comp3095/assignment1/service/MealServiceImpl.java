/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-11-6
 * Description: Meal Planner Service implementation for the purpose of providing functions related to saving and locating Meal plans from the repository.
 */

package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.MealPlan;
import ca.gbc.comp3095.assignment1.model.repository.MealRepository;
import ca.gbc.comp3095.assignment1.web.datatransfer.MealDataTransfer;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealServiceImpl implements MealService{
    private MealRepository mealRepository;
    private AppUserService appUserService;


    public MealServiceImpl(MealRepository mealRepository, AppUserService appUserService) {
        this.mealRepository = mealRepository;
        this.appUserService = appUserService;
    }

    @Override
    public MealPlan save(MealDataTransfer mealDataTransfer, String name) {
        MealPlan meal = new MealPlan(mealDataTransfer.getName(),
                mealDataTransfer.getDate(),
                appUserService.getUser(name));
        return mealRepository.save(meal);
    }

    @Override
    public List<MealPlan> findAll(){
        return mealRepository.findAll();
    }

    @Override
    public MealPlan findById(long id) {
        MealPlan meal = mealRepository.findById(id).get();
        return meal;
    }

    public List<MealPlan> findByKeyword(String keyword){
        return mealRepository.searchIgnoreCase(keyword);
    }

}
