package be.technifutur.TheCookbook.form;

import be.technifutur.TheCookbook.model.entity.Aliment;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AlimentForm {
    @NotNull
    private String name;

    public Aliment toEntity(){
        Aliment entity = new Aliment();
        entity.setName(name);
        return entity;
    }
}
