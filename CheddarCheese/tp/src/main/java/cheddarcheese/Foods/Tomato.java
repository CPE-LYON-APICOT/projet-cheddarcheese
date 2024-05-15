package cheddarcheese.Foods;

import cheddarcheese.Tiles.CuttingTable;
import cheddarcheese.Foods.Interfaces.Transformable;
import cheddarcheese.Foods.Interfaces.Transformables;
import cheddarcheese.Tiles.CookingPlate;

@Transformables({
    @Transformable(machine = CuttingTable.class, transformsTo = SlicedTomato.class, duration = 10, destroysUponTimeOut = false),
    @Transformable(machine = CookingPlate.class, transformsTo = Junk.class, duration = 10, destroysUponTimeOut = false)
})
public class Tomato extends Food {
    public Tomato(int xPos, int yPos) {
        super(xPos, yPos, "Tomato");
    }
}
