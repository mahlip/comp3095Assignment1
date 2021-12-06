/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Ingredients Class for the purpose of creating new meal plans and tables.
 */

package ca.gbc.comp3095.assignment1.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name ="SHOPPINGLIST")
public class Shopping {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SHP_ID")
    private Long id;

    @Column(name="Name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "USER_ID")
    private AppUser owner;

    @Column(name ="PUBLIC")
    private boolean shared;


    public Shopping(String name,
                       AppUser user) {
        //super();
        this.name = name;
        this.shared = shared;
        this.owner = user;
    }

    public Shopping() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

