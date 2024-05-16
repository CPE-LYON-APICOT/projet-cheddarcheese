package cheddarcheese.Foods;

import cheddarcheese.Foods.Interfaces.Transformable;
import cheddarcheese.Foods.Interfaces.Transformables;
import cheddarcheese.Tiles.CookingPlate;

@Transformables({
    @Transformable(machine = CookingPlate.class, transformsTo = SteakCooked.class, duration = 10, destroysUponTimeOut = false, bonus = 50)
})
public class Steak extends Food {
    public Steak(int xPos, int yPos) {
        super(xPos, yPos, "Steak");
    }
}
