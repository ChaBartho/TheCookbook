package be.technifutur.TheCookbook.mapper;

import be.technifutur.TheCookbook.model.dto.RecipeDTO;
import be.technifutur.TheCookbook.model.entity.Recipe;
import org.springframework.stereotype.Service;
@Service
public class RecipeMapper {
        public RecipeDTO toDto(Recipe entity){
            if(entity == null)
                return null;
            return RecipeDTO.builder()
                            .id(entity.getId())
                            .name(entity.getName())
                            .instruction(entity.getInstruction())
                            .tempsCuisson(entity.getTempsCuisson())
                            .build();
        }
}
