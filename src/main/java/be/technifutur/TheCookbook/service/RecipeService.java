package be.technifutur.TheCookbook.service;

import be.technifutur.TheCookbook.form.RecipeForm;
import be.technifutur.TheCookbook.form.update.RecipeUpdateForm;
import be.technifutur.TheCookbook.model.dto.RecipeDTO;

import java.util.List;

public interface RecipeService {
    void createRecipe(RecipeForm form);
    RecipeDTO getRecipe(Long id);
    RecipeDTO searchRecipe(String name);
    List<RecipeDTO> getAllRecipes();
    void update(Long id, RecipeUpdateForm form);
    void deleteRecipe(Long id);
    void clearRecipes();
}
