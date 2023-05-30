package be.technifutur.TheCookbook.form;

import be.technifutur.TheCookbook.model.entity.Recipe;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class RecipeForm {
    @NotNull
    private String name;
    @NotNull
    private String instruction;
    @NotNull
    private String tempsCuisson;

   private List<IngredientForm> ingredients = new ArrayList<>();;

    public Recipe toEntity(){
        Recipe recipe = new Recipe();
        recipe.setName(this.name);
        recipe.setInstruction(this.instruction);
        recipe.setTempsCuisson(this.tempsCuisson);
        return recipe;
    }
}
