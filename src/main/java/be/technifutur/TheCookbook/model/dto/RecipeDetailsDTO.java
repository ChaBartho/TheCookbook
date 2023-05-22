package be.technifutur.TheCookbook.model.dto;

import be.technifutur.TheCookbook.model.entity.Ingredient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecipeDetailsDTO {
    private Long id;
    private String name;
    private String instruction;
    private String tempsCuisson;
    private List<IngredientDTO> ingredients;
    @Data
    @Builder
    public static class IngredientDTO {
        private Long id;
        private int quantity;
        private String uniteMesure;
        private AlimentDTO aliments;
        @Data
        @Builder
        public static class AlimentDTO {
            private Long id;
            private String name;
        }
    }
}

