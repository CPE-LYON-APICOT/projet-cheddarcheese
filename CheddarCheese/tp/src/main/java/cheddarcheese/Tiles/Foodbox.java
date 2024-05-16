package cheddarcheese.Tiles;

import java.lang.reflect.Constructor;

import cheddarcheese.GameManager;
import cheddarcheese.Item;

public class Foodbox extends Table implements InteractTile{
    private Class<?> containedClass;

    public Foodbox(String label, String path, int x, int y, Class<?> containedClass) {
        super(label, path, x, y);
        this.containedClass = containedClass;
    }

    //Spawns an item of corresponding quality when interacted with, only if there's not already one
    @Override
    public void interact(GameManager gm) {
        if (this.holding == null && containedClass != null) {
            try {
                Constructor<?> constructor = containedClass.getConstructor(int.class, int.class);

                Object item = constructor.newInstance(getX(), getY());

                gm.addItemToMap((Item)item, getX(), getY());

                setItem((Item)item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
