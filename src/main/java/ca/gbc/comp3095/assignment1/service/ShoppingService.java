/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Shopping Service for the purpose of providing functions related to saving and locating shopped items from the repository.
 */

package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Shopping;
import ca.gbc.comp3095.assignment1.web.datatransfer.ShoppingDataTransfer;

import java.util.List;

public interface ShoppingService {
    Shopping save(ShoppingDataTransfer shoppingDataTransfer, String name);

    List<Shopping> findAll();

    Shopping findById(long id);

    List<Shopping> findByKeyword(String keyword);
}
