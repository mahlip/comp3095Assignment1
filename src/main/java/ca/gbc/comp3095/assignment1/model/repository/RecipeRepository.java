/*
 * Project: Recipe Web Application
 * Assignment: Assignment 1
 * Author(s): Jeremy Buchanan
 * Student Number: 100928225
 * Date: 2021-11-07
 * Description: Repository Interface for accessing the database recipe table. Search page query is here
 */
package ca.gbc.comp3095.assignment1.model.repository;

import ca.gbc.comp3095.assignment1.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r WHERE LOWER(CONCAT(r.name,' ',r.prepwork,' ',r.recipe)) LIKE LOWER(concat('%', concat(?1, '%')))")
    public List<Recipe> searchIgnoreCase(String keyword);
}
