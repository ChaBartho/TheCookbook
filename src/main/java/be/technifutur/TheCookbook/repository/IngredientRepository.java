package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
