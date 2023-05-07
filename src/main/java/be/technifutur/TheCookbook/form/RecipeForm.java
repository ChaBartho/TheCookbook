package be.technifutur.TheCookbook.form;

import be.technifutur.TheCookbook.model.entity.Recipe;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecipeForm {
    @NotNull
    private String name;
    @NotNull
    private String instruction;

    public Recipe toEntity(){
        Recipe recipe = new Recipe();
        recipe.setName(this.name);
        recipe.setInstruction(this.instruction);
        return recipe;
    }
}
