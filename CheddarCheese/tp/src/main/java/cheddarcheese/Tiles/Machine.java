package cheddarcheese.Tiles;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import cheddarcheese.Score;
import cheddarcheese.Foods.Food;
import cheddarcheese.Foods.Interfaces.Transformable;
import cheddarcheese.Foods.Interfaces.Transformables;

public abstract class Machine extends Table {
    public Machine(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    public static Food TryTransform(Food food, Machine machine) throws InstantiationException, IllegalAccessException, InterruptedException, IllegalArgumentException, InvocationTargetException {
        if(food.getClass().isAnnotationPresent(Transformables.class)){
            Transformables transformables = food.getClass().getAnnotation(Transformables.class);
            Transformable[] transformable = transformables.value();
            for (Transformable t : transformable) {
                if(t.machine().equals(machine.getClass())){
                    //Thread.sleep(t.duration() * 1000);
                    Class<? extends Food> transformedClass = t.transformsTo();
                    try {
                        Constructor<? extends Food> constructor = transformedClass.getDeclaredConstructor(int.class, int.class);
                        Food newitem = constructor.newInstance(food.getXPos(), food.getYPos());
                        newitem.setImgView(food.image);
                        Score.getInstance().augmenterScore(t.bonus());
                        return newitem;
                    } catch (NoSuchMethodException e) {
                        System.err.println("No constructor found for " + transformedClass.getSimpleName() + " that takes xcoord and ycoord.");
                        return food; 
                    }
                }
            }
        }
        return food;
    }
}