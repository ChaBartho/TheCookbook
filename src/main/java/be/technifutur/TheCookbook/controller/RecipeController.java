package be.technifutur.TheCookbook.controller;

import be.technifutur.TheCookbook.form.RecipeForm;
import be.technifutur.TheCookbook.form.update.RecipeUpdateForm;
import be.technifutur.TheCookbook.model.dto.RecipeDTO;
import be.technifutur.TheCookbook.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
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
            throw new Exception();
        }
    }
    @GetMapping("/all")
    public List<RecipeDTO> getAll(){
        return recipeService.getAllRecipes();
    }
    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@PathVariable Long id){
        recipeService.deleteRecipe(id);
    }



//A VERIFIER
    @PatchMapping(path = "/{id:[0-9]+}/update")
    public void update(@PathVariable Long id, @RequestParam RecipeUpdateForm form) {
        recipeService.update(id, form);
    }
    @DeleteMapping("/deleteall")
    public void clear(){
        recipeService.clearRecipes();
    }
}
