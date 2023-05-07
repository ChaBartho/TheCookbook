package be.technifutur.TheCookbook.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ShoppingListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoppinglistitem_id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "aliment_id", nullable = false)
    private Aliment aliment;
    @OneToOne
    @JoinColumn(name = "shoppinglist_id", nullable = false)
    private ShoppingList shoppingList;
}
