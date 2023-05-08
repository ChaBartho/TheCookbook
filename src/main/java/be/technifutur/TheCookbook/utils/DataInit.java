package be.technifutur.TheCookbook.utils;

import be.technifutur.TheCookbook.model.entity.*;
import be.technifutur.TheCookbook.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements InitializingBean {
    private final AlimentRepository alimentRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;
    private final ShoppingListRepository shoppingListRepository;
    private final UserRepository userRepository;


    public DataInit(AlimentRepository alimentRepository,
                    IngredientRepository ingredientRepository,
                    RecipeRepository recipeRepository,
                    ShoppingListRepository shoppingListRepository,
                    UserRepository userRepository) {
        this.alimentRepository = alimentRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//NEW USER
        User user = new User();
        user.setUsername("Pierre");
        user.setEmail("pierre@gmail.com");
        user.setPassword("pass");
        userRepository.save(user);

        User user1 = new User();
        user1.setUsername("Paul");
        user1.setEmail("paul@gmail.com");
        user1.setPassword("pass");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("Jacques");
        user2.setEmail("jacques@gmail.com");
        user2.setPassword("pass");
        userRepository.save(user2);

        User user3 = new User();
        user3.setUsername("Marie-Odile");
        user3.setEmail("marie-odile@gmail.com");
        user3.setPassword("pass");
        userRepository.save(user3);

        User user4 = new User();
        user4.setUsername("Marie-Thérèse");
        user4.setEmail("marie-therese@gmail.com");
        user4.setPassword("pass");
        userRepository.save(user4);

        User user5 = new User();
        user5.setUsername("Julie");
        user5.setEmail("julie@gmail.com");
        user5.setPassword("pass");
        userRepository.save(user5);

//NEW ALIMENT
        Aliment aliment = new Aliment();
        aliment.setName("Oeuf");
        alimentRepository.save(aliment);

        Aliment aliment1 = new Aliment();
        aliment1.setName("Lait");
        alimentRepository.save(aliment1);

        Aliment aliment2 = new Aliment();
        aliment2.setName("Farine");
        alimentRepository.save(aliment2);

        Aliment aliment3 = new Aliment();
        aliment3.setName("Sucre");
        alimentRepository.save(aliment3);

        Aliment aliment4 = new Aliment();
        aliment4.setName("Chocolat");
        alimentRepository.save(aliment4);

        Aliment aliment5 = new Aliment();
        aliment5.setName("Sel");
        alimentRepository.save(aliment5);

        Aliment aliment6 = new Aliment();
        aliment6.setName("Levure");
        alimentRepository.save(aliment6);


    }
}
