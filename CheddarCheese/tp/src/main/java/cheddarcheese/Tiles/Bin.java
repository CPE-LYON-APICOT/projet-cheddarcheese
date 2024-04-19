package cheddarcheese.Tiles;

import cheddarcheese.GameManager;
import cheddarcheese.Player;

public class Bin extends Tile implements InteractTile{
    public Bin(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    @Override
    public void interact(GameManager gm) {
        gm.getPlayer().getInventory().deleteItem();
    }
}
