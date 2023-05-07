package be.technifutur.TheCookbook.form.update;

import be.technifutur.TheCookbook.model.entity.Ingredient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class IngredientUpdateForm {
    @NotNull
    private String name;
    @NotNull
    private int quantity;
    @NotNull
    private String uniteMesure;

    public Ingredient toEntity(){
        Ingredient entity = new Ingredient();
        entity.setName(name);
        entity.setQuantity(quantity);
        entity.setUniteMesure(uniteMesure);
        return entity;
    }
}
