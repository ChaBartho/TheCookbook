package be.technifutur.TheCookbook.service;

import be.technifutur.TheCookbook.form.IngredientForm;

import be.technifutur.TheCookbook.form.update.IngredientUpdateForm;
import be.technifutur.TheCookbook.model.dto.IngredientDTO;
import java.util.List;

public interface IngredientService {
    void createIngredient(IngredientForm form);
    IngredientDTO getIngredient(Long id);
    List<IngredientDTO> getAllIngredients();
    void update(Long id, IngredientUpdateForm form);
    void deleteIngredient(Long id);
    void clearIngredients();
}
