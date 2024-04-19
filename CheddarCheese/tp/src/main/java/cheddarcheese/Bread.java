package cheddarcheese;

public class Bread extends Food {
    private SlicedTomato slicedTomato;
    private Steak steak;
    private Salad salad;

    public Bread(int xPos, int yPos) {
        super(xPos, yPos, "Bread");
        this.slicedTomato = null;
        this.steak = null;
        this.salad = null;
    }
}
