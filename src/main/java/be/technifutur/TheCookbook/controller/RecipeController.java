package be.technifutur.TheCookbook.controller;

import be.technifutur.TheCookbook.form.RecipeForm;
import be.technifutur.TheCookbook.form.update.RecipeUpdateForm;
import be.technifutur.TheCookbook.model.dto.IngredientDTO;
import be.technifutur.TheCookbook.model.dto.RecipeDTO;
import be.technifutur.TheCookbook.service.IngredientService;
import be.technifutur.TheCookbook.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @PostMapping("/add")
    public void create(@RequestBody @Valid RecipeForm form){
        recipeService.createRecipe(form);
    }
    @GetMapping("/{id:[0-9]+}")
    public RecipeDTO getOne(@RequestBody @PathVariable("id") Long id) throws Exception {
        try {
            return recipeService.getRecipe(id);
        } catch (Exception e){
            throw new Exception(e);
        }
    }
    @GetMapping("/all")
    public List<RecipeDTO> getAll(){
        return recipeService.getAllRecipes();
    }
    @DeleteMapping("/{id:[0-9]+}/delete")
    public void delete(@PathVariable Long id){
        recipeService.deleteRecipe(id);
    }
    @GetMapping("/{id:[0-9]+}/ingredients")
    public List<IngredientDTO> getIngredientsByRecipe(@RequestBody @PathVariable("id") Long id) throws Exception {
        try {
            return ingredientService.getAllIngredientsByRecipe(id);
        } catch (Exception e){
            throw new Exception(e);
        }
    }




//A VERIFIER
    @PatchMapping( "/{id:[0-9]+}/update")
    public void update(@PathVariable Long id, @RequestParam RecipeUpdateForm form) {
        recipeService.update(id, form);
    }
    @DeleteMapping("/deleteall")
    public void clear(){
        recipeService.clearRecipes();
    }


}
