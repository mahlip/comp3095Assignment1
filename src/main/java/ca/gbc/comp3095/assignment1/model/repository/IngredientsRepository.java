/*
 * Project: Recipe Web Application
 * Assignment: Assignment 2
 * Author(s): Adam Vandyke
 * Student Number: 101023594
 * Date: 2021-12-5
 * Description: Ingredients Repository with query for pertinent information.
 */

package ca.gbc.comp3095.assignment1.model.repository;

import ca.gbc.comp3095.assignment1.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
    @Query("SELECT i FROM Ingredients i WHERE LOWER(CONCAT(i.name,' ', i.ingredient)) LIKE LOWER(concat('%', concat(?1, '%')))")
    public List<Ingredients> searchIgnoreCase(String keyword);

}
