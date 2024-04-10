package cheddarcheese.Tiles;

import cheddarcheese.Player;

public class Bin extends Tile implements InteractTile{
    public Bin(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    @Override
    public void interact(Player p) {
        p.getInventory().deleteItem();
    }
}
