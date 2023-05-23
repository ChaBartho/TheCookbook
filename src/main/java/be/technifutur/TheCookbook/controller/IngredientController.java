package be.technifutur.TheCookbook.controller;

import be.technifutur.TheCookbook.form.IngredientForm;
import be.technifutur.TheCookbook.form.update.IngredientUpdateForm;
import be.technifutur.TheCookbook.model.dto.AlimentDTO;
import be.technifutur.TheCookbook.model.dto.IngredientDTO;
import be.technifutur.TheCookbook.service.AlimentService;
import be.technifutur.TheCookbook.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    private final AlimentService alimentService;
    public IngredientController(IngredientService ingredientService, AlimentService alimentService) {
        this.ingredientService = ingredientService;
        this.alimentService = alimentService;
    }
    @PostMapping("/add")
    public void create(@RequestBody @Valid IngredientForm form){
        ingredientService.createIngredient(form);
    }
    @GetMapping("/{id:[0-9]+}")
    public IngredientDTO getOne(@RequestBody @PathVariable("id") Long id) throws Exception {
        try {
            return ingredientService.getIngredient(id);
        } catch (Exception e){
            throw new Exception(e);
        }
    }
    @GetMapping("/all")
    public List<IngredientDTO> getAll(){
        return ingredientService.getAllIngredients();
    }
    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@PathVariable Long id){
        ingredientService.deleteIngredient(id);
    }




// A VERIFIER :
    @PatchMapping(path = "/{id:[0-9]+}/update")
    public void update(@PathVariable Long id, @RequestParam IngredientUpdateForm form) {
        ingredientService.update(id, form);
    }
    @DeleteMapping("/deleteall")
    public void clear(){
        ingredientService.clearIngredients();
    }

}


