package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Ingredient;
import be.technifutur.TheCookbook.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipeId(Long id);
    @Query("select i from Ingredient i where lower(i.aliment) = lower(:name) and i.deleted = false")
    Optional<Ingredient> searchIngredient (@Param("name") String name);
}

