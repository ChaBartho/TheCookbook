package be.technifutur.TheCookbook.service;

import be.technifutur.TheCookbook.form.IngredientForm;

import be.technifutur.TheCookbook.model.dto.IngredientDTO;


import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface IngredientService {
    void createIngredient(IngredientForm form);
    IngredientDTO getOne(Long id);
    List<IngredientDTO> getAll();
    void update(Long id, Map<String, Objects> updateData);
    void delete(Long id);
}
