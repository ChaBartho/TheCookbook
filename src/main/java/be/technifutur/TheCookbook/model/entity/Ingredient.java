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
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "uniteMesure", nullable = false)
    private String uniteMesure;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    @OneToOne
    @JoinColumn(name = "aliment_id", nullable = false)
    private Aliment aliment;
}
