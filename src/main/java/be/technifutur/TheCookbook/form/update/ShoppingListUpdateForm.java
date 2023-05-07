package be.technifutur.TheCookbook.form.update;

import be.technifutur.TheCookbook.model.entity.ShoppingList;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
public class ShoppingListUpdateForm {
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
