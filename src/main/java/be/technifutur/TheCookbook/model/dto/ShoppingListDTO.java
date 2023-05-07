package be.technifutur.TheCookbook.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ShoppingListDTO {
    private Long id;
    private int quantity;
    private LocalDateTime creationDate;
}
