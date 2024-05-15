package cheddarcheese.Foods.Interfaces;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Recettes {
    Recette[] value();
}