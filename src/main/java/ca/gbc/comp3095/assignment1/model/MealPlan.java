/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-11-6
 * Description: Meal Planner Class for the purpose of creating new meal plans and tables.
 */

package ca.gbc.comp3095.assignment1.model;

import org.thymeleaf.expression.Dates;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name ="MEAL")
public class MealPlan{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MEAL_ID")
    private Long id;

    @Column(name="Name", nullable = false)
    private String name;

    @Column(name ="Date", nullable = false)
    private Date date;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "USER_ID")
    private AppUser owner;

    @Column(name ="PUBLIC")
    private boolean shared;


    public MealPlan(String name,
                  Date date,
                  AppUser user) {
        //super();
        this.name = name;
        this.date = date;
        this.shared = shared;
        this.owner = user;
    }

    public MealPlan() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeal() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AppUser getOwner() {
        return owner;
    }

    public Long getId() {
        return id;
    }

    public boolean isShared() {
        return shared;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }
}

