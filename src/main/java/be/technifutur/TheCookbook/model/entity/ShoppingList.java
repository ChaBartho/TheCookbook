package be.technifutur.TheCookbook.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoppinglist_id", nullable = false)
    private Long id;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;









    //@OneToMany (mappedBy = "shoppinglist")
    //private List<Ingredient> ingredientShoppinglist;
}
