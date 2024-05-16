package cheddarcheese.Foods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cheddarcheese.Foods.Interfaces.Recette;

public class BaseForRecipe extends Food {
    private List<Food> ingredients;

    public BaseForRecipe(int xPos, int yPos, String name) {
        super(xPos, yPos, name);
        this.ingredients = new ArrayList<>();
    }

    // Set the ingredients for the recipes
    public void setIngredients(Food[] ingredients) {
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients));
    }

    // Add an ingredient to the base's array
    public void addIngredient(Food ingredient) {
        ingredients.add(ingredient);
        ingredient.removeImg();
    }

    // Check if the list of ingredients is complete and if the top is the good one
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
