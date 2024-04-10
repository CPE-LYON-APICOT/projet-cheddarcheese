package cheddarcheese;

import cheddarcheese.Tiles.CuttingTable;
@Transformables({
    @Transformable(machine = CuttingTable.class, transformsTo = SlicedTomato.class, duration = 10, destroysUponTimeOut = false)
})
public class Tomato extends Food {
    public Tomato(int xPos, int yPos) {
        super(xPos, yPos, "Tomato");
    }
}
