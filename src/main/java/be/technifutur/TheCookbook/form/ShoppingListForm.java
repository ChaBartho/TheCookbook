package be.technifutur.TheCookbook.form;

import be.technifutur.TheCookbook.model.entity.ShoppingList;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShoppingListForm {
    @NotNull
    private int quantity;
    @NotNull
    private LocalDateTime creationDate;

    public ShoppingList toEntity(){
        ShoppingList entity = new ShoppingList();
        entity.setQuantity(quantity);
        entity.setCreationDate(creationDate);
        return entity;
    }
}
