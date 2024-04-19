package cheddarcheese;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Recettes({
    @Recette(ingredients = {SteakCooked.class, SlicedTomato.class, Salad.class}, top = Bread.class, transformsTo = Burger.class)
})
public class Bread extends Food {
    private List<Food> ingredients;

    public Bread(int xPos, int yPos) {
        super(xPos, yPos, "Bread");
        this.ingredients = new ArrayList<>();
    }

    public void setIngredients(Food[] ingredients) {
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients));
    }

    public void addIngredient(Food ingredient) {
        ingredients.add(ingredient);
        ingredient.removeImg();
        System.out.println("INGREDIENT");
    }

    public Food checkIngredients(Food topIngredient) {
        for (Recette recette : getClass().getAnnotationsByType(Recette.class)) {
            if (recette.top() == topIngredient.getClass()) {
                List<Class<? extends Food>> recetteIngredients = Arrays.asList(recette.ingredients());
                List<Class<? extends Food>> ingredientClasses = new ArrayList<>();
                for (Food ingredient : ingredients) {
                    ingredientClasses.add(ingredient.getClass());
                }
                if (ingredientClasses.containsAll(recetteIngredients)) {
                    try {
                        return recette.transformsTo().getDeclaredConstructor(int.class, int.class)
                                .newInstance(this.getXPos(), this.getYPos());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return null;
    }
}