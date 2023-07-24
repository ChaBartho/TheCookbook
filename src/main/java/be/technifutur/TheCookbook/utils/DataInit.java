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
        crepe.setTempsCuisson("Jusqu'à ce que mort s'en suive");
        recipeRepository.save(crepe);

        Recipe cake = new Recipe();
        cake.setId(3L);
        cake.setName("Cake");
        cake.setInstruction("En voilà des instructions claires et précises ! Aaaah chic alors !");
        cake.setTempsCuisson("200°C");
        recipeRepository.save(cake);

        Recipe clafoutis = new Recipe();
        clafoutis.setId(4L);
        clafoutis.setName("Clafoutis");
        clafoutis.setInstruction("Qu'est-ce que c'est chouette d'être dans l'eau !");
        clafoutis.setTempsCuisson("1000°C");
        recipeRepository.save(clafoutis);

        Recipe tiramisu = new Recipe();
        tiramisu.setId(5L);
        tiramisu.setName("Tiramisu");
        tiramisu.setInstruction("Encore un qui contient assez de rhum pour réveiller un mort...");
        tiramisu.setTempsCuisson("au frigo minimum 1h");
        recipeRepository.save(tiramisu);



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
        huileCoco.setId(4L);
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
        ingredientCookies1.setQuantity(1);
        ingredientCookies1.setUniteMesure(" ");
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


        Ingredient ingredientCake1 = new Ingredient();
        ingredientCake1.setId(7L);
        ingredientCake1.setAliment(oeuf);
        ingredientCake1.setRecipe(cake);
        ingredientCake1.setQuantity(1);
        ingredientCake1.setUniteMesure(" ");
        ingredientRepository.save(ingredientCake1);

        Ingredient ingredientCake2 = new Ingredient();
        ingredientCake2.setId(8L);
        ingredientCake2.setAliment(farine);
        ingredientCake2.setRecipe(cake);
        ingredientCake2.setQuantity(200);
        ingredientCake2.setUniteMesure("gr");
        ingredientRepository.save(ingredientCake2);

        Ingredient ingredientCake3 = new Ingredient();
        ingredientCake3.setId(9L);
        ingredientCake3.setAliment(cassonnade);
        ingredientCake3.setRecipe(cake);
        ingredientCake3.setQuantity(180);
        ingredientCake3.setUniteMesure("gr");
        ingredientRepository.save(ingredientCake3);


        Ingredient ingredientClafoutis1 = new Ingredient();
        ingredientClafoutis1.setId(10L);
        ingredientClafoutis1.setAliment(oeuf);
        ingredientClafoutis1.setRecipe(clafoutis);
        ingredientClafoutis1.setQuantity(1);
        ingredientClafoutis1.setUniteMesure(" ");
        ingredientRepository.save(ingredientClafoutis1);

        Ingredient ingredientClafoutis2 = new Ingredient();
        ingredientClafoutis2.setId(11L);
        ingredientClafoutis2.setAliment(lait);
        ingredientClafoutis2.setRecipe(clafoutis);
        ingredientClafoutis2.setQuantity(500);
        ingredientClafoutis2.setUniteMesure("ml");
        ingredientRepository.save(ingredientClafoutis2);

        Ingredient ingredientClafoutis3 = new Ingredient();
        ingredientClafoutis3.setId(12L);
        ingredientClafoutis3.setAliment(farine);
        ingredientClafoutis3.setRecipe(clafoutis);
        ingredientClafoutis3.setQuantity(150);
        ingredientClafoutis3.setUniteMesure("gr");
        ingredientRepository.save(ingredientClafoutis3);


        Ingredient ingredientTiramisu1 = new Ingredient();
        ingredientTiramisu1.setId(13L);
        ingredientTiramisu1.setAliment(oeuf);
        ingredientTiramisu1.setRecipe(tiramisu);
        ingredientTiramisu1.setQuantity(1);
        ingredientTiramisu1.setUniteMesure(" ");
        ingredientRepository.save(ingredientTiramisu1);

        Ingredient ingredientTiramisu2 = new Ingredient();
        ingredientTiramisu2.setId(14L);
        ingredientTiramisu2.setAliment(lait);
        ingredientTiramisu2.setRecipe(tiramisu);
        ingredientTiramisu2.setQuantity(500);
        ingredientTiramisu2.setUniteMesure("ml");
        ingredientRepository.save(ingredientTiramisu2);

        Ingredient ingredientTiramisu3 = new Ingredient();
        ingredientTiramisu3.setId(15L);
        ingredientTiramisu3.setAliment(farine);
        ingredientTiramisu3.setRecipe(tiramisu);
        ingredientTiramisu3.setQuantity(150);
        ingredientTiramisu3.setUniteMesure("gr");
        ingredientRepository.save(ingredientTiramisu3);





    }
}
