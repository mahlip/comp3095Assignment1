/*
 * Project: < Recipe Web Application >
 * Assignment: < assignment 1 >
 * Author(s): <Mohamed Ahlip>
 * Student Number: <10128994>
 * Date: 30/10/2021
 * Description: <The purpose of the AppUserRole class is to assign a role type to each user profile in the event that an
 *                admin role is required in the future.>
 */package ca.gbc.comp3095.assignment1.model;

import javax.persistence.*;

@Entity
@Table(name = "APP_USER_ROLE")
public class AppUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name ="USER_ID")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Column(name ="ROLE_ID")
    private Long roleId;

    public AppUserRole(String name) {
        super();
        this.name = name;
//        this.userId = "";
//        this.roleId ="";
    }

    public AppUserRole() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
