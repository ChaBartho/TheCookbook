package be.technifutur.TheCookbook.service.impl;

import be.technifutur.TheCookbook.form.IngredientForm;
import be.technifutur.TheCookbook.form.update.IngredientUpdateForm;
import be.technifutur.TheCookbook.mapper.IngredientMapper;
import be.technifutur.TheCookbook.model.dto.IngredientDTO;
import be.technifutur.TheCookbook.model.entity.Ingredient;
import be.technifutur.TheCookbook.repository.IngredientRepository;
import be.technifutur.TheCookbook.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private IngredientRepository ingredientRepository;
    private IngredientMapper ingredientMapper;
    public IngredientServiceImpl(IngredientRepository repo, IngredientMapper mapper){
        this.ingredientRepository = repo;
        this.ingredientMapper = mapper;
    }

    @Override
    public void createIngredient(IngredientForm form) {
        Ingredient entity = form.toEntity();
        ingredientRepository.save(entity);
    }

    @Override
    public IngredientDTO getIngredient(Long id) {
        return ingredientRepository.findById(id)
                .map(ingredientMapper::toDto)
                .orElseThrow();
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
