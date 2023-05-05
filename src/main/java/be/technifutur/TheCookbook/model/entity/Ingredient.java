package be.technifutur.TheCookbook.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Long id;
    private String name;
    private int quantity;
    private String uniteMesure;

    //alimentID
    //recipeID
}
