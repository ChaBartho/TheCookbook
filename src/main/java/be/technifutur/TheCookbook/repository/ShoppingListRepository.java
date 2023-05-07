package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
