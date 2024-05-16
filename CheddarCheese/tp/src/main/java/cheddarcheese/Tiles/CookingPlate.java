package cheddarcheese.Tiles;

import java.lang.reflect.InvocationTargetException;

import cheddarcheese.GameManager;
import cheddarcheese.Foods.Food;

public class CookingPlate extends Machine implements InteractTile{
    public CookingPlate(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    //Transforms the item if it uses the cooking plate
    @Override
    public void interact(GameManager gm) {
        try {
            if (holding instanceof Food) {
                Food transformedFood = TryTransform((Food) holding, this);
                holding = transformedFood;
            }
        } catch (InstantiationException | IllegalAccessException | InterruptedException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
