package be.technifutur.TheCookbook.controller;

import be.technifutur.TheCookbook.form.ShoppingListForm;
import be.technifutur.TheCookbook.form.update.ShoppingListUpdateForm;
import be.technifutur.TheCookbook.model.dto.ShoppingListDTO;
import be.technifutur.TheCookbook.service.ShoppingListService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/shoppinglist")
public class ShoppingListController {
    private final ShoppingListService shoppingListService;
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }
    @PostMapping("/add")
    public void create(@RequestBody @Valid ShoppingListForm form) {
        shoppingListService.createShoppinglist(form);
    }
    @GetMapping("/{id:[0-9]+}")
    public ShoppingListDTO getOne(@RequestBody @PathVariable("id") Long id) throws Exception {
        try {
            return shoppingListService.getShoppinglist(id);
        } catch (Exception e){
            throw new Exception(e);
        }
    }
    @GetMapping("/all")
    public List<ShoppingListDTO> getAll(){
        return shoppingListService.getAllShoppinglist();
    }
    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@PathVariable Long id){
        shoppingListService.deleteShoppinglist(id);
    }



//A VERIFIER
    @PatchMapping(path = "/{id:[0-9]+}/update")
    public void update(@PathVariable Long id, @RequestParam ShoppingListUpdateForm form){
        shoppingListService.update(id, form);
    }
    @DeleteMapping("/deleteall")
    public void clear(){
        shoppingListService.clearShoppingList();
    }


}
