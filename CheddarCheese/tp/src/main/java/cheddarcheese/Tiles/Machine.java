package cheddarcheese.Tiles;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
                    System.out.println("On peut transformer "+food.getClass().getSimpleName()+" avec "+machine.getClass().getSimpleName()+" en "+t.transformsTo().getSimpleName());
                    //Thread.sleep(t.duration() * 1000);
                    Class<? extends Food> transformedClass = t.transformsTo();
                    try {
                        Constructor<? extends Food> constructor = transformedClass.getDeclaredConstructor(int.class, int.class);
                        Food newitem = constructor.newInstance(food.getXPos(), food.getYPos());
                        newitem.setImgView(food.image);

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