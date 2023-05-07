package be.technifutur.TheCookbook.controller;

import be.technifutur.TheCookbook.service.ShoppingListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppinglist")
public class ShoppingListController {
    private final ShoppingListService shoppingListService;
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

}
