package be.technifutur.TheCookbook.model.dto;

import be.technifutur.TheCookbook.model.entity.Aliment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDTO {
    private Long id;
    private int quantity;
    private String uniteMesure;
    private String name;
}
