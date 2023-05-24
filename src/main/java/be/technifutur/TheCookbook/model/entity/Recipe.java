package be.technifutur.TheCookbook.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter @Setter
@SQLDelete(sql = "UPDATE Recipe  SET deleted = true WHERE recipe_id=?")
@Where(clause = "deleted=false")
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
    @Column(nullable = false)
    private boolean deleted = Boolean.FALSE;










}