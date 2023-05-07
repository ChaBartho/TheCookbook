package be.technifutur.TheCookbook.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "instruction", nullable = false)
    private String instruction;
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredientList;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}