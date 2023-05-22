package be.technifutur.TheCookbook.mapper;

import be.technifutur.TheCookbook.model.dto.IngredientDTO;
import be.technifutur.TheCookbook.model.entity.Ingredient;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper {
    public IngredientDTO toDto(Ingredient entity){
        if(entity == null)
            return null;
        return IngredientDTO.builder()
                            .id(entity.getId())
                            .quantity(entity.getQuantity())
                            .uniteMesure(entity.getUniteMesure())
                            .build();
    }
}
