package ca.gbc.comp3095.assignment1.model.repository;

import ca.gbc.comp3095.assignment1.model.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long> {
    @Query("SELECT s FROM Shopping s WHERE LOWER(s.name) LIKE LOWER(concat('%', concat(?1, '%')))")
    public List<Shopping> searchIgnoreCase(String keyword);
/*
    @Modifying
    @Transactional
    @Query("DELETE FROM Shopping s WHERE s.id = :id")
    public void deleteIngredientsById(Long id);
 */
}

