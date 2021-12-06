/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Shopping Service implementation for the purpose of providing functions related to saving and locating shopped items from the repository.
 */

package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Shopping;
import ca.gbc.comp3095.assignment1.model.repository.ShoppingRepository;
import ca.gbc.comp3095.assignment1.web.datatransfer.ShoppingDataTransfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService{
    private ShoppingRepository shoppingRepository;
    private AppUserService appUserService;


    public ShoppingServiceImpl(ShoppingRepository shoppingRepository, AppUserService appUserService) {
        this.shoppingRepository = shoppingRepository;
        this.appUserService = appUserService;
    }

    @Override
    public Shopping save(ShoppingDataTransfer shoppingDataTransfer, String name) {
        Shopping shopping = new Shopping(shoppingDataTransfer.getName(),
                appUserService.getUser(name));
        return shoppingRepository.save(shopping);
    }

    @Override
    public void delete(Shopping Shop) {
        shoppingRepository.delete(Shop);
    }

    @Override
    public List<Shopping> findAll(){
        return shoppingRepository.findAll();
    }

    @Override
    public Shopping findById(long id) {
        Shopping shopping = shoppingRepository.findById(id).get();
        return shopping;
    }

    public List<Shopping> findByKeyword(String keyword){
        return shoppingRepository.searchIgnoreCase(keyword);
    }

}
