/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Shopping Planner Data Transfer for the purpose of providing shopping data related functions.
 */

package ca.gbc.comp3095.assignment1.web.datatransfer;

import ca.gbc.comp3095.assignment1.model.AppUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
public class ShoppingDataTransfer {
    private String name;
    private String username;

    public ShoppingDataTransfer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
