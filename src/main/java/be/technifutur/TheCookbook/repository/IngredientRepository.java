package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipeId(Long id);
}

