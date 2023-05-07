package be.technifutur.TheCookbook.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlimentDTO {
    private Long id;
    private String name;
}
