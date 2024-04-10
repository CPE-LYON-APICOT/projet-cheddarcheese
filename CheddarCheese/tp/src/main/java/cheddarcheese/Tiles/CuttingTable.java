package cheddarcheese.Tiles;

import java.lang.reflect.InvocationTargetException;

import cheddarcheese.Food;
import cheddarcheese.Player;

public class CuttingTable extends Machine implements InteractTile{
    public CuttingTable(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    @Override
    public void interact(Player p) {
        try {
            if (holding instanceof Food) {
                Food transformedFood = TryTransform((Food) holding, this);
                holding = transformedFood;
            }
        } catch (InstantiationException | IllegalAccessException | InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
