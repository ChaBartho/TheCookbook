package be.technifutur.TheCookbook.utils;

import be.technifutur.TheCookbook.model.entity.*;
import be.technifutur.TheCookbook.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

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
//        User user = new User();
//        user.setUsername("Pierre");
//        user.setEmail("pierre@gmail.com");
//        user.setPassword("pass");
//        userRepository.save(user);
//
//        User user1 = new User();
//        user1.setUsername("Paul");
//        user1.setEmail("paul@gmail.com");
//        user1.setPassword("pass");
//        userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setUsername("Jacques");
//        user2.setEmail("jacques@gmail.com");
//        user2.setPassword("pass");
//        userRepository.save(user2);

//NEW ALIMENT
        Aliment aliment = new Aliment();
        aliment.setName("Oeuf");
        alimentRepository.save(aliment);

        Aliment aliment1 = new Aliment();
        aliment1.setName("Lait");
        alimentRepository.save(aliment1);

        Aliment aliment2 = new Aliment();
        aliment2.setName("Beurre");
        alimentRepository.save(aliment2);

        Aliment aliment3 = new Aliment();
        aliment3.setName("Huile de coco");
        alimentRepository.save(aliment3);

        Aliment aliment4 = new Aliment();
        aliment4.setName("Fromage frais");
        alimentRepository.save(aliment4);

        Aliment aliment5 = new Aliment();
        aliment5.setName("Crème fraîche");
        alimentRepository.save(aliment5);

        Aliment aliment6 = new Aliment();
        aliment6.setName("Farine");
        alimentRepository.save(aliment6);

        Aliment aliment7 = new Aliment();
        aliment7.setName("Amande en poudre");
        alimentRepository.save(aliment7);

        Aliment aliment8 = new Aliment();
        aliment8.setName("Flocon d'avoine");
        alimentRepository.save(aliment8);

        Aliment aliment9 = new Aliment();
        aliment9.setName("Fécule de maïs");
        alimentRepository.save(aliment9);

        Aliment aliment10 = new Aliment();
        aliment10.setName("Levure");
        alimentRepository.save(aliment10);

        Aliment aliment11 = new Aliment();
        aliment11.setName("Sel");
        alimentRepository.save(aliment11);

        Aliment aliment12 = new Aliment();
        aliment12.setName("Sucre");
        alimentRepository.save(aliment12);

        Aliment aliment13 = new Aliment();
        aliment13.setName("Sucre glace");
        alimentRepository.save(aliment13);

        Aliment aliment14 = new Aliment();
        aliment14.setName("Cassonnade");
        alimentRepository.save(aliment14);

        Aliment aliment15 = new Aliment();
        aliment15.setName("Sucre roux");
        alimentRepository.save(aliment15);

        Aliment aliment16 = new Aliment();
        aliment16.setName("Sucre vanillé");
        alimentRepository.save(aliment16);

        Aliment aliment17 = new Aliment();
        aliment17.setName("Fruits secs");
        alimentRepository.save(aliment17);

        Aliment aliment18 = new Aliment();
        aliment18.setName("Chocolat (pépites)");
        alimentRepository.save(aliment18);

        Aliment aliment19 = new Aliment();
        aliment19.setName("Chocolat (fondu)");
        alimentRepository.save(aliment19);

        Aliment aliment20 = new Aliment();
        aliment20.setName("feuille de gélatine");
        alimentRepository.save(aliment20);

        Aliment aliment21 = new Aliment();
        aliment21.setName("Agar-agar");
        alimentRepository.save(aliment21);

        Aliment aliment22 = new Aliment();
        aliment22.setName("Noix concassées");
        alimentRepository.save(aliment22);

        Aliment aliment23 = new Aliment();
        aliment23.setName("Vanille");
        alimentRepository.save(aliment23);

        Aliment aliment24 = new Aliment();
        aliment24.setName("Banane");
        alimentRepository.save(aliment24);

        Aliment aliment25 = new Aliment();
        aliment25.setName("Pomme");
        alimentRepository.save(aliment25);

        Aliment aliment26 = new Aliment();
        aliment26.setName("Poire");
        alimentRepository.save(aliment26);

        Aliment aliment27 = new Aliment();
        aliment27.setName("Eau");
        alimentRepository.save(aliment27);

        Aliment aliment28 = new Aliment();
        aliment28.setName("Blanc d'oeuf");
        alimentRepository.save(aliment28);

        Aliment aliment29 = new Aliment();
        aliment29.setName("Sucre perlé");
        alimentRepository.save(aliment29);

        Aliment aliment30 = new Aliment();
        aliment30.setName("Levure boulanger");
        alimentRepository.save(aliment30);

        Aliment aliment31 = new Aliment();
        aliment31.setName("Miel");
        alimentRepository.save(aliment31);

        Aliment aliment32 = new Aliment();
        aliment32.setName("Jus de citron");
        alimentRepository.save(aliment32);

        Aliment aliment33 = new Aliment();
        aliment33.setName("Citron");
        alimentRepository.save(aliment33);

        Aliment aliment34 = new Aliment();
        aliment34.setName("Orange");
        alimentRepository.save(aliment34);

    }
}
