package cheddarcheese.Foods.Interfaces;

import cheddarcheese.Foods.Food;
import cheddarcheese.Tiles.Machine;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(value = Transformables.class)
public @interface Transformable {
    Class<? extends Machine> machine();
    int duration() default 10;
    Class<? extends Food> transformsTo();
    boolean destroysUponTimeOut() default false;
    int bonus() default 30;
}
