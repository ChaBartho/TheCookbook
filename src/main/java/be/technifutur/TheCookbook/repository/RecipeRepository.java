package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("select r from Recipe r where lower(r.name) = lower(:name) and r.deleted = false")
    Optional<Recipe> searchRecipe (@Param("name") String name);


}
