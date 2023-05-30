package be.technifutur.TheCookbook.service.impl;


import be.technifutur.TheCookbook.form.IngredientForm;
import be.technifutur.TheCookbook.form.RecipeForm;
import be.technifutur.TheCookbook.form.update.RecipeUpdateForm;
import be.technifutur.TheCookbook.mapper.RecipeMapper;
import be.technifutur.TheCookbook.model.dto.RecipeDTO;
import be.technifutur.TheCookbook.model.entity.Recipe;
import be.technifutur.TheCookbook.repository.IngredientRepository;
import be.technifutur.TheCookbook.repository.RecipeRepository;
import be.technifutur.TheCookbook.service.IngredientService;
import be.technifutur.TheCookbook.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private IngredientService ingredientService;
    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;
    private RecipeMapper recipeMapper;
    public RecipeServiceImpl(IngredientService ingredientService, RecipeRepository recipeRepository, IngredientRepository ingredientRepository, RecipeMapper recipeMapper) {
        this.ingredientService = ingredientService;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public void createRecipe(RecipeForm form) {
        Recipe entity = form.toEntity();
        recipeRepository.save(entity);

        for (IngredientForm ingredient : form.getIngredients()){
            ingredient.setAlimentId(1L);
            ingredient.setRecipeId(entity.getId());
            ingredientService.createIngredient(ingredient);
        }
    }

    @Override
    public RecipeDTO getRecipe(Long id) {
        return recipeRepository.findById(id)
                .map(recipeMapper::toDto)
                .orElseThrow();
    }

    @Override
    public RecipeDTO searchRecipe(String name) {
        return recipeRepository.searchRecipe(name)
                .map(recipeMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toDto)
                .toList();
    }

    @Override
    public void update(Long id, RecipeUpdateForm form) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow();
        recipe.setName(form.getName());
        recipe.setInstruction(form.getInstruction());
        //recipe.setIngredientList(form.toEntity().getIngredientList());

        recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.delete(recipeRepository.findById(id).orElseThrow());
    }

    @Override
    public void clearRecipes() {
        recipeRepository.deleteAll();
    }
}
