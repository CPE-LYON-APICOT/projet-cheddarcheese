package cheddarcheese;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Transformables {
    Transformable[] value();
}