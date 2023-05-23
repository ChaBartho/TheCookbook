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

//NEW RECIPE
        Recipe cookies = new Recipe();
        cookies.setId(1L);
        cookies.setName("Cookies");
        cookies.setInstruction("Mélange la pâte avec les pépites de chocolat");
        cookies.setTempsCuisson("15min à 180°C");
        recipeRepository.save(cookies);

        Recipe crepe = new Recipe();
        crepe.setId(2L);
        crepe.setName("Crepes");
        crepe.setInstruction("Le secret c'est une poële bien chaude");
        crepe.setTempsCuisson("1000°C");
        recipeRepository.save(crepe);

//NEW ALIMENT
        Aliment oeuf = new Aliment();
        oeuf.setId(1L);
        oeuf.setName("Oeuf");
        alimentRepository.save(oeuf);

        Aliment farine = new Aliment();
        farine.setId(2L);
        farine.setName("Farine");
        alimentRepository.save(farine);

        Aliment cassonnade = new Aliment();
        cassonnade.setId(3L);
        cassonnade.setName("Cassonnade");
        alimentRepository.save(cassonnade);

        Aliment huileCoco = new Aliment();
        oeuf.setId(4L);
        huileCoco.setName("Huile de coco");
        alimentRepository.save(huileCoco);

        Aliment pepiteChocolat = new Aliment();
        pepiteChocolat.setId(5L);
        pepiteChocolat.setName("Pépites de chocolat");
        alimentRepository.save(pepiteChocolat);

        Aliment lait = new Aliment();
        lait.setId(6L);
        lait.setName("Lait");
        alimentRepository.save(lait);

//NEW INGREDIENT
        Ingredient ingredientCookies1 = new Ingredient();
        ingredientCookies1.setId(1L);
        ingredientCookies1.setAliment(oeuf);
        ingredientCookies1.setRecipe(cookies);
        ingredientCookies1.setQuantity(100);
        ingredientCookies1.setUniteMesure("gr");
        ingredientRepository.save(ingredientCookies1);

        Ingredient ingredientCookies2 = new Ingredient();
        ingredientCookies2.setId(2L);
        ingredientCookies2.setAliment(cassonnade);
        ingredientCookies2.setRecipe(cookies);
        ingredientCookies2.setQuantity(160);
        ingredientCookies2.setUniteMesure("gr");
        ingredientRepository.save(ingredientCookies2);

        Ingredient ingredientCookies3 = new Ingredient();
        ingredientCookies3.setId(3L);
        ingredientCookies3.setAliment(pepiteChocolat);
        ingredientCookies3.setRecipe(cookies);
        ingredientCookies3.setQuantity(100);
        ingredientCookies3.setUniteMesure("gr");
        ingredientRepository.save(ingredientCookies3);

        Ingredient ingredientCrepe1 = new Ingredient();
        ingredientCrepe1.setId(4L);
        ingredientCrepe1.setAliment(oeuf);
        ingredientCrepe1.setRecipe(crepe);
        ingredientCrepe1.setQuantity(1);
        ingredientCrepe1.setUniteMesure(" ");
        ingredientRepository.save(ingredientCrepe1);

        Ingredient ingredientCrepe2 = new Ingredient();
        ingredientCrepe2.setId(5L);
        ingredientCrepe2.setAliment(lait);
        ingredientCrepe2.setRecipe(crepe);
        ingredientCrepe2.setQuantity(500);
        ingredientCrepe2.setUniteMesure("ml");
        ingredientRepository.save(ingredientCrepe2);

        Ingredient ingredientCrepe3 = new Ingredient();
        ingredientCrepe3.setId(6L);
        ingredientCrepe3.setAliment(farine);
        ingredientCrepe3.setRecipe(crepe);
        ingredientCrepe3.setQuantity(150);
        ingredientCrepe3.setUniteMesure("gr");
        ingredientRepository.save(ingredientCrepe3);





////NEW LIST INGREDIENTS
//        List<Ingredient> listCookies = new ArrayList<>();
//        listCookies.add(ingredientCookies1);
//        listCookies.add(ingredientCookies2);
//        listCookies.add(ingredientCookies3);
//
//        List<Ingredient> listCrepe = new ArrayList<>();
//        listCrepe.add(ingredientCrepe1);
//        listCrepe.add(ingredientCrepe2);
//        listCrepe.add(ingredientCrepe3);





    }
}
