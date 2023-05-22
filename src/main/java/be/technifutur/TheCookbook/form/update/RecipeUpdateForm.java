package be.technifutur.TheCookbook.form.update;

import be.technifutur.TheCookbook.model.entity.Ingredient;
import be.technifutur.TheCookbook.model.entity.Recipe;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class RecipeUpdateForm {
    @NotNull
    private String name;
    @NotNull
    private String instruction;
    @NotNull
    private String tempsCuisson;
    @NotNull
    private List<Ingredient> ingredientList;

    public Recipe toEntity(){
        Recipe recipe = new Recipe();
        recipe.setName(this.name);
        recipe.setInstruction(this.instruction);
        recipe.setTempsCuisson(this.tempsCuisson);
        recipe.setIngredientList(this.ingredientList);
        return recipe;
    }
}
