package cheddarcheese.Tiles;

import cheddarcheese.GameManager;

public class Deposit extends Tile implements InteractTile{
    public Deposit(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    @Override
    public void interact(GameManager gm) {
        if (gm.getPlayer().getInventory().getItem() != null){
            if (gm.getPlayer().getInventory().getItem().getClass() == gm.getRecipeResult()) {
                gm.selectRandomRecipe();
                gm.getPlayer().getInventory().deleteItem();
            }
        }
    }
}

