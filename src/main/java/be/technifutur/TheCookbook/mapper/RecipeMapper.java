package be.technifutur.TheCookbook.mapper;

import be.technifutur.TheCookbook.form.RecipeForm;
import be.technifutur.TheCookbook.model.dto.RecipeDTO;
import be.technifutur.TheCookbook.model.entity.Recipe;
import org.springframework.stereotype.Service;
@Service
public class RecipeMapper {
    //1ere méthode (de entity à DTO)
        public RecipeDTO toDto(Recipe entity){
            if(entity == null)
                return null;
            return RecipeDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .instruction(entity.getInstruction())
                    .company(
                            PlaneDTO.CompanyDTO.builder()
                                    .id(entity.getCompany().getId())
                                    .name(entity.getCompany().getName())
                                    .originCountry(entity.getCompany().getOriginCountry())
                                    .build()
                    )
                    .build();
        }

        //2eme méthode (de form vers l'entité)
        public Recipe toEntity(RecipeForm form){
            Recipe entity = new Recipe();
            entity.setName( form.getName() );
            entity.setInstruction( form.getInstruction() );
            return entity;
        }
    }

}
