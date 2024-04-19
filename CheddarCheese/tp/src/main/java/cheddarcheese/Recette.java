package cheddarcheese;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(value = Recettes.class)
public @interface Recette {
    Class<? extends Food>[] ingredients();
    Class<? extends Food> top();
    Class<? extends Food> transformsTo();
}
