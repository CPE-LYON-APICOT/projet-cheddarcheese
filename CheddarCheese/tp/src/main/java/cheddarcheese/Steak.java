package cheddarcheese;

import cheddarcheese.Tiles.CookingPlate;
@Transformables({
    @Transformable(machine = CookingPlate.class, transformsTo = SteakCooked.class, duration = 10, destroysUponTimeOut = false)
})
public class Steak extends Food {
    public Steak(int xPos, int yPos) {
        super(xPos, yPos, "Steak");
    }
}
