package be.technifutur.TheCookbook.mapper;

import be.technifutur.TheCookbook.model.dto.AlimentDTO;
import be.technifutur.TheCookbook.model.entity.Aliment;
import org.springframework.stereotype.Service;

@Service
public class AlimentMapper {
    public AlimentDTO toDto(Aliment entity){
        if(entity == null)
            return null;
        return AlimentDTO.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .build();
    }
}
