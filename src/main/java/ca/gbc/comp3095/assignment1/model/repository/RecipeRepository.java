
package ca.gbc.comp3095.assignment1.model.repository;

import ca.gbc.comp3095.assignment1.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r WHERE LOWER(CONCAT(r.name,' ',r.prepwork,' ',r.ingredients,' ',r.recipe)) LIKE LOWER(concat('%', concat(?1, '%')))")
    public List<Recipe> searchIgnoreCase(String keyword);
}
