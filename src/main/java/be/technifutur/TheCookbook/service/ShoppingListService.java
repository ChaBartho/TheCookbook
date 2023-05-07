package be.technifutur.TheCookbook.service;

import be.technifutur.TheCookbook.form.ShoppingListForm;
import be.technifutur.TheCookbook.form.update.ShoppingListUpdateForm;
import be.technifutur.TheCookbook.model.dto.ShoppingListDTO;

import java.util.List;

public interface ShoppingListService {
    void createShoppinglist(ShoppingListForm form);
    ShoppingListDTO getShoppinglist(Long id);
    List<ShoppingListDTO> getAllShoppinglist();
    void update(Long id, ShoppingListUpdateForm form);
    void deleteShoppinglist(Long id);
    void clearShoppingList();
}
