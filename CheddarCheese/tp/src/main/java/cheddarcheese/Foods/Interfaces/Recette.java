package cheddarcheese.Foods.Interfaces;

import java.lang.annotation.*;
import cheddarcheese.Foods.Food;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(value = Recettes.class)
public @interface Recette {
    Class<? extends Food>[] ingredients();
    Class<? extends Food> top();
    Class<? extends Food> transformsTo();
}
