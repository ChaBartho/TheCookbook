package be.technifutur.TheCookbook.repository;


import be.technifutur.TheCookbook.model.entity.ShoppingListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopingListItemRepository extends JpaRepository<ShoppingListItem, Long> {
}
