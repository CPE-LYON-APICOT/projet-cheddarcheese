package cheddarcheese;

@Recettes({
    @Recette(ingredients = {SteakCooked.class, SlicedTomato.class, Salad.class}, top = Bread.class, transformsTo = Burger.class),
    @Recette(ingredients = {Junk.class}, top = Bread.class, transformsTo = JunkBurger.class)
})
public class Bread extends BaseForRecipe {
    public Bread(int xPos, int yPos) {
        super(xPos, yPos, "Bread");
    }
}