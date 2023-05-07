package be.technifutur.TheCookbook.mapper;

import be.technifutur.TheCookbook.model.dto.ShoppingListDTO;
import be.technifutur.TheCookbook.model.entity.ShoppingList;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListMapper {
    public ShoppingListDTO toDto(ShoppingList entity){
        if(entity == null)
            return null;
        return ShoppingListDTO.builder()
                .id((entity.getId()))
                .quantity(entity.getQuantity())
                .creationDate(entity.getCreationDate())
                .build();
    }
}
