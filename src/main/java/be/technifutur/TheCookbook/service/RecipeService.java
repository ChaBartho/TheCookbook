package be.technifutur.TheCookbook.service;

import be.technifutur.TheCookbook.form.RecipeForm;
import be.technifutur.TheCookbook.model.dto.RecipeDTO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface RecipeService {
    void createRecipe(RecipeForm form);
    RecipeDTO getOne(Long id);
    List<RecipeDTO> getAll();
    void update(Long id, Map<String, Objects> updateData);
    void delete(Long id);
}
