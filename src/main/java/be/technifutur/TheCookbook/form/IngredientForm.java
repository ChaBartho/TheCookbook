package be.technifutur.TheCookbook.form;

import be.technifutur.TheCookbook.model.entity.Ingredient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IngredientForm {

    @NotNull
    private int quantity;
    @NotNull
    private String uniteMesure;

    public Ingredient toEntity(){
        Ingredient entity = new Ingredient();
        entity.setQuantity(quantity);
        entity.setUniteMesure(uniteMesure);
        return entity;
    }
}
