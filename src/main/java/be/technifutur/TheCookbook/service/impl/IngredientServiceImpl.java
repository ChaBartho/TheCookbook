package be.technifutur.TheCookbook.service.impl;

import be.technifutur.TheCookbook.exceptions.RessourceNotFoundException;
import be.technifutur.TheCookbook.form.IngredientForm;
import be.technifutur.TheCookbook.form.update.IngredientUpdateForm;
import be.technifutur.TheCookbook.mapper.IngredientMapper;
import be.technifutur.TheCookbook.model.dto.IngredientDTO;
import be.technifutur.TheCookbook.model.entity.Aliment;
import be.technifutur.TheCookbook.model.entity.Ingredient;
import be.technifutur.TheCookbook.model.entity.Recipe;
import be.technifutur.TheCookbook.repository.AlimentRepository;
import be.technifutur.TheCookbook.repository.IngredientRepository;
import be.technifutur.TheCookbook.repository.RecipeRepository;
import be.technifutur.TheCookbook.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    private AlimentRepository alimentRepository;
    private IngredientMapper ingredientMapper;
    public IngredientServiceImpl(IngredientRepository repo, RecipeRepository recipeRepository, AlimentRepository alimentRepository, IngredientMapper mapper){
        this.ingredientRepository = repo;
        this.recipeRepository = recipeRepository;
        this.alimentRepository = alimentRepository;
        this.ingredientMapper = mapper;
    }

    @Override
    public void createIngredient(IngredientForm form) {
        Ingredient entity = form.toEntity();

        Recipe recipe = recipeRepository.findById(form.getRecipeId()).orElseThrow(RessourceNotFoundException::new);
        Aliment aliment = alimentRepository.findById(form.getAlimentId()).orElseThrow(RessourceNotFoundException::new);

        entity.setRecipe(recipe);
        entity.setAliment(aliment);
        ingredientRepository.save(entity);
    }

    @Override
    public IngredientDTO getIngredient(Long id) {
        return ingredientRepository.findById(id)
                .map(ingredientMapper::toDto)
                .orElseThrow();
    }

    @Override
    public IngredientDTO searchIngredient(String name) {
        return ingredientRepository.searchIngredient(name)
                .map(ingredientMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<IngredientDTO> getAllIngredients() {
        return ingredientRepository.findAll()
                .stream()
                .map(ingredientMapper::toDto)
                .toList();
    }

    @Override
    public List<IngredientDTO> getAllIngredientsByRecipe(Long id) {
        List<Ingredient> ingredients = ingredientRepository.findByRecipeId(id);
        return ingredients.stream()
                .map( entity -> IngredientDTO.builder()
                        .id( entity.getId())
                        .quantity( entity.getQuantity() )
                        .uniteMesure(entity.getUniteMesure() )
                        .name(entity.getAliment().getName())
                        .build()
                )
                .toList();
    }


    @Override
    public void update(Long id, IngredientUpdateForm form) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow();
        ingredient.setQuantity(form.getQuantity());
        ingredient.setUniteMesure(form.getUniteMesure());

        ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.delete(ingredientRepository.findById(id).orElseThrow());
    }

    @Override
    public void clearIngredients() {
        ingredientRepository.deleteAll();

    }
}
