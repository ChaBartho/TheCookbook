package be.technifutur.TheCookbook.service.impl;

import be.technifutur.TheCookbook.form.ShoppingListForm;
import be.technifutur.TheCookbook.form.update.ShoppingListUpdateForm;
import be.technifutur.TheCookbook.mapper.ShoppingListMapper;
import be.technifutur.TheCookbook.model.dto.ShoppingListDTO;
import be.technifutur.TheCookbook.model.entity.ShoppingList;
import be.technifutur.TheCookbook.repository.ShoppingListRepository;
import be.technifutur.TheCookbook.service.ShoppingListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {
    private ShoppingListRepository shoppingListRepository;
    private ShoppingListMapper shoppingListMapper;

    public ShoppingListServiceImpl(ShoppingListRepository shoppingListRepository, ShoppingListMapper shoppingListMapper) {
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingListMapper = shoppingListMapper;
    }

    @Override
    public void createShoppinglist(ShoppingListForm form) {
        ShoppingList entity = form.toEntity();
        shoppingListRepository.save(entity);
    }

    @Override
    public ShoppingListDTO getShoppinglist(Long id) {
        return shoppingListRepository.findById(id)
                .map(shoppingListMapper::toDto)
                .orElseThrow();
    }

    @Override
    public List<ShoppingListDTO> getAllShoppinglist() {
        return shoppingListRepository.findAll()
                .stream()
                .map(shoppingListMapper::toDto)
                .toList();
    }

    @Override
    public void update(Long id, ShoppingListUpdateForm form) {
        ShoppingList shoppingList = shoppingListRepository.findById(id)
                .orElseThrow();
        shoppingList.setQuantity(form.getQuantity());
        shoppingList.setCreationDate(form.getCreationDate());

        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void deleteShoppinglist(Long id) {
        shoppingListRepository.delete(shoppingListRepository.findById(id).orElseThrow());
    }

    @Override
    public void clearShoppingList() {
        shoppingListRepository.deleteAll();
    }
}
