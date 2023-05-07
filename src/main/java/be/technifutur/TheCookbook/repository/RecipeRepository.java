package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
