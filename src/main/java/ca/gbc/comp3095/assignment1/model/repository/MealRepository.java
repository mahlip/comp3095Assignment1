/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-11-6
 * Description: Meal Planner Repository with query for pertinent information.
 */
package ca.gbc.comp3095.assignment1.model.repository;

import ca.gbc.comp3095.assignment1.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<MealPlan, Long> {
    @Query("SELECT m FROM MealPlan m WHERE LOWER(CONCAT(m.name,' ',m.date)) LIKE LOWER(concat('%', concat(?1, '%')))")
    public List<MealPlan> searchIgnoreCase(String keyword);
}
