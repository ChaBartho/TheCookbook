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
    @Column(name = "tempsCuisson", nullable = false)
    private String tempsCuisson;
    @OneToMany(mappedBy = "recipe")
    @Column(name = "ingredient_id", nullable = false)
    private List<Ingredient> ingredientList;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;










}